package myapp.hibernateCRUDDao;

import myapp.baseDao.HibernateCRUDDao;
import myapp.entities.UsersDialog;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UsersDialogHibernateCRUDDao extends HibernateCRUDDao<UsersDialog> {
    @Override
    public UsersDialog find(int id)
    {
        return (UsersDialog) getSession().get(UsersDialog.class, id);
    }

    public List<UsersDialog> getAll()
    {
        return (List<UsersDialog>) getSession().createQuery("from UsersDialog").list();
    }

}