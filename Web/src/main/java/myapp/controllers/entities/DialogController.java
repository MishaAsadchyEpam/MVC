package myapp.controllers.entities;

import myapp.controllers.users.security.SecurityUtil;
import myapp.entities.Dialog;
import myapp.entities.UsersDialog;
import myapp.exceptions.EntityAlreadyExistException;
import myapp.exceptions.EntityNotFoundException;
import myapp.exceptions.UserNotAChatMemberException;
import myapp.services.DialogService;
import myapp.services.UsersDialogService;
import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RequestMapping("/dialog/")
@PreAuthorize("hasRole('" + "ROLE_USER" + "')")
@Controller
class DialogController {

    private static final Logger logger = Logger.getLogger(DialogController.class);

    @Autowired
    private DialogService dialogService;

    @Autowired
    private UsersDialogService usersDialogService;

    @RequestMapping("")
    public String index(ModelMap model)
    {
        int userId = SecurityUtil.getCurrentUser().getUserId();

        List<Dialog> dialogMembers = dialogService.findByUserId(userId);

        if (dialogMembers.size() == 0)
        {
            return "/dialog/haveNotActiveDialogs";
        }

        model.addAttribute("allDialogsForUser", dialogMembers);
        return "/dialog/index";
    }

    @RequestMapping("/{dialogId}")
    public String read(ModelMap model,
                       @PathVariable int dialogId)
    {
        model.addAttribute("dialog", dialogService.find(dialogId));

        return "/dialog/showDialog";
    }

    @RequestMapping(value = "add/{userId}", method = RequestMethod.GET)
    public String save(@PathVariable int userId)
    {
        int initiatorUserId = SecurityUtil.getCurrentUser().getUserId();

        String membersString = initiatorUserId < userId
                ? initiatorUserId + "," + userId
                : userId + "," + initiatorUserId;

        Dialog dialog = new Dialog(membersString);

        try
        {
            dialogService.save(dialog);
            usersDialogService.save(new UsersDialog(initiatorUserId, dialog.getDialogId()));
            usersDialogService.save(new UsersDialog(userId, dialog.getDialogId()));
        }
        catch (ConstraintViolationException e)
        {
            logger.info("Chat with this members already exist. A user with userId = " + userId + " tries to join the " +
                    "chat with dialogId = " + dialog.getDialogId());

            Dialog existDialog = dialogService.findByMembersString(membersString);
            return "redirect:/dialog/" + existDialog.getDialogId();
        }

        logger.info("The user with userId = " + userId + " has joined the chat with dialogId = " + dialog.getDialogId
                ());
        return "redirect:/dialog/" + dialog.getDialogId();
    }

    @RequestMapping(value = "addMember/{dialogId}", method = RequestMethod.GET)
    public String addMember(ModelMap model,
                            @PathVariable int dialogId)
    {
        int userId = SecurityUtil.getCurrentUser().getUserId();

        model.addAttribute("usersList", dialogService.addMemberRequest(userId, dialogId));
        model.addAttribute("dialogId", dialogId);

        return "dialog/_addMemberRequest";
    }

    @RequestMapping(value = "addMember", method = RequestMethod.GET)
    public String addMember(@RequestParam int dialogId,
                            @RequestParam int userId)
    {
        try
        {
            dialogService.addMember(dialogId, userId);
        }
        catch (DataIntegrityViolationException e)
        {
            logger.error("Chat with this members already exist.");
            return "/error/badAction";
        }
        catch (IllegalArgumentException e)
        {
            logger.error("Illegal arguments: userId = " + userId + ", dialogId = " + dialogId);
            return "/error/badAction";
        }
        catch (EntityNotFoundException e)
        {
            logger.error("User or Dialog not found");
            return "/error/badAction";
        }
        catch (EntityAlreadyExistException e)
        {
            logger.error("User already in chat");
            return "/error/badAction";
        }

        logger.info("User with userId = " + userId + " has added to chat with dialogId = " + dialogId);
        return "redirect:/dialog/" + dialogId;
    }


    @RequestMapping(value = "delete/{dialogId}", method = RequestMethod.GET)
    public String delete(@PathVariable int dialogId)
    {
        int userId = SecurityUtil.getCurrentUser().getUserId();


        try
        {
            dialogService.deleteMemberByUserId(dialogId, userId);
        }
        catch (UserNotAChatMemberException e)
        {
            logger.error("The user is not involved in the chat");
            return "/error/badAction";
        }
        catch (EntityNotFoundException e)
        {
            logger.error("The user or dialogue not found. UserId = " + userId + ", dialogId = " + dialogId);
            return "/error/badAction";
        }
        catch (ConstraintViolationException e)
        {
            logger.error("ConstraintViolationException. UserId = " + userId + ", dialogId = " + dialogId);
            return "/error/badAction";
        }

        logger.info("User with userId = " + userId + " has left the chat with dialogId = " + dialogId);
        return "redirect:/dialog/";
    }


}