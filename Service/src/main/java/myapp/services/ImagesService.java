package myapp.services;

import myapp.entities.Images;
import myapp.hibernateCRUDDao.ImagesHibernateCRUDDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;


@Service
@Transactional
public class ImagesService {

    private static String imageDirectory = "";

    public static void setImageDirectory(String imageDirectory)
    {
        ImagesService.imageDirectory = imageDirectory;
    }

    @Autowired
    private ImagesHibernateCRUDDao imageshibernatedao;

    public void save(Images images)
    {
        imageshibernatedao.save(images);
    }

    public void update(Images images)
    {
        imageshibernatedao.update(images);
    }

    public Images find(int id)
    {
        return imageshibernatedao.find(id);
    }

    public void deletePicture(int id)
    {
        new File(imageDirectory + find(id).getPictureUrl()).delete();
    }

    public void delete(int id)
    {
        deletePicture(id);

        imageshibernatedao.delete(id);
    }

    public String findPictureUrlByPictureId(int pictureId)
    {
        return imageshibernatedao.findPictureUrlByPictureId(pictureId);
    }

    public List<Images> getTopImages(int count)
    {
        return imageshibernatedao.getTopImages(count);
    }
}