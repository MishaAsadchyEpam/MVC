package myapp.tagsService;

import myapp.entities.Picturetags;
import myapp.entities.Tags;
import myapp.exceptions.EntityNotFoundException;
import myapp.hibernateCRUDDao.PicturetagsHibernateCRUDDao;
import myapp.hibernateCRUDDao.TagsHibernateCRUDDao;
import myapp.services.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pagesModels.TagMarkModel;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EditPictureTagsProcessor {

    private List<Integer> forDelete;

    private List<Integer> forCreate;

    private List<Tags> allTags;

    @Autowired
    private PicturetagsHibernateCRUDDao picturetagsHibernateDao;

    @Autowired
    private TagsHibernateCRUDDao tagsHibernateDao;

    @Autowired
    private ImagesService imagesService;

    public void editTags(int pictureId, List<TagMarkModel> selectedTags)
            throws EntityNotFoundException
    {
        if (pictureId <= 0 || selectedTags == null || selectedTags.size() == 0)
        {
            throw new IllegalArgumentException();
        }

        if (imagesService.find(pictureId) == null)
        {
            throw new EntityNotFoundException();
        }

        List<Picturetags> existPictureTags = picturetagsHibernateDao.findByPictureId(pictureId);

        allTags = tagsHibernateDao.getAll();

        firstStage(selectedTags);

        List<Integer> filteredList = filterForCreate(existPictureTags);
        if (filteredList.size() != 0)
        {
            for (Integer currentId : filteredList)
            {
                picturetagsHibernateDao.save(new Picturetags(currentId, pictureId));
            }
        }

        filteredList = filterForDelete(existPictureTags);
        if (filteredList.size() != 0)
        {
            for (Integer currentId : filteredList)
            {
                picturetagsHibernateDao.delete(currentId);
            }
        }
    }

    private Integer selectFromTags(String tagName)
    {
        for (Tags tag : allTags)
        {
            if (tag.getTagName().equals(tagName))
            {
                return tag.getTagId();
            }
        }
        return -1;
    }

    private void firstStage(List<TagMarkModel> selectedTags)
    {
        forCreate = new ArrayList<Integer>();
        forDelete = new ArrayList<Integer>();

        for (TagMarkModel currentTagMarkModel : selectedTags)
        {
            if (currentTagMarkModel.getIsChecked())
            {
                forCreate.add(selectFromTags(currentTagMarkModel.getTagName()));
            }
            else
            {
                forDelete.add(selectFromTags(currentTagMarkModel.getTagName()));
            }
        }

    }

    private List<Integer> filterForDelete(List<Picturetags> existTagsForPicture)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (Integer currentTagId : forDelete)
        {
            for (Picturetags currentPictureTag : existTagsForPicture)
            {
                if (currentPictureTag.getTagId() == currentTagId)
                {
                    result.add(currentPictureTag.getPictureTagId());
                    break;
                }
            }
        }

        return result;
    }

    private List<Integer> filterForCreate(List<Picturetags> existTagsForPicture)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (Integer currentTagId : forCreate)
        {
            boolean isFind = false;
            for (Picturetags currentPictureTag : existTagsForPicture)
            {
                if (currentPictureTag.getTagId() == currentTagId)
                {
                    isFind = true;
                    break;
                }
            }
            if (!isFind)
            {
                result.add(currentTagId);
            }
        }

        return result;
    }


}
