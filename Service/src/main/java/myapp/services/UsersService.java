package myapp.services;

import emailModels.RegistrationSuccessEmailModel;
import myapp.emailSenders.RegistrationSuccessSender;
import myapp.entities.Albums;
import myapp.entities.Forms;
import myapp.entities.Users;
import myapp.hibernateCRUDDao.FormsHibernateCRUDDao;
import myapp.hibernateCRUDDao.UsersHibernateCRUDDao;
import myapp.serviceContracts.IUserService;
import myapp.stringGenerators.ConfirmationTokenGenerator;
import myapp.stringGenerators.PasswordSaltGenerator;
import myapp.stringGenerators.StringGenerator;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import roles.Roles;

import java.util.List;


@Service
@Transactional
public class UsersService implements IUserService {

    @Autowired
    private UsersHibernateCRUDDao usershibernatedao;

    @Autowired
    private FormsHibernateCRUDDao formshibernatedao;

    @Autowired
    private Md5PasswordEncoder encoder;

    @Autowired
    private RegistrationSuccessSender successSender;

    @Autowired
    private AlbumsService albumsService;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException
    {
        return usershibernatedao.findByLogin(username);
    }

    public void save(Users users)
    {

        StringGenerator generator = new ConfirmationTokenGenerator();
        String confirmationToken = generator.generate();


        generator = new PasswordSaltGenerator();
        users.setPasswordSalt(generator.generate());


        users.setPassword(
                encoder.encodePassword(users.getPassword(), users.getPasswordSalt()));

        users.setConfirmationToken(confirmationToken);

        users.setRolesString(Roles.ROLE_GUEST + "");

        usershibernatedao.save(users);
    }

    public void generateFormToUser(String userName)
    {

        Users users = (Users) loadUserByUsername(userName);
        Forms form = new Forms();
        form.setMyPhoto("NoPhoto.jpg");
        form.setUserId(users.getUserId());
        form.setAboutMe(users.getNickName());
        formshibernatedao.save(form);
    }

    @Override
    public void sendEmail(Users users, String hostName, String password)
    {
        // send email
        RegistrationSuccessEmailModel model =
                new RegistrationSuccessEmailModel(
                        users.getUserId(), users.getUsername(), password,
                        users.getConfirmationToken(), hostName);


        successSender.send(model, users.getUsername());
    }

    @Override
    public Users findUserProfile(int userId)
    {

        if (userId <= 0)
        {
            throw new IllegalArgumentException();
        }

        Users users = usershibernatedao.find(userId);

        Hibernate.initialize(users.getAlbumsesByUserId());

        for (Albums album : users.getAlbumsesByUserId())
        {
            Hibernate.initialize(album.getImagesesByAlbumId());
        }

        return users;
    }

    public void update(Users users)
    {
        usershibernatedao.update(users);
    }

    public Users find(int id)
    {
        return usershibernatedao.find(id);
    }

    public void delete(int id)
    {
        List<Albums> userAlbums = (List<Albums>) find(id).getAlbumsesByUserId();

        for (Albums album : userAlbums)
        {
            albumsService.deletePicturesInAlbum(album);
        }

        usershibernatedao.delete(id);
    }

    public List<Users> getAll()
    {
        return usershibernatedao.getAll();
    }


}