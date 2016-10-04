package myapp.services;

import myapp.entities.UsersDialog;
import myapp.hibernateCRUDDao.UsersDialogHibernateCRUDDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UsersDialogService {

    @Autowired
    private UsersDialogHibernateCRUDDao usersdialoghibernatecruddao;

    public void save(UsersDialog usersdialog)
    {
        usersdialoghibernatecruddao.save(usersdialog);
    }

    public void delete(int id)
    {
        usersdialoghibernatecruddao.delete(id);
    }

}