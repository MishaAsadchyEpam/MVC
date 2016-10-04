package myapp.controllers.users;

import myapp.controllers.users.security.SecurityUtil;
import myapp.entities.Users;
import myapp.serviceContracts.IUserService;
import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import roles.Roles;

import javax.validation.Valid;

@Controller
@RequestMapping("/account/")
class AccountController {

    private static final Logger logger = Logger.getLogger(AccountController.class);

    @Qualifier("usersService")
    @Autowired
    private IUserService service;

    @RequestMapping(value = "confirmation/{id}/{token}", method = RequestMethod.GET)
    public String confirmation(@PathVariable int id, @PathVariable String token)
    {
        Users user;
        try
        {
            user = service.find(id);
        }
        catch (Exception e)
        {
            logger.info("User with userId = " + SecurityUtil.getCurrentUser().getUserId() + " submitted wrong data: " +
                    "id = " + id);
            return "/account/confirmationFail";
        }

        if (user == null)
        {
            return "/account/confirmationFail";
        }

        if (token.equals(user.getConfirmationToken()))
        {
            user.setConfirmationToken(null);
            user.setRolesString(Roles.ROLE_USER + "");
            service.update(user);
            logger.info("User with userId = " + id + " has activate");
            return "/account/confirmationSuccess";
        }
        Users currentUser = SecurityUtil.getCurrentUser();

        String userMessage = currentUser == null
                ? "Unregistered user"
                : "User with userId = " + currentUser.getUserId();

        logger.info(userMessage + " has submitted wrong data: id = " + id + ", token = " + token);
        return "/account/confirmationFail";
    }

    @RequestMapping("login")
    public String index()
    {
        return "account/login";
    }


    @RequestMapping("register")
    public String save(ModelMap model)
    {
        model.addAttribute("users", new Users());
        return "/account/register";
    }

    private boolean isAvailable(String username)
    {
        return (service.loadUserByUsername(username) == null);
    }

    @RequestMapping("available")
    @ResponseBody
    public String available(@RequestParam String username)
    {
        return isAvailable(username) + "";
    }

    @RequestMapping("exist")
    @ResponseBody
    public String exist(@RequestParam String username)
    {
        return !isAvailable(username) + "";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(
            @Valid Users users, Errors result,
            @RequestHeader("host") String hostName)
    {
        if (!users.getPassword().equals(users.getPasswordConfirm()))
        {
            result.rejectValue("passwordConfirm", "Bad password confirmation", "Password and password confirm must be" +
                    " equals");
        }
        if (result.hasErrors())
        {
            return "/account/register";
        }

        try
        {
            String password = users.getPassword();

            service.save(users);

            service.generateFormToUser(users.getUsername());

            service.sendEmail(users, hostName, password);
        }
        catch (MailSendException e)
        {
            logger.error("Email to user with userId = " + users.getUserId() + " was not sent to him");
            return "/account/register";
        }
        catch (ConstraintViolationException e)
        {
            logger.info("This user already exist. username = " + users.getUsername());
            result.rejectValue("username", "Bad email", "Такой пользователь уже существует. Введите другой email");
            return "/account/register";
        }

        logger.info("New user has registered. Username = " + users.getUsername());
        return "/account/registrationSuccess";
    }

    @RequestMapping("loginFail")
    public String loginFail()
    {
        return "/account/loginFail";
    }

}
