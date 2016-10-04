package myapp.gallery;

import myapp.entities.Images;
import myapp.entities.Tags;
import myapp.services.IGalleryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GalleryService {

    public static final int PAGE_SIZE = 15;

    @Autowired
    private IGalleryDao dao;

    private int pagesCount;

    public int getPagesCount()
    {
        return pagesCount;
    }

    public List<Images> getPage(int pageNumber, int tagId)
    {
        if (tagId < 0 || pageNumber < 0)
        {
            return new ArrayList<Images>();
        }

        if (tagId != 0)
        {
            pagesCount = (int) Math.ceil(((double) getPicturesCountWithTag(tagId)) / PAGE_SIZE);
            if (pageNumber >= pagesCount)
            {
                return new ArrayList<Images>();
            }

            return dao.getPageByTagId(pageNumber * PAGE_SIZE, PAGE_SIZE, tagId);
        }


        pagesCount = (int) Math.ceil(((double) getTableCount()) / PAGE_SIZE);

        if (pageNumber >= pagesCount)
        {
            return new ArrayList<Images>();
        }

        return dao.getPage(pageNumber * PAGE_SIZE, PAGE_SIZE);
    }

    private int getTableCount()
    {
        return dao.getTableCount();
    }

    int getPicturesCountWithTag(int tagId)
    {
        return dao.getPicturesCountWithTag(tagId);
    }

    public List<Tags> getTags()
    {
        return dao.getTags();
    }

}
