package myapp.serviceContracts;

import myapp.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService, ICrudService<Users>, IGetAllService<Users> {

    void generateFormToUser(String userName);

    void sendEmail(Users users, String hostName, String password);

    Users findUserProfile(int userId);


}
