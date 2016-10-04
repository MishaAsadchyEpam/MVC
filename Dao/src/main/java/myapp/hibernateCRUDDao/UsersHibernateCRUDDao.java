package myapp.hibernateCRUDDao;

import myapp.baseDao.HibernateCRUDDao;
import myapp.entities.Users;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UsersHibernateCRUDDao extends HibernateCRUDDao<Users> {

    @Override
    public Users find(int id)
    {
        return (Users) getSession().get(Users.class, id);
    }

    public List<Users> getAll()
    {
        return (List<Users>) getSession().createQuery("from Users").list();
    }

    public Users findByLogin(String username)
    {

        return (Users) getSession().createQuery
                ("SELECT user from Users user where user.username = :username")
                .setString("username", username)
                .uniqueResult();
    }
}