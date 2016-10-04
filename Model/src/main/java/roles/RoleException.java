package roles;

public class RoleException extends Exception {

    public RoleException()
    {
        super("Такие права не найдены или не существуют.");
    }
}
