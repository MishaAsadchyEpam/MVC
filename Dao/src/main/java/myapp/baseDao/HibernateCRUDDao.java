package myapp.baseDao;

public abstract class HibernateCRUDDao<TEntity> extends HibernateCDDao<TEntity> {

    public void update(TEntity object)
    {
        getSession().update(object);
    }

}
