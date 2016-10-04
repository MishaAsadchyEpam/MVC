package myapp.hibernateCRUDDao;

import myapp.baseDao.HibernateCRUDDao;
import myapp.entities.Friends;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class FriendsHibernateCRUDDao extends HibernateCRUDDao<Friends> {
    @Override
    public Friends find(int id)
    {
        return (Friends) getSession().get(Friends.class, id);
    }

    public List<Friends> getAll()
    {
        return (List<Friends>) getSession().createQuery("from Friends").list();
    }

    public List<Friends> findFriends(int userId)
    {
        return (List<Friends>) getSession().createQuery
                ("from Friends friend where friend.userIdSecond = :userId")
                .setInteger("userId", userId)
                .list();
    }


    public Friends findByUsers(int initiatorUserId, int userForDelete)
    {
        return (Friends) getSession().createQuery
                ("from Friends friend where friend.userIdFirst = :initiatorUserId and friend.userIdSecond = " +
                        ":userForDelete")
                .setInteger("initiatorUserId", initiatorUserId)
                .setInteger("userForDelete", userForDelete)
                .uniqueResult();
    }
}