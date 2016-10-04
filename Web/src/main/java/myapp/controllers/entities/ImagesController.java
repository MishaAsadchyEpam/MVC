package myapp.controllers.entities;

import myapp.entities.Images;
import myapp.hibernateCRUDDao.ParamsDao;
import myapp.media.modelMapEnrichers.impl.MediaFolderModelMapEnricher;
import myapp.services.ImagesService;
import myapp.media.MediaPathResolver;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


@RequestMapping("/images/")
@PreAuthorize("hasRole('" + "ROLE_USER" + "')")
@Controller
class ImagesController {

    private static final Logger logger = Logger.getLogger(ImagesController.class);

    @Autowired
    private MediaPathResolver mediaPathResolver;

    @Autowired
    private MediaFolderModelMapEnricher mediaFolderModelMapEnricher;

    @Autowired
    private ImagesService imagesService;

    @Autowired
    private ParamsDao paramsDao;

    @RequestMapping(value = "add/{albumId}", method = RequestMethod.GET)
    public String save(ModelMap model, @PathVariable int albumId)
    {
        model.addAttribute("albumId", albumId);

        return "/images/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String save(
            @RequestParam List<MultipartFile> multipartFiles,
            @RequestParam int albumId)
            throws IOException
    {

        if (!multipartFiles.get(0).getOriginalFilename().equals(""))
        {
            String fileTargetFolder = mediaPathResolver.getMediaFolderRoot();

            int number = Integer.parseInt(paramsDao.findParamValue("lastImageId"));

            for (MultipartFile multipartFile : multipartFiles)
            {
                String originalPictureName = multipartFile.getOriginalFilename();

                String[] fileName = originalPictureName.split("\\.");

                String type = fileName[fileName.length - 1];

                String uniquePictureName = ++number + "." + type;

                String destination = fileTargetFolder + File.separator + uniquePictureName;

                File destinationFile = new File(destination);

                try
                {
                    multipartFile.transferTo(destinationFile);
                }
                catch (FileNotFoundException e)
                {
                    destinationFile.mkdirs();
                    multipartFile.transferTo(destinationFile);
                }


                if (originalPictureName.length() > 30)
                {
                    originalPictureName = "Picture Name";
                }

                Images image = new Images
                        (uniquePictureName, originalPictureName, "Picture Describe", albumId);

                imagesService.save(image);
            }

            paramsDao.updateParam("lastImageId", number + "");
        }
        else
        {
            logger.error("Files not selected");
        }


        return "redirect:/albums/" + albumId;
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(ModelMap model, @PathVariable int id)
    {
        model.addAttribute("images", imagesService.find(id));

        return "/images/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@Valid Images images, Errors errors)
    {
        if (errors.hasErrors())
        {
            return "/images/edit";
        }

        imagesService.update(images);
        return "redirect:/albums/" + images.getAlbumId();
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(ModelMap model, @PathVariable int id)
    {
        Images image = imagesService.find(id);
        if (image == null) {
            return "redirect:/user/";
        }
        model.addAttribute("currentPicture", image);

        return "/images/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(@RequestParam int imageId,
                         @RequestParam int forwardToAlbum)
    {
        ImagesService.setImageDirectory(mediaPathResolver.getMediaFolderRoot());
        imagesService.delete(imageId);
        logger.info("Picture with pictureId = " + imageId + " has deleted");
        return "redirect:/albums/" + forwardToAlbum;
    }


}
