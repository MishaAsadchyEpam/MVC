package myapp.controllers.entities;

import myapp.controllers.users.security.SecurityUtil;
import myapp.entities.Forms;
import myapp.entities.Friends;
import myapp.services.FriendsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("/friends/")
@PreAuthorize("hasRole('" + "ROLE_USER" + "')")
@Controller
class FriendsController {

    private static final Logger logger = org.apache.log4j.Logger.getLogger(FriendsController.class);

    @Autowired
    private FriendsService friendsService;

    @RequestMapping("")
    public String index(ModelMap model)
    {
        List<Forms> friendsForms = friendsService.findFriendsForms(SecurityUtil.getCurrentUser().getUserId());

        if (friendsForms.size() == 0)
        {
            return "/friends/findFriends";
        }

        model.addAttribute("myFriendsForms", friendsForms);
        return "/friends/index";
    }

    @RequestMapping(value = "add/{usesId}")
    public String save(@PathVariable int usesId)
    {
        if (usesId <= 0)
        {
            logger.error("Bad user for delete argument!");
            return "/error/badAction";
        }
        int initiatorUserId = SecurityUtil.getCurrentUser().getUserId();
        if (friendsService.findByUsers(initiatorUserId, usesId) == null && initiatorUserId != usesId)
        {
            friendsService.save(new Friends(initiatorUserId, usesId));
            friendsService.save(new Friends(usesId, initiatorUserId));
        }
        return "redirect:/friends/";
    }

    @RequestMapping(value = "delete/{userForDeleteId}")
    public String delete(@PathVariable int userForDeleteId)
    {
        friendsService.delete(SecurityUtil.getCurrentUser().getUserId(), userForDeleteId);
        return "redirect:/friends/";
    }

}