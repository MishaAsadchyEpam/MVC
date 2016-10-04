package myapp.services;

import myapp.entities.Dialog;
import myapp.entities.Friends;
import myapp.entities.Users;
import myapp.entities.UsersDialog;
import myapp.exceptions.EntityAlreadyExistException;
import myapp.exceptions.EntityNotFoundException;
import myapp.exceptions.UserNotAChatMemberException;
import myapp.hibernateCRUDDao.DialogHibernateCRUDDao;
import myapp.serviceContracts.IUserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class DialogService {

    @Autowired
    private DialogHibernateCRUDDao dialogDao;

    @Autowired
    private IUserService usersService;

    @Autowired
    private UsersDialogService usersDialogService;

    @Autowired
    private FriendsService friendsService;

    public void deleteMemberByUserId(int dialogId, int userId) throws EntityNotFoundException,
            UserNotAChatMemberException {
        if (dialogId <= 0 || userId <= 0) {
            throw new IllegalArgumentException();
        }

        Dialog dialog = dialogDao.find(dialogId);

        if (dialog == null) {
            throw new EntityNotFoundException();
        }

        if (usersService.find(userId) == null) {
            throw new EntityNotFoundException();
        }


        UsersDialog ourClient = findUserInDialog((List<UsersDialog>) dialog.getUsersdialogsesByDialogId(), userId);


        if (ourClient == null) {
            throw new UserNotAChatMemberException();
        }


        tryToDeleteUserDialog(dialog, ourClient);
    }

    private UsersDialog findUserInDialog(List<UsersDialog> members, int userId) {
        UsersDialog ourClient = null;
        for (UsersDialog usersDialog : members) {
            if (usersDialog.getUserId() == userId) {
                ourClient = usersDialog;
                break;
            }
        }
        return ourClient;
    }

    private void tryToDeleteUserDialog(Dialog dialog, UsersDialog ourClient) {
        if (dialog.getUsersdialogsesByDialogId().size() <= 2) {
            delete(dialog.getDialogId());
            return;
        }

        String membersString = dialog.getMembersString().replace(ourClient.getUserId() + "", "");
        dialog.setMembersString(cutComma(membersString));

        dialogDao.update(dialog);

        usersDialogService.delete(ourClient.getUserDilogId());
    }

    private String cutComma(String membersString) {

        String result;

        if (membersString.startsWith(",")) {
            result = membersString.substring(1);
        } else if (membersString.endsWith(",")) {
            result = membersString.substring(0, membersString.length() - 1);
        } else {
            result = membersString.replace(",,", ",");
        }
        return result;
    }

    public Dialog find(int id) {
        Dialog dialog = dialogDao.find(id);

        if (dialog != null) {
            Hibernate.initialize(dialog.getMessagesByDialogId());
            Hibernate.initialize(dialog.getUsersdialogsesByDialogId());
        }


        return dialog;
    }


    public List<Dialog> findByUserId(int userId) {
        List<Dialog> dialogs = dialogDao.findByUserId(userId);

        for (Dialog dialog : dialogs) {
            Hibernate.initialize(dialog.getMessagesByDialogId());
            Hibernate.initialize(dialog.getUsersdialogsesByDialogId());
        }

        return dialogDao.findByUserId(userId);
    }

    public void addMember(int dialogId, int userId) throws EntityNotFoundException, EntityAlreadyExistException {
        if (dialogId <= 0 || userId <= 0) {
            throw new IllegalArgumentException();
        }

        Dialog dialog = dialogDao.find(dialogId);

        if (dialog == null) {
            throw new EntityNotFoundException();
        }

        if (usersService.find(userId) == null) {
            throw new EntityNotFoundException();
        }

        List<UsersDialog> members = (List<UsersDialog>) dialog.getUsersdialogsesByDialogId();
        UsersDialog usersDialogForAdd = new UsersDialog(userId, dialogId);
        if (!members.contains(usersDialogForAdd)) {
            members.add(usersDialogForAdd);
        } else {
            throw new EntityAlreadyExistException(usersDialogForAdd.getClass().getName(), "участники чата");
        }

        StringBuilder membersString = new StringBuilder("");
        List<Integer> membersIds = new ArrayList<Integer>();

        for (UsersDialog member : members) {
            membersIds.add(member.getUserId());
        }

        Collections.sort(membersIds);

        membersString.append(membersIds.get(0));

        for (int i = 1; i < membersIds.size(); i++) {
            membersString.append(",").append(membersIds.get(i));
        }

        dialog.setMembersString(membersString.toString());

        dialogDao.update(dialog);

        usersDialogService.save(new UsersDialog(userId, dialogId));
    }

    public List<Users> addMemberRequest(int userId, int dialogId) {
        List<Users> usersList = new ArrayList<Users>();


        List<Friends> usersFriends = friendsService.findFriends(userId);


        Dialog dialog = find(dialogId);

        if (dialog == null || usersFriends == null) {
            return usersList;
        }


        for (Friends friend : usersFriends) {
            usersList.add(friend.getUsersByUserIdFirst());
        }

        String[] membersIds = dialog.getMembersString().split(",");
        for (String memberId : membersIds) {
            int id = Integer.parseInt(memberId);
            for (Users user : usersList) {
                if (user.getUserId() == id) {
                    usersList.remove(user);
                    break;
                }
            }
        }

        return usersList;
    }

    public Dialog findByMembersString(String membersString) {
        return dialogDao.findByMembersString(membersString);
    }

    void delete(int id) {
        dialogDao.delete(id);
    }

    public void save(Dialog dialog) {
        dialogDao.save(dialog);
    }
}
