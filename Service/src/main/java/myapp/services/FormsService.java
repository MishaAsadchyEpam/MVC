package myapp.services;

import myapp.entities.Forms;
import myapp.entities.Images;
import myapp.hibernateCRUDDao.FormsHibernateCRUDDao;
import myapp.hibernateCRUDDao.ImagesHibernateCRUDDao;
import myapp.media.MediaPathResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class FormsService {

    @Autowired
    private FormsHibernateCRUDDao formshibernatedao;

    @Autowired
    private ImagesHibernateCRUDDao imagesDao;

    @Autowired
    private MediaPathResolver mediaPathResolver;

    public void update(Forms forms)
    {
        formshibernatedao.update(forms);
    }

    public Forms find(int id)
    {
        return formshibernatedao.find(id);
    }

    public void delete(int id)
    {
        formshibernatedao.delete(id);
    }

    public Forms findByUserId(int userId)
    {
        return formshibernatedao.findByUserId(userId);
    }

    public List<Images> getUserImages(int userId)
    {
        return imagesDao.getUserImages(userId);
    }

    public String cutUrl(String myPhoto)
    {
        return myPhoto.replace(mediaPathResolver.getMediaServerUrl(), "").replaceAll("/", "");
    }
}
