package myapp.services;

import myapp.entities.Albums;
import myapp.entities.Images;
import myapp.hibernateCRUDDao.AlbumsHibernateCRUDDao;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AlbumsService {

    @Autowired
    private AlbumsHibernateCRUDDao albumshibernatedao;

    @Autowired
    private ImagesService imageService;

    public void save(Albums albums)
    {
        albumshibernatedao.save(albums);
    }

    public void update(Albums albums)
    {
        albumshibernatedao.update(albums);
    }

    public Albums find(int id)
    {
        return albumshibernatedao.find(id);
    }

    public Albums findWithImages(int id)
    {
        Albums album = albumshibernatedao.find(id);

        Hibernate.initialize(album.getImagesesByAlbumId());

        return album;
    }

    public void deletePicturesInAlbum(Albums album)
    {
        List<Images> albumImages = (List<Images>) album.getImagesesByAlbumId();

        for (Images image : albumImages)
        {
            imageService.deletePicture(image.getImageId());
        }
    }

    public void delete(int id)
    {
        Albums album = albumshibernatedao.find(id);

        deletePicturesInAlbum(album);

        albumshibernatedao.delete(id);
    }

    public List<Albums> findByUserId(int userId)
    {
        return albumshibernatedao.findByUserId(userId);
    }
}