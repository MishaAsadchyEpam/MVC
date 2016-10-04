package myapp.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Picturetags {
    private int pictureTagId;
    private int tagId;
    private int pictureId;
    private Images imagesByPictureId;
    private Tags tagsByTagId;

    public Picturetags()
    {
    }

    public Picturetags(int tagId, int pictureId)
    {
        this.tagId = tagId;
        this.pictureId = pictureId;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "PictureTagId")
    public int getPictureTagId()
    {
        return pictureTagId;
    }

    public void setPictureTagId(int pictureTagId)
    {
        this.pictureTagId = pictureTagId;
    }

    @Basic
    @Column(name = "tagId")
    public int getTagId()
    {
        return tagId;
    }

    public void setTagId(int tagId)
    {
        this.tagId = tagId;
    }

    @Basic
    @Column(name = "pictureId")
    public int getPictureId()
    {
        return pictureId;
    }

    public void setPictureId(int pictureId)
    {
        this.pictureId = pictureId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Picturetags that = (Picturetags) o;

        if (pictureTagId != that.pictureTagId) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return pictureTagId;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pictureId", referencedColumnName = "imageId", nullable = false, insertable = false,
            updatable = false)
    public Images getImagesByPictureId()
    {
        return imagesByPictureId;
    }

    public void setImagesByPictureId(Images imagesByPictureId)
    {
        this.imagesByPictureId = imagesByPictureId;
    }

    @ManyToOne
    @JoinColumn(name = "tagId", referencedColumnName = "tagId", nullable = false, insertable = false, updatable = false)
    public Tags getTagsByTagId()
    {
        return tagsByTagId;
    }

    public void setTagsByTagId(Tags tagsByTagId)
    {
        this.tagsByTagId = tagsByTagId;
    }
}
