package myapp.hibernateCRUDDao;

import myapp.baseDao.HibernateCRUDDao;
import myapp.entities.Albums;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AlbumsHibernateCRUDDao extends HibernateCRUDDao<Albums> {
    @Override
    public Albums find(int id)
    {
        return (Albums) getSession().get(Albums.class, id);
    }

    public List<Albums> getAll()
    {
        return (List<Albums>) getSession().createQuery
                ("from Albums")
                .list();
    }

    public List<Albums> findByUserId(int userId)
    {
        return (List<Albums>) getSession().createQuery
                ("from Albums album where album.userId = :userId")
                .setInteger("userId", userId)
                .list();
    }
}