package myapp.services;

import myapp.entities.Message;
import myapp.hibernateCRUDDao.MessageHibernateCRUDDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MessageService {

    @Autowired
    private MessageHibernateCRUDDao messagehibernatecruddao;

    public void save(Message message)
    {
        messagehibernatecruddao.save(message);
    }

    public List<Message> getAll()
    {
        return messagehibernatecruddao.getAll();
    }

    public List<Message> findByDialogId(int dialogId)
    {
        return messagehibernatecruddao.findByDialogId(dialogId);
    }
}