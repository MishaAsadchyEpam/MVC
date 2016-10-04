package myapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/test2")
@Controller
public class TestController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String test()
    {
        return "test2/test";
    }

}
