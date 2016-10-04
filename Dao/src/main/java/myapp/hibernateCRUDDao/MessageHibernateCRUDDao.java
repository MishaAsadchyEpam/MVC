package myapp.hibernateCRUDDao;

import myapp.baseDao.HibernateCRUDDao;
import myapp.entities.Message;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MessageHibernateCRUDDao extends HibernateCRUDDao<Message> {
    @Override
    public Message find(int id)
    {
        return (Message) getSession().get(Message.class, id);
    }

    public List<Message> getAll()
    {
        return (List<Message>) getSession().createQuery("from Message").list();
    }

    public List<Message> findByDialogId(int dialogId)
    {
        return (List<Message>) getSession().createQuery
                ("from Message message where message.dialogId = :dialogId order by message.messageId")
                .setInteger("dialogId", dialogId)
                .list();
    }
}