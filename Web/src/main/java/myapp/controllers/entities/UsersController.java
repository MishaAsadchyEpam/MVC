package myapp.controllers.entities;

import myapp.controllers.users.security.SecurityUtil;
import myapp.entities.Friends;
import myapp.entities.Users;
import myapp.media.modelMapEnrichers.impl.MediaFolderModelMapEnricher;
import myapp.serviceContracts.IUserService;
import myapp.services.FriendsService;
import myapp.services.ImagesService;
import myapp.media.MediaPathResolver;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RequestMapping("/users/")
@PreAuthorize("hasRole('" + "ROLE_ADMIN" + "')")
@Controller
class UsersController {

    private static final Logger logger = Logger.getLogger(UsersController.class);

    @Qualifier("usersService")
    @Autowired
    private IUserService usersService;

    @Autowired
    private SessionRegistry sessionRegistry;

    @Autowired
    private FriendsService friendsService;

    @Autowired
    private MediaPathResolver mediaPathResolver;

    @RequestMapping("")
    public String index(ModelMap model)
    {
        List<Users> all = usersService.getAll();

        all.remove(SecurityUtil.getCurrentUser());

        model.addAttribute("userss", all);
        return "/users/index";
    }

    @PreAuthorize("hasRole('" + "ROLE_USER" + "')")
    @RequestMapping("/{userId}")
    public String read(ModelMap model,
                       @PathVariable int userId)
    {
        try
        {
            model.addAttribute("user", usersService.findUserProfile(userId));
        }
        catch (IllegalArgumentException e)
        {
            int badBoy = SecurityUtil.getCurrentUser().getUserId();
            logger.error("Bad user! His userId = " + badBoy);
            return "/error/badAction";
        }

        return "/users/userHomePage";
    }

    @PreAuthorize("hasRole('" + "ROLE_USER" + "')")
    @RequestMapping("peoples/")
    public String peoples(ModelMap model)
    {
        Users currentUser = SecurityUtil.getCurrentUser();

        List<Users> allUsers = usersService.getAll();
        excludeFriends(currentUser, allUsers);
        excludeCurrentUser(currentUser, allUsers);

        model.addAttribute("allUsers", allUsers);
        return "/users/peoples";
    }

    private void excludeCurrentUser(Users currentUser, List<Users> allUsers) {
        allUsers.remove(currentUser);
    }

    private void excludeFriends(Users currentUser, List<Users> allUsers) {
        List<Friends> usersFriends = friendsService.findFriends(currentUser.getUserId());
        for (Friends friend : usersFriends)
        {
            Users forDelete = new Users();
            forDelete.setUserId(friend.getUserIdFirst());
            allUsers.remove(forDelete);
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(ModelMap model, @PathVariable int id)
    {
        Users userForDelete = usersService.find(id);

        model.addAttribute("users", userForDelete);
        return "/users/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(@RequestParam int userId)
    {
        Users userForDelete = usersService.find(userId);

        List<SessionInformation> allSessions = sessionRegistry.getAllSessions(userForDelete, false);
        for (SessionInformation information : allSessions)
        {
            information.expireNow();
        }
        ImagesService.setImageDirectory(mediaPathResolver.getMediaFolderRoot());
        usersService.delete(userId);
        logger.info("Administrator " + SecurityUtil.getCurrentUser().getNickName() + " has deleted user with userId =" +
                " " + userId);
        return "redirect:/users/";
    }

}
