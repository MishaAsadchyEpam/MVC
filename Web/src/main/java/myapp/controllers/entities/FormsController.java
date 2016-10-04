package myapp.controllers.entities;

import myapp.controllers.users.security.SecurityUtil;
import myapp.entities.Forms;
import myapp.entities.Users;
import myapp.services.FormsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@RequestMapping("/forms/")
@Controller
@PreAuthorize("hasRole('" + "ROLE_USER" + "')")
class FormsController {

    private static final Logger logger = org.apache.log4j.Logger.getLogger(FormsController.class);

    @Autowired
    private FormsService formsService;

    @RequestMapping("")
    public String index(ModelMap model)
    {
        Users user = SecurityUtil.getCurrentUser();
        Forms form = formsService.findByUserId(user.getUserId());

        if (form == null)
        {
            logger.error("Form for user with userId = " + user.getUserId() + " is not exist!");
        }

        model.addAttribute("userForm", form);
        return "/forms/index";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(
            ModelMap model,
            @PathVariable int id)
    {
        model.addAttribute("forms", formsService.find(id));

        model.addAttribute("userPictures", formsService.getUserImages(SecurityUtil.getCurrentUser().getUserId()));
        return "/forms/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(
            @Valid Forms forms,
            Errors errors,
            HttpServletRequest request)
    {
        forms.setMyPhoto(formsService.cutUrl(forms.getMyPhoto()));

        if (errors.hasErrors())
        {
            return "/forms/edit";
        }

        formsService.update(forms);
        return "redirect:/forms/";
    }

}
