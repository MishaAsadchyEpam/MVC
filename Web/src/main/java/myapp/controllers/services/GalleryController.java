package myapp.controllers.services;

import myapp.gallery.GalleryService;
import myapp.media.modelMapEnrichers.impl.MediaFolderModelMapEnricher;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PreAuthorize("hasRole('" + "ROLE_USER" + "')")
@RequestMapping("/gallery/")
class GalleryController {

    private static final Logger logger = Logger.getLogger(GalleryController.class);

    @Autowired
    private GalleryService service;

    @RequestMapping(value = "")
    public String index(ModelMap model)
    {
        model.addAttribute("tagCloud", service.getTags());
        return "/gallery/index";
    }

    @RequestMapping(value = "getPage")
    public String getPage(ModelMap model,
                          @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
                          @RequestParam(value = "tagId", required = false, defaultValue = "0") int tagId)
    {
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("galleryPage", service.getPage(pageNumber, tagId));
        model.addAttribute("pagesCount", service.getPagesCount());
        model.addAttribute("tagId", tagId);

        return "gallery/_getPage";
    }


}
