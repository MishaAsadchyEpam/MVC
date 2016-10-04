package myapp.services;

import myapp.entities.Forms;
import myapp.entities.Friends;
import myapp.hibernateCRUDDao.FormsHibernateCRUDDao;
import myapp.hibernateCRUDDao.FriendsHibernateCRUDDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class FriendsService {

    @Autowired
    private FriendsHibernateCRUDDao friendshibernatedao;

    @Autowired
    private FormsHibernateCRUDDao fromsDao;

    public void save(Friends friends)
    {
        friendshibernatedao.save(friends);
    }


    public void delete(int initiatorUserId, int userForDelete)
    {
        Friends friend = friendshibernatedao.findByUsers(initiatorUserId, userForDelete);

        friendshibernatedao.delete(friend.getFriendId());

        friend = friendshibernatedao.findByUsers(userForDelete, initiatorUserId);

        friendshibernatedao.delete(friend.getFriendId());
    }

    public Friends findByUsers(int initiatorUserId, int userForDelete)
    {
        return friendshibernatedao.findByUsers(initiatorUserId, userForDelete);
    }

    public List<Forms> findFriendsForms(int userId)
    {
        return fromsDao.findFriendsForms(userId);
    }

    public List<Friends> findFriends(int userId)
    {
        return friendshibernatedao.findFriends(userId);
    }
}