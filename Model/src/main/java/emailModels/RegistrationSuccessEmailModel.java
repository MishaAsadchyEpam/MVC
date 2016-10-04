package emailModels;

public class RegistrationSuccessEmailModel implements IEmailModel {

    private final int userId;

    private final String login;

    private final String password;

    private final String confirmationToken;

    private final String hostName;

    public int getUserId()
    {
        return userId;
    }

    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }

    public String getConfirmationToken()
    {
        return confirmationToken;
    }

    public String getHostName()
    {
        return hostName;
    }

    public RegistrationSuccessEmailModel(
            int userId, String login, String password,
            String confirmationToken, String hostName)
    {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.confirmationToken = confirmationToken;
        this.hostName = hostName;
    }
}
