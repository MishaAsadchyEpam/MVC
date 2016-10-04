package myapp.serviceContracts;

import java.util.List;

public interface IGetAllService<TEntity> {

    List<TEntity> getAll();

}
