package myapp.hibernateCRUDDao;

import myapp.baseDao.HibernateCRUDDao;
import myapp.entities.Tags;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TagsHibernateCRUDDao extends HibernateCRUDDao<Tags> {
    @Override
    public Tags find(int id)
    {
        return (Tags) getSession().get(Tags.class, id);
    }

    public List<Tags> getAll()
    {
        return (List<Tags>) getSession().createQuery("from Tags").list();
    }

    public Tags findByName(String tagName)
    {
        return (Tags) getSession().createQuery
                ("from Tags tag where tag.tagName = :tagName")
                .setString("tagName", tagName)
                .uniqueResult();
    }
}