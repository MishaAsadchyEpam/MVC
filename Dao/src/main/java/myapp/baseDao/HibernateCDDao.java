package myapp.baseDao;

public abstract class HibernateCDDao<TEntity> extends AbstractDao {

    protected abstract TEntity find(int id);

    public void save(TEntity object)
    {
        getSession().save(object);
    }

    public void delete(int id)
    {
        getSession().delete(find(id));
    }


}
