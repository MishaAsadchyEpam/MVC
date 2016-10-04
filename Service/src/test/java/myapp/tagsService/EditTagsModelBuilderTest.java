package myapp.tagsService;

import myapp.entities.Images;
import myapp.entities.Picturetags;
import myapp.entities.Tags;
import myapp.exceptions.EntityNotFoundException;
import myapp.services.ImagesService;
import myapp.services.PicturetagsService;
import myapp.services.TagsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import pagesModels.TagMarkModel;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class EditTagsModelBuilderTest {

    // tested object
    private EditTagsModelBuilder builder;

    // mockito
    private PicturetagsService picturetagsService;
    private TagsService tagsService;
    private ImagesService imagesService;

    // testing data (lists, specified objects etc)
    private List<Tags> tagsList = new ArrayList<Tags>();
    private List<Picturetags> pictureTagsList = new ArrayList<Picturetags>();

    // test case values
    private int imageId;

    @Before
    public void setUp() throws Exception
    {

        // initialize tested object
        builder = new EditTagsModelBuilder();

        // create mockito objects
        picturetagsService = mock(PicturetagsService.class);
        tagsService = mock(TagsService.class);
        imagesService = mock(ImagesService.class);

        // add shared behavior to mockito objects
        when(imagesService.find(anyInt())).thenReturn(new Images());
        when(tagsService.getAll()).thenReturn(tagsList);
        when(picturetagsService.findByPictureId(anyInt())).thenReturn(pictureTagsList);

        // reflections to real (tested) object
        ReflectionTestUtils.setField(builder, "picturetagsService", picturetagsService);
        ReflectionTestUtils.setField(builder, "tagsService", tagsService);
        ReflectionTestUtils.setField(builder, "imagesService", imagesService);
    }

    public void verifyIncorrect(int findTimes)
    {
        verify(imagesService, times(findTimes)).find(anyInt());
        verify(tagsService, times(0)).getAll();
        verify(picturetagsService, times(0)).findByPictureId(anyInt());
    }

    public void verifyCorrect()
    {
        verify(imagesService, times(1)).find(anyInt());
        verify(tagsService, times(1)).getAll();
        verify(picturetagsService, times(1)).findByPictureId(anyInt());
    }

    public void initTest(int imageId, int tagsListSize, int markedPictureTagsCount)
    {
        this.imageId = imageId;
        generateTagsList(tagsListSize);
        addPictureTags(imageId, markedPictureTagsCount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildModelAllIncorrect() throws Exception
    {

        initTest(-1, 3, 0);

        List<TagMarkModel> tagMarkModelsActual = null;
        try
        {
            // tested method call
            tagMarkModelsActual = builder.buildModel(imageId);
        }
        finally
        {
            // verify stage
            verifyIncorrect(0);

            // asserts
            assertEquals(null, tagMarkModelsActual);
        }
    }

    @Test(expected = EntityNotFoundException.class)
    public void testBuildModelImageNotExist() throws Exception
    {

        initTest(1, 3, 2);

        // add specified behavior for mocks
        when(imagesService.find(anyInt())).thenReturn(null);

        List<TagMarkModel> tagMarkModelsActual = null;
        try
        {
            // tested method call
            tagMarkModelsActual = builder.buildModel(imageId);
        }
        finally
        {
            // verify stage
            verifyIncorrect(1);

            // asserts
            assertEquals(null, tagMarkModelsActual);
        }
    }

    @Test
    public void testBuildModelCorrect() throws Exception
    {
        // local vars
        int pictureTagsCount = 2;

        // init test
        initTest(1, 3, pictureTagsCount);

        List<TagMarkModel> tagMarkModelsActual = null;
        try
        {
            // tested method call
            tagMarkModelsActual = builder.buildModel(imageId);
        }
        finally
        {
            // verify stage
            verifyCorrect();

            // asserts
            assertNotNull(tagMarkModelsActual);
            assertModel(tagMarkModelsActual, pictureTagsCount);
        }
    }

    private void assertModel(List<TagMarkModel> tagMarkModelsActual, int pictureTagsCount)
    {
        final int tagsListSize = tagsList.size();
        for (int i = 0; i < pictureTagsCount; i++)
        {
            assertTrue(tagMarkModelsActual.get(i).getIsChecked());
            assertEquals(tagsList.get(i).getTagName(), tagMarkModelsActual.get(i).getTagName());
        }
        for (int i = pictureTagsCount; i < tagsListSize; i++)
        {
            assertFalse(tagMarkModelsActual.get(i).getIsChecked());
            assertEquals(tagsList.get(i).getTagName(), tagMarkModelsActual.get(i).getTagName());
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

    // count - сколько тэгов с начала добавить
    private void addPictureTags(int pictureId, int count)
    {
        if (count >= tagsList.size())
        {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < count; i++)
        {
            pictureTagsList.add(new Picturetags(i + 1, pictureId));
        }

    }
}