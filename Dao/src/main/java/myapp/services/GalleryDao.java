package myapp.services;

import myapp.baseDao.AbstractDao;
import myapp.entities.Images;
import myapp.entities.Tags;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GalleryDao extends AbstractDao implements IGalleryDao {

    public int getTableCount()
    {
        return ((Number) getSession().createQuery
                ("select count(image) from Images image")
                .uniqueResult()).intValue();
    }

    public List<Images> getPageByTagId(int firstResult, int size, int tagId)
    {
        return (List<Images>) getSession().createQuery
                ("select image from Images image join image.picturetagsesByImageId pictureTags where pictureTags" +
                        ".tagId = :tagId order by image.votesNumber desc")
                .setInteger("tagId", tagId)
                .setFirstResult(firstResult)
                .setMaxResults(size)
                .list();
    }

    public List<Images> getPage(int firstResult, int size)
    {
        return (List<Images>) getSession().createQuery
                ("from Images image order by image.votesNumber desc")
                .setFirstResult(firstResult)
                .setMaxResults(size)
                .list();
    }

    public List<Tags> getTags()
    {
        return (List<Tags>) getSession().createQuery
                ("from Tags")
                .list();
    }

    public int getPicturesCountWithTag(int tagId)
    {
        return ((Number) getSession().createQuery
                ("select count(image) from Images image join image.picturetagsesByImageId pictureTags where " +
                        "pictureTags.tagId = :tagId")
                .setInteger("tagId", tagId)
                .uniqueResult()).intValue();
    }
}
