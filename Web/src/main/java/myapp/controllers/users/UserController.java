package myapp.controllers.users;

import myapp.controllers.users.security.SecurityUtil;
import myapp.entities.Users;
import myapp.serviceContracts.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user/")
@Controller
class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Qualifier("usersService")
    @Autowired
    private IUserService service;

    @RequestMapping("")
    public String index(ModelMap model)
    {
        Users currentUser = service.findUserProfile(SecurityUtil.getCurrentUser().getUserId());

        model.addAttribute("currentUser", currentUser);

        return "/user/index";
    }


}
