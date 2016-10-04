package myapp.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Dialog {
    private int dialogId;
    private String membersString;

    private Collection<Message> messagesByDialogId;
    private Collection<UsersDialog> usersdialogsesByDialogId;

    public Dialog()
    {
        this.membersString = "";
    }

    public Dialog(String membersString)
    {
        this.membersString = membersString;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
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
    @Column(name = "membersString")
    @NotNull
    @NotEmpty
    @Size(max = 100)
    public String getMembersString()
    {
        return membersString;
    }

    public void setMembersString(String membersString)
    {
        this.membersString = membersString;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dialog that = (Dialog) o;

        if (dialogId != that.dialogId) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return dialogId;
    }

    @OneToMany(mappedBy = "dialogByDialogId")
    public Collection<Message> getMessagesByDialogId()
    {
        return messagesByDialogId;
    }

    public void setMessagesByDialogId(Collection<Message> messagesByDialogId)
    {
        this.messagesByDialogId = messagesByDialogId;
    }

    @OneToMany(mappedBy = "dialogByDialogId")
    public Collection<UsersDialog> getUsersdialogsesByDialogId()
    {
        return usersdialogsesByDialogId;
    }

    public void setUsersdialogsesByDialogId(Collection<UsersDialog> usersdialogsesByDialogId)
    {
        this.usersdialogsesByDialogId = usersdialogsesByDialogId;
    }
}
