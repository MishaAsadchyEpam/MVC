package myapp.hibernateCRUDDao;

import myapp.baseDao.HibernateCRUDDao;
import myapp.entities.Picturetags;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PicturetagsHibernateCRUDDao extends HibernateCRUDDao<Picturetags> {
    @Override
    public Picturetags find(int id)
    {
        return (Picturetags) getSession().get(Picturetags.class, id);
    }

    public List<Picturetags> getAll()
    {
        return (List<Picturetags>) getSession().createQuery("from Picturetags").list();
    }

    public List<Picturetags> findByPictureId(int pictureId)
    {
        return (List<Picturetags>) getSession().createQuery
                ("from Picturetags pictureTag where pictureTag.pictureId = :pictureId")
                .setInteger("pictureId", pictureId)
                .list();

    }
}