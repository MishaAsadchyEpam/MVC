package myapp.hibernateCRUDDao;

import myapp.baseDao.HibernateCRUDDao;
import myapp.entities.Images;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImagesHibernateCRUDDao extends HibernateCRUDDao<Images> {
    @Override
    public Images find(int id)
    {
        return (Images) getSession().get(Images.class, id);
    }

    public List<Images> getAll()
    {
        return (List<Images>) getSession().createQuery
                ("from Images").list();
    }

    public String findPictureUrlByPictureId(int pictureId)
    {
        return (String) getSession().createQuery
                ("select image.pictureUrl from Images image where image.imageId = :pictureId")
                .setInteger("pictureId", pictureId)
                .uniqueResult();
    }

    public List<Images> getUserImages(int userId)
    {
        return (List<Images>) getSession().createQuery
                ("select image from Images image join image.albumsByAlbumId userAlbums where userAlbums.userId = " +
                        ":userId")
                .setInteger("userId", userId)
                .list();
    }

    public List<Images> getTopImages(int count)
    {
        return (List<Images>) getSession().createQuery
                ("from Images image order by image.votesNumber desc")
                .setMaxResults(count)
                .list();
    }
}