package myapp.controllers.users.security;

import myapp.entities.Users;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static Users getCurrentUser()
    {
        Users user;

        try
        {
            user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        catch (ClassCastException ex)
        {
            return null;
        }
        return user;
    }

}
