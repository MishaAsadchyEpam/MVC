package roles;

import org.springframework.security.core.GrantedAuthority;

public class RolesChecker {

    public static GrantedAuthority CheckAuthority(String authorityCandidate)
            throws RoleException
    {
        if (authorityCandidate.equals(Roles.ROLE_USER + "")
                || authorityCandidate.equals(Roles.ROLE_ADMIN + "")
                || authorityCandidate.equals(Roles.ROLE_GUEST + ""))
        {
            return new AuthorityImpl(authorityCandidate);
        }
        throw new RoleException();
    }

}
