package myapp.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "usersdialogs")
public class UsersDialog {
    private int userDilogId;
    private int userId;
    private int dialogId;
    private Users usersByUserId;
    private Dialog dialogByDialogId;

    public UsersDialog(int userId, int dialogId)
    {
        this.userId = userId;
        this.dialogId = dialogId;
    }

    public UsersDialog()
    {
    }


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "userDilogId")
    public int getUserDilogId()
    {
        return userDilogId;
    }

    public void setUserDilogId(int userDilogId)
    {
        this.userDilogId = userDilogId;
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
    @Column(name = "dialogId")
    public int getDialogId()
    {
        return dialogId;
    }

    public void setDialogId(int dialogId)
    {
        this.dialogId = dialogId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersDialog that = (UsersDialog) o;

        if (dialogId != that.dialogId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = userId;
        result = 31 * result + dialogId;
        return result;
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

    @ManyToOne
    @JoinColumn(name = "dialogId", referencedColumnName = "dialogId", nullable = false, insertable = false,
            updatable = false)
    public Dialog getDialogByDialogId()
    {
        return dialogByDialogId;
    }

    public void setDialogByDialogId(Dialog dialogByDialogId)
    {
        this.dialogByDialogId = dialogByDialogId;
    }
}
