package myapp.controllers.entities;

import myapp.controllers.users.security.SecurityUtil;
import myapp.exceptions.EntityNotFoundException;
import myapp.media.modelMapEnrichers.ModelMapEnricher;
import myapp.media.modelMapEnrichers.impl.MediaFolderModelMapEnricher;
import myapp.services.ImagesService;
import myapp.services.PicturetagsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pagesModels.EditTagsModel;


@RequestMapping("/picturetags/")
@Controller
@PreAuthorize("hasRole('" + "ROLE_USER" + "')")
class PicturetagsController {

    private static final Logger logger = Logger.getLogger(PicturetagsController.class);

    @Autowired
    private PicturetagsService picturetagsService;

    @Autowired
    private ImagesService imagesService;

    @Autowired
    private MediaFolderModelMapEnricher mediaFolderModelMapEnricher;

    @RequestMapping(value = "add/{imageId}", method = RequestMethod.GET)
    public String save(@PathVariable int imageId, ModelMap model)
    {
        EditTagsModel editTagsModels;

        try
        {
            editTagsModels = new EditTagsModel(picturetagsService.buildTagModel(imageId), imageId);
        }
        catch (EntityNotFoundException e)
        {
            logger.error("Entity not found. Bad boy userId = " + SecurityUtil.getCurrentUser().getUserId());
            return "/error/badAction";
        }
        catch (IllegalArgumentException e)
        {
            logger.error("Illegal arguments. Bad boy userId = " + SecurityUtil.getCurrentUser().getUserId());
            return "/error/badAction";
        }

        String pictureUrl = imagesService.findPictureUrlByPictureId(imageId);

        model.addAttribute("pictureUrl", pictureUrl);
        model.addAttribute("editTagsModels", editTagsModels);
//        mediaFolderModelMapEnricher.enrichModelMap(model);

        return "/picturetags/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String save(
            @ModelAttribute EditTagsModel editTagsModels)
    {
        try
        {
            picturetagsService.saveTags(editTagsModels.getImageId(), editTagsModels.getTagMarkModels());
        }
        catch (EntityNotFoundException e)
        {
            logger.error("Picture not found. Bad boy userId = " + SecurityUtil.getCurrentUser().getUserId());
            return "/error/badAction";
        }
        catch (IllegalArgumentException e)
        {
            logger.error("Bad model state. Bad boy userId = " + SecurityUtil.getCurrentUser().getUserId());
            return "/error/badAction";
        }

        return "redirect:/picturetags/add/" + editTagsModels.getImageId();
    }

}
