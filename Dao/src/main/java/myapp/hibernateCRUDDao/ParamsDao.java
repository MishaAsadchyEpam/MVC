package myapp.hibernateCRUDDao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ParamsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public String findParamValue(String paramName)
    {
        return (String) sessionFactory.getCurrentSession().createQuery
                ("select param.paramValue from Params param where param.paramName = :paramName")
                .setString("paramName", paramName)
                .uniqueResult();
    }

    public void updateParam(String paramName, String paramValue)
    {
        sessionFactory.getCurrentSession().createQuery
                ("update Params param set param.paramValue = :paramValue where param.paramName = :paramName")
                .setString("paramName", paramName)
                .setString("paramValue", paramValue)
                .executeUpdate();
    }

}
