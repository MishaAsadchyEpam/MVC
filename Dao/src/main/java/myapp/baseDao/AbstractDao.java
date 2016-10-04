package myapp.baseDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }


}
