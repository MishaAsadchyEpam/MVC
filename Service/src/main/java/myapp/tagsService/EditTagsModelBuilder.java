package myapp.tagsService;

import myapp.entities.Picturetags;
import myapp.entities.Tags;
import myapp.exceptions.EntityNotFoundException;
import myapp.services.ImagesService;
import myapp.services.PicturetagsService;
import myapp.services.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pagesModels.TagMarkModel;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EditTagsModelBuilder {

    @Autowired
    private PicturetagsService picturetagsService;

    @Autowired
    private TagsService tagsService;

    @Autowired
    private ImagesService imagesService;

    public List<TagMarkModel> buildModel(int imageId) throws EntityNotFoundException
    {
        if (imageId <= 0)
        {
            throw new IllegalArgumentException();
        }

        if (imagesService.find(imageId) == null)
        {
            throw new EntityNotFoundException();
        }

        List<Tags> tags = tagsService.getAll();

        List<Picturetags> existPictureTags = picturetagsService.findByPictureId(imageId);

        List<TagMarkModel> tagMarkModels = new ArrayList<TagMarkModel>(tags.size());
        boolean isMarked;
        for (Tags tag : tags)
        {
            isMarked = false;
            for (Picturetags pictureTag : existPictureTags)
            {
                if (pictureTag.getTagId() == tag.getTagId())
                {
                    isMarked = true;
                    existPictureTags.remove(pictureTag);
                    break;
                }
            }
            tagMarkModels.add(new TagMarkModel(isMarked, tag.getTagName()));
        }

        return tagMarkModels;
    }


}
