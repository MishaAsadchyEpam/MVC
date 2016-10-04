package myapp.exceptions;

public class UserNotAChatMemberException extends Exception {

    public UserNotAChatMemberException()
    {
        super("Пользователь не участвует в чате");
    }
}
