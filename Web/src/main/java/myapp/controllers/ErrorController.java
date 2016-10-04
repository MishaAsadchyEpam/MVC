package myapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/error")
class ErrorController {

    @RequestMapping(value = "accessDenied", method = RequestMethod.GET)
    public String error403()
    {
        return "/error/accessDenied";
    }

    @RequestMapping(value = "badAction", method = RequestMethod.GET)
    public String badAction()
    {
        return "/error/badAction";
    }

}
