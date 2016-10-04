package myapp.controllers.entities;


import myapp.controllers.users.security.SecurityUtil;
import myapp.services.VotesService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/votes/")
@PreAuthorize("hasRole('" + "ROLE_USER" + "')")
@Controller
class VotesController {

    private static final Logger logger = Logger.getLogger(VotesController.class);

    @Autowired
    private VotesService votesService;

    @RequestMapping("like/{pictureId}")
    public String like(ModelMap model, @PathVariable int pictureId)
    {

        Integer userId = SecurityUtil.getCurrentUser().getUserId();

        model.addAttribute("votesNow", votesService.saveOrDelete(pictureId, userId));

        return "votes/_likeCount";
    }
}