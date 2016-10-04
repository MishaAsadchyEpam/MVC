package myapp.controllers.entities;

import myapp.controllers.users.security.SecurityUtil;
import myapp.entities.Message;
import myapp.entities.Users;
import myapp.services.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@RequestMapping("/message/")

@Controller
class MessageController {

    private static final Logger logger = Logger.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String save(ModelMap model,
                       @Valid Message message)
    {
        Users currentUser = SecurityUtil.getCurrentUser();


        message.setUserId(currentUser.getUserId());

        messageService.save(message);

        message.setUsers(currentUser);

        model.addAttribute("message", message);

        return "partial/models/_showMessage";
    }

}