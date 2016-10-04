package myapp.exceptions;

public class EntityAlreadyExistException extends Exception {

    public EntityAlreadyExistException(String entityName, String context)
    {
        super("Объект сущности " + entityName + " уже существует в контексте " + context);
    }
}
