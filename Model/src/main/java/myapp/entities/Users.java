package myapp.entities;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import roles.RoleException;
import roles.RolesChecker;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Users implements UserDetails {

    private Integer userId;
    private String username;
    private String password;
    private String nickName;
    private String confirmationToken;
    private String passwordSalt;
    private String rolesString;

    private Collection<Albums> albumsesByUserId;
    private Forms formsesByUserId;
    private Collection<Votes> votesesByUserId;
    private Collection<Friends> friendsesByUserId;
    private Collection<UsersDialog> usersdialogsesByUserId;
    private Collection<Message> messagesByUserId;

    private transient Collection<GrantedAuthority> roleses;
    private transient String passwordConfirm;

    @Transient
    @NotNull
    @NotEmpty
    @Size(min = 6, max = 50)
    public String getPasswordConfirm()
    {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm)
    {
        this.passwordConfirm = passwordConfirm;
    }

    @OneToMany(mappedBy = "users")
    public Collection<Message> getMessagesByUserId()
    {
        return messagesByUserId;
    }

    public void setMessagesByUserId(Collection<Message> messagesByUserId)
    {
        this.messagesByUserId = messagesByUserId;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<UsersDialog> getUsersdialogsesByUserId()
    {
        return usersdialogsesByUserId;
    }

    public void setUsersdialogsesByUserId(Collection<UsersDialog> usersdialogsesByUserId)
    {
        this.usersdialogsesByUserId = usersdialogsesByUserId;
    }

    @Override
    @Transient
    public Collection<GrantedAuthority> getAuthorities()
    {
        if (roleses == null)
        {
            roleses = new HashSet<GrantedAuthority>();
            String[] rolesArray = rolesString.split(",");
            for (String rolesString : rolesArray)
            {
                try
                {
                    roleses.add(RolesChecker.CheckAuthority(rolesString));
                }
                catch (RoleException e)
                {
                    e.printStackTrace();
                }
            }

        }
        return roleses;
    }

    public String getRolesString()
    {
        return rolesString;
    }

    public void setRolesString(String rolesString)
    {
        this.rolesString = rolesString;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "userId")
    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    @Basic
    @Column(name = "password")
    @NotNull
    @NotEmpty
    @Size(min = 6, max = 50)
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    @Basic
    @Column(name = "username")
    @NotNull
    @NotEmpty
    @Email
    @Size(max = 50)
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Override
    @Transient
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled()
    {
        return true;
    }

    @Basic
    @Column(name = "nickName")
    @NotNull
    @NotEmpty
    @Size(max = 50)
    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "confirmationToken")
    public String getConfirmationToken()
    {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken)
    {
        this.confirmationToken = confirmationToken;
    }

    @Basic
    @Column(name = "passwordSalt")
    public String getPasswordSalt()
    {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt)
    {
        this.passwordSalt = passwordSalt;
    }


    @OneToMany(mappedBy = "usersByUserId")
    public Collection<Albums> getAlbumsesByUserId()
    {
        return albumsesByUserId;
    }

    public void setAlbumsesByUserId(Collection<Albums> albumsesByUserId)
    {
        this.albumsesByUserId = albumsesByUserId;
    }

    @OneToOne(mappedBy = "usersByUserId")
    public Forms getFormsesByUserId()
    {
        return formsesByUserId;
    }

    public void setFormsesByUserId(Forms formsesByUserId)
    {
        this.formsesByUserId = formsesByUserId;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<Votes> getVotesesByUserId()
    {
        return votesesByUserId;
    }

    public void setVotesesByUserId(Collection<Votes> votesesByUserId)
    {
        this.votesesByUserId = votesesByUserId;
    }

    @OneToMany(mappedBy = "usersByUserIdFirst")
    public Collection<Friends> getFriendsesByUserId()
    {
        return friendsesByUserId;
    }

    public void setFriendsesByUserId(Collection<Friends> friendsesByUserId)
    {
        this.friendsesByUserId = friendsesByUserId;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != null ? !userId.equals(users.userId) : users.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return userId != null ? userId.hashCode() : 0;
    }
}
