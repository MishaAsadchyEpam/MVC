package myapp.services;

import myapp.entities.Picturetags;
import myapp.exceptions.EntityNotFoundException;
import myapp.hibernateCRUDDao.PicturetagsHibernateCRUDDao;
import myapp.tagsService.EditPictureTagsProcessor;
import myapp.tagsService.EditTagsModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pagesModels.TagMarkModel;

import java.util.List;


@Service
@Transactional
public class PicturetagsService {

    @Autowired
    private PicturetagsHibernateCRUDDao picturetagshibernatedao;

    @Autowired
    private EditPictureTagsProcessor editTagsProcessor;

    @Autowired
    private EditTagsModelBuilder editTagsModelBuilder;

    public List<Picturetags> findByPictureId(int pictureId)
    {
        return picturetagshibernatedao.findByPictureId(pictureId);
    }

    public void saveTags(int pictureId, List<TagMarkModel> selectedTags) throws EntityNotFoundException
    {
        editTagsProcessor.editTags(pictureId, selectedTags);
    }

    public List<TagMarkModel> buildTagModel(int imageId) throws EntityNotFoundException
    {
        return editTagsModelBuilder.buildModel(imageId);
    }


}