package myapp.serviceContracts;

public interface ICrudService<TEntity> {

    void save(TEntity object);

    void update(TEntity object);

    TEntity find(int id);

    void delete(int id);

}
