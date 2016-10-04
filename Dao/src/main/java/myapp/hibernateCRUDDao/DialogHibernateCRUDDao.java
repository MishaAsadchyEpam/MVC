package myapp.hibernateCRUDDao;

import myapp.baseDao.HibernateCRUDDao;
import myapp.entities.Dialog;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DialogHibernateCRUDDao extends HibernateCRUDDao<Dialog> {
    @Override
    public Dialog find(int id)
    {
        return (Dialog) getSession().get(Dialog.class, id);
    }

    public List<Dialog> getAll()
    {
        return (List<Dialog>) getSession().createQuery
                ("from Dialog")
                .list();
    }

    public List<Dialog> findByUserId(int userId)
    {
        return (List<Dialog>) getSession().createQuery
                ("select dialog from Dialog dialog join dialog.usersdialogsesByDialogId usersDialogs where " +
                        "usersDialogs.userId = :userId")
                .setInteger("userId", userId)
                .list();

    }

    public Dialog findByMembersString(String membersString)
    {
        return (Dialog) getSession().createQuery
                ("from Dialog dialog where dialog.membersString = :membersString")
                .setString("membersString", membersString)
                .uniqueResult();
    }
}