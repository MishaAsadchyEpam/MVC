package myapp.tagsService;

import myapp.entities.Images;
import myapp.entities.Picturetags;
import myapp.entities.Tags;
import myapp.exceptions.EntityNotFoundException;
import myapp.hibernateCRUDDao.PicturetagsHibernateCRUDDao;
import myapp.hibernateCRUDDao.TagsHibernateCRUDDao;
import myapp.services.ImagesService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import pagesModels.TagMarkModel;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class EditPictureTagsProcessorTest {

    // real object
    private EditPictureTagsProcessor editPictureTagsProcessor;

    // testing data (lists, specified objects etc)
    private List<Tags> tagsList = new ArrayList<Tags>();

    // mockito
    private PicturetagsHibernateCRUDDao picturetagsHibernateDao;
    private TagsHibernateCRUDDao tagsHibernateDao;
    private ImagesService imagesService;

    // test case shared values
    private int pictureId;
    private int tagsListSize;
    private int addTagsExpected;
    private int deleteTagsExpected;

    @Before
    public void setUp() throws Exception
    {
        // tested object
        editPictureTagsProcessor = new EditPictureTagsProcessor();

        // mocks
        picturetagsHibernateDao = mock(PicturetagsHibernateCRUDDao.class);
        tagsHibernateDao = mock(TagsHibernateCRUDDao.class);
        imagesService = mock(ImagesService.class);

        // reflections
        ReflectionTestUtils.setField(editPictureTagsProcessor, "picturetagsHibernateDao", picturetagsHibernateDao);
        ReflectionTestUtils.setField(editPictureTagsProcessor, "tagsHibernateDao", tagsHibernateDao);
        ReflectionTestUtils.setField(editPictureTagsProcessor, "imagesService", imagesService);
    }

    //  pictureTagsForTestPicture - сколькими тэгами отмечена картинка до редактирования
    private void initializeTestValues(int pictureId, int tagsListSize, int pictureTagsForTestPicture,
                                      int addTagsExpected, int deleteTagsExpected) throws EntityNotFoundException
    {
        this.pictureId = pictureId;
        this.tagsListSize = tagsListSize;
        this.addTagsExpected = addTagsExpected;
        this.deleteTagsExpected = deleteTagsExpected;

        // Use Testing Data
        generateTagsList(tagsListSize);

        // add specified behavior for mocks
        when(imagesService.find(anyInt())).thenReturn(new Images());
        when(picturetagsHibernateDao.findByPictureId(anyInt())).thenReturn(pictureTagsList(pictureId,
                tagsListSize - pictureTagsForTestPicture));
        when(tagsHibernateDao.getAll()).thenReturn(tagsList);
    }

    private void _verifyExpectedCreateDeleteCalls()
    {
        verify(picturetagsHibernateDao, times(addTagsExpected)).save(any(Picturetags.class));
        verify(picturetagsHibernateDao, times(deleteTagsExpected)).delete(anyInt());
    }

    private void _verifyIncorrectCalls()
    {
        verify(picturetagsHibernateDao, times(0)).findByPictureId(anyInt());
        verify(tagsHibernateDao, times(0)).getAll();
    }

    private void verifyCorrect()
    {
        _verifyExpectedCreateDeleteCalls();
        verify(picturetagsHibernateDao, times(1)).findByPictureId(anyInt());
        verify(tagsHibernateDao, times(1)).getAll();
        verify(imagesService, times(1)).find(anyInt());
    }

    private void verifyIncorrect(int findTimes)
    {
        _verifyExpectedCreateDeleteCalls();
        _verifyIncorrectCalls();
        verify(imagesService, times(findTimes)).find(anyInt());
    }

    @Test
    public void testSaveTagsCorrectAddAndDelete() throws Exception
    {

        initializeTestValues(1, 3, 1, 2, 1);

        try
        {
            // tested method call
            editPictureTagsProcessor.editTags(pictureId, tagMarkModel(tagsListSize, addTagsExpected, true));
        }
        finally
        {
            // verify stage
            verifyCorrect();

            // asserts
        }
    }

    @Test
    public void testSaveTagsCorrectOnlyDelete() throws Exception
    {

        initializeTestValues(1, 3, 3, 0, 3);
        final boolean isSelectedTags = false; // отмечены ли все тэги (tagMarkModel)

        try
        {
            // tested method call
            editPictureTagsProcessor.editTags(pictureId, tagMarkModel(tagsListSize, isSelectedTags));
        }
        finally
        {
            // verify stage
            verifyCorrect();

            // asserts
        }
    }

    @Test
    public void testSaveTagsCorrectOnlyAdd() throws Exception
    {

        initializeTestValues(1, 3, 0, 3, 0);

        // local vars
        final boolean isSelectedTags = true; // отмечены ли все тэги (tagMarkModel)

        try
        {
            // tested method call
            editPictureTagsProcessor.editTags(pictureId, tagMarkModel(tagsListSize, isSelectedTags));
        }
        finally
        {
            // verify stage
            verifyCorrect();

            // asserts
        }
    }

    @Test(expected = EntityNotFoundException.class)
    public void testSaveTagsPictureNotFound() throws Exception
    {
        initializeTestValues(1, 3, 0, 0, 0);

        // local vars
        final boolean isSelectedTags = true; // отмечены ли все тэги (tagMarkModel)

        // add specified behavior to mocks
        when(imagesService.find(anyInt())).thenReturn(null);

        try
        {
            // tested method call
            editPictureTagsProcessor.editTags(pictureId, tagMarkModel(tagsListSize, isSelectedTags));
        }
        finally
        {
            // verify stage
            verifyIncorrect(1);

            // asserts
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveTagsPictureIdIncorrect() throws Exception
    {

        initializeTestValues(-1, 3, 0, 0, 0);

        final boolean isSelectedTags = true; // отмечены ли все тэги (tagMarkModel)

        try
        {
            // tested method call
            editPictureTagsProcessor.editTags(pictureId, tagMarkModel(tagsListSize, isSelectedTags));
        }
        finally
        {
            // verify stage
            verifyIncorrect(0);

            // asserts
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveTagsTagMarkModelIncorrect() throws Exception
    {

        initializeTestValues(1, 0, 0, 0, 0);

        try
        {
            // tested method call
            editPictureTagsProcessor.editTags(pictureId, null);
        }
        finally
        {
            // verify stage
            verifyIncorrect(0);

            // asserts
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveTagsAllIncorrect() throws Exception
    {

        initializeTestValues(-1, 0, 0, 0, 0);

        try
        {
            // tested method call
            editPictureTagsProcessor.editTags(pictureId, null);
        }
        finally
        {
            // verify stage
            verifyIncorrect(0);

            // asserts
        }
    }

    // private stubs methods
    private void generateTagsList(int size)
    {
        for (int i = 1; i <= size; i++)
        {
            Tags tag = new Tags();
            tag.setTagName("Tag " + i);
            tag.setTagId(i);
            tagsList.add(tag);
        }
    }

    private List<Picturetags> pictureTagsList(int pictureId, int skip)
    {
        List<Picturetags> resultSet = new ArrayList<Picturetags>();

        final int tagsListSize = tagsList.size();
        for (int i = skip; i < tagsListSize; i++)
        {
            resultSet.add(new Picturetags(i + 1, pictureId));
        }

        return resultSet;
    }

    private List<TagMarkModel> tagMarkModel(int size, boolean isSelected)
    {
        List<TagMarkModel> resultSet = new ArrayList<TagMarkModel>(size);

        for (int i = 0; i < size; i++)
        {
            resultSet.add(new TagMarkModel(isSelected, tagsList.get(i).getTagName()));
        }

        return resultSet;
    }

    // первые 'count' отмечены как 'isSelected', остальные - !'isSelected'
    private List<TagMarkModel> tagMarkModel(int size, int count, boolean isSelected)
    {

        List<TagMarkModel> resultSet = new ArrayList<TagMarkModel>(size);

        for (int i = 0; i < count; i++)
        {
            resultSet.add(new TagMarkModel(isSelected, tagsList.get(i).getTagName()));
        }
        for (int i = count; i < size; i++)
        {
            resultSet.add(new TagMarkModel(!isSelected, tagsList.get(i).getTagName()));
        }

        return resultSet;
    }

}