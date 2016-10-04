package myapp.controllers;

import myapp.controllers.users.security.SecurityUtil;
import myapp.entities.Users;
import myapp.media.modelMapEnrichers.impl.MediaFolderModelMapEnricher;
import myapp.services.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import roles.Roles;

@RequestMapping("/")
@Controller
class HomeController {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HomeController.class);

    @Autowired
    private ImagesService imagesService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(ModelMap model) {
        Users currentUser = SecurityUtil.getCurrentUser();

        if (currentUser != null) {
            String rolesString = currentUser.getRolesString();

            if (rolesString.contains(Roles.ROLE_ADMIN + "")) {
                return "redirect:/admin/";
            } else {
                return "redirect:/user/";
            }
        }
        model.addAttribute("topImages", imagesService.getTopImages(5));

        return "home/hello";
    }

}
