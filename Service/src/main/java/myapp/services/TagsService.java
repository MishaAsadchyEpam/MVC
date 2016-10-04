package myapp.services;

import myapp.entities.Tags;
import myapp.hibernateCRUDDao.TagsHibernateCRUDDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TagsService {

    @Autowired
    private TagsHibernateCRUDDao tagshibernatedao;

    public void save(Tags tags)
    {
        tagshibernatedao.save(tags);
    }

    public void update(Tags tags)
    {
        tagshibernatedao.update(tags);
    }

    public Tags find(int id)
    {
        return tagshibernatedao.find(id);
    }

    public void delete(int id)
    {
        tagshibernatedao.delete(id);
    }

    public List<Tags> getAll()
    {
        return tagshibernatedao.getAll();
    }

    public Tags findByName(String tagName)
    {
        return tagshibernatedao.findByName(tagName);
    }
}