package myapp.controllers.users;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/")
@Controller
class AdminController {

    private static final Logger logger = Logger.getLogger(AdminController.class);

    @RequestMapping("")
    public String index()
    {
        return "/admin/index";
    }

}
