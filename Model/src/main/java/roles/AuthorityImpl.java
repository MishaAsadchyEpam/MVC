package roles;

import org.springframework.security.core.GrantedAuthority;


class AuthorityImpl implements GrantedAuthority {

    public AuthorityImpl(String authority)
    {
        this.authority = authority;
    }

    private String authority;

    @Override
    public String getAuthority()
    {
        return authority;
    }
}
