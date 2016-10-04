package myapp.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Message {
    private int messageId;
    private String text;
    private int dialogId;
    private Dialog dialogByDialogId;
    private int userId;
    private Users users;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "messageId")
    public int getMessageId()
    {
        return messageId;
    }

    public void setMessageId(int messageId)
    {
        this.messageId = messageId;
    }

    @Basic
    @NotEmpty
    @Column(name = "text")
    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
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

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false, insertable = false,
            updatable = false)
    public Users getUsers()
    {
        return users;
    }

    public void setUsers(Users users)
    {
        this.users = users;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (messageId != message.messageId) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return messageId;
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
