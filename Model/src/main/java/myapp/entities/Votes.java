package myapp.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Votes {
    private int voteId;
    private int pictureId;
    private int userId;
    private Images imagesByPictureId;
    private Users usersByUserId;

    public Votes()
    {
    }

    public Votes(int pictureId, int userId)
    {
        this.pictureId = pictureId;
        this.userId = userId;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "voteId")
    public int getVoteId()
    {
        return voteId;
    }

    public void setVoteId(int voteId)
    {
        this.voteId = voteId;
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

        Votes votes = (Votes) o;

        if (voteId != votes.voteId) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return voteId;
    }

    @ManyToOne
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
