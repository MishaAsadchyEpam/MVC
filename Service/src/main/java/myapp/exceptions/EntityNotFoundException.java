package myapp.exceptions;

public class EntityNotFoundException extends Exception {

    public EntityNotFoundException()
    {
        super("Объект запроса не найден");
    }
}
