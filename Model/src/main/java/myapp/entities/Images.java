package myapp.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Images {
    private int imageId;
    private String pictureUrl;
    private String pictureName;
    private String pictureDescribe;
    private int albumId;
    private int votesNumber;
    private Albums albumsByAlbumId;
    private List<Picturetags> picturetagsesByImageId;

    private Collection<Votes> votesesByImageId;

    public Images()
    {
    }

    public Images(String pictureUrl, String pictureName, String pictureDescribe, int albumId)
    {
        this.pictureUrl = pictureUrl;
        this.pictureName = pictureName;
        this.pictureDescribe = pictureDescribe;
        this.albumId = albumId;
        this.votesNumber = 0;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Images images = (Images) o;

        if (imageId != images.imageId) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return imageId;
    }

    public void increment()
    {
        this.votesNumber++;
    }

    public void decrement()
    {
        this.votesNumber--;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "imageId")
    public int getImageId()
    {
        return imageId;
    }

    public void setImageId(int imageId)
    {
        this.imageId = imageId;
    }

    @Basic
    @Column(name = "votesNumber")
    public int getVotesNumber()
    {
        return votesNumber;
    }

    public void setVotesNumber(int votesNumber)
    {
        this.votesNumber = votesNumber;
    }

    @Basic
    @Column(name = "pictureUrl")
    @NotNull
    @NotEmpty
    @Size(max = 20)
    public String getPictureUrl()
    {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl)
    {
        this.pictureUrl = pictureUrl;
    }

    @Basic
    @Column(name = "pictureName")
    @NotNull
    @NotEmpty
    @Size(max = 30)
    public String getPictureName()
    {
        return pictureName;
    }

    public void setPictureName(String pictureName)
    {
        this.pictureName = pictureName;
    }

    @Basic
    @Column(name = "pictureDescribe")
    @NotNull
    @NotEmpty
    @Size(max = 100)
    public String getPictureDescribe()
    {
        return pictureDescribe;
    }

    public void setPictureDescribe(String pictureDescribe)
    {
        this.pictureDescribe = pictureDescribe;
    }

    @Basic
    @Column(name = "albumId")
    public int getAlbumId()
    {
        return albumId;
    }

    public void setAlbumId(int albumId)
    {
        this.albumId = albumId;
    }

    @ManyToOne
    @JoinColumn(name = "albumId", referencedColumnName = "albumId", nullable = false, insertable = false,
            updatable = false)
    public Albums getAlbumsByAlbumId()
    {
        return albumsByAlbumId;
    }

    public void setAlbumsByAlbumId(Albums albumsByAlbumId)
    {
        this.albumsByAlbumId = albumsByAlbumId;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imagesByPictureId")
    public List<Picturetags> getPicturetagsesByImageId()
    {
        return picturetagsesByImageId;
    }

    public void setPicturetagsesByImageId(List<Picturetags> picturetagsesByImageId)
    {
        this.picturetagsesByImageId = picturetagsesByImageId;
    }

    @OneToMany(mappedBy = "imagesByPictureId")
    public Collection<Votes> getVotesesByImageId()
    {
        return votesesByImageId;
    }

    public void setVotesesByImageId(Collection<Votes> votesesByImageId)
    {
        this.votesesByImageId = votesesByImageId;
    }
}
