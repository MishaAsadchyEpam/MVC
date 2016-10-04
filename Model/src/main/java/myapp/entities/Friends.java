package myapp.entities;

import javax.persistence.*;

@Entity
public class Friends {
    private int friendId;
    private int userIdFirst;
    private int userIdSecond;
    private Users usersByUserIdFirst;

    public Friends()
    {
    }

    public Friends(int userIdFirst, int userIdSecond)
    {
        this.userIdFirst = userIdFirst;
        this.userIdSecond = userIdSecond;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friends friends = (Friends) o;

        if (friendId != friends.friendId) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return friendId;
    }

    @Id
    @Column(name = "friendId")
    public int getFriendId()
    {
        return friendId;
    }

    public void setFriendId(int friendId)
    {
        this.friendId = friendId;
    }

    @Basic
    @Column(name = "userIdFirst")
    public int getUserIdFirst()
    {
        return userIdFirst;
    }

    public void setUserIdFirst(int userIdFirst)
    {
        this.userIdFirst = userIdFirst;
    }

    @Basic
    @Column(name = "userIdSecond")
    public int getUserIdSecond()
    {
        return userIdSecond;
    }

    public void setUserIdSecond(int userIdSecond)
    {
        this.userIdSecond = userIdSecond;
    }

    @ManyToOne
    @JoinColumn(name = "userIdFirst", referencedColumnName = "userId", nullable = false, insertable = false,
            updatable = false)
    public Users getUsersByUserIdFirst()
    {
        return usersByUserIdFirst;
    }

    public void setUsersByUserIdFirst(Users usersByUserIdFirst)
    {
        this.usersByUserIdFirst = usersByUserIdFirst;
    }
}
