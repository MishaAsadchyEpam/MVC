package myapp.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Albums {
    private int albumId;
    private String name;
    private int userId;
    private Users usersByUserId;
    private Collection<Images> imagesesByAlbumId;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "albumId")
    public int getAlbumId()
    {
        return albumId;
    }

    public void setAlbumId(int albumId)
    {
        this.albumId = albumId;
    }

    @Basic
    @Column(name = "name")
    @NotNull
    @NotEmpty
    @Size(max = 50)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Albums albums = (Albums) o;

        if (albumId != albums.albumId) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return albumId;
    }

    @ManyToOne
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

    @OneToMany(mappedBy = "albumsByAlbumId")
    public Collection<Images> getImagesesByAlbumId()
    {
        return imagesesByAlbumId;
    }

    public void setImagesesByAlbumId(Collection<Images> imagesesByAlbumId)
    {
        this.imagesesByAlbumId = imagesesByAlbumId;
    }
}
