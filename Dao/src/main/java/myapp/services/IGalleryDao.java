package myapp.services;

import myapp.entities.Images;
import myapp.entities.Tags;

import java.util.List;

public interface IGalleryDao {

    int getTableCount();

    List<Images> getPageByTagId(int firstResult, int size, int tagId);

    List<Images> getPage(int firstResult, int size);

    List<Tags> getTags();

    int getPicturesCountWithTag(int tagId);

}
