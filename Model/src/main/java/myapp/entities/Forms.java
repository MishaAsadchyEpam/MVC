package myapp.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Forms {
    private int formId;
    private int userId;
    private String aboutMe;
    private String myPhoto;
    private Users usersByUserId;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "formId")
    public int getFormId()
    {
        return formId;
    }

    public void setFormId(int formId)
    {
        this.formId = formId;
    }

    @Basic
    @Column(name = "userId")
    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    @Basic
    @Column(name = "aboutMe")
    @NotNull
    @NotEmpty
    @Size(max = 50)
    public String getAboutMe()
    {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe)
    {
        this.aboutMe = aboutMe;
    }

    @Basic
    @Column(name = "myPhoto")
    @NotNull
    @NotEmpty
    public String getMyPhoto()
    {
        return myPhoto;
    }

    public void setMyPhoto(String myPhoto)
    {
        this.myPhoto = myPhoto;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Forms forms = (Forms) o;

        if (formId != forms.formId) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return formId;
    }

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false, insertable = false,
            updatable = false)
    public Users getUsersByUserId()
    {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId)
    {
        this.usersByUserId = usersByUserId;
    }
}
