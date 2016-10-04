package myapp.hibernateCRUDDao;

import myapp.baseDao.HibernateCRUDDao;
import myapp.entities.Forms;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class FormsHibernateCRUDDao extends HibernateCRUDDao<Forms> {
    @Override
    public Forms find(int id)
    {
        return (Forms) getSession().get(Forms.class, id);
    }

    public List<Forms> getAll()
    {
        return (List<Forms>) getSession().createQuery
                ("from Forms")
                .list();
    }

    public Forms findByUserId(int userId)
    {
        return (Forms) getSession().createQuery
                ("from Forms form where form.userId = :userId")
                .setInteger("userId", userId)
                .uniqueResult();
    }


    public List<Forms> findFriendsForms(int userId)
    {
        return (List<Forms>) getSession().createQuery
                ("select form from Friends friend join friend.usersByUserIdFirst.formsesByUserId form where friend" +
                        ".userIdSecond = :userId")
                .setInteger("userId", userId)
                .list();
    }
}