package myapp.emailSenders;

import emailModels.RegistrationSuccessEmailModel;
import myapp.serviceContracts.EmailTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegistrationSuccessSender extends EmailTemplate<RegistrationSuccessEmailModel> {

    public RegistrationSuccessSender()
    {
        super("Registration success!");
    }

    @Override
    protected String BuildMessage(RegistrationSuccessEmailModel model)
    {

        return "Вы успешно зарегистрированы! \n" +
                "Ваш логин: " + model.getLogin() + "\n" +
                "Ваш пароль: " + model.getPassword() + "\n" +
                "Для активации аккаунта перейдите по ссылке." +
                "http://" + model.getHostName() +
                "/account/confirmation/" + model.getUserId() + "/" + model.getConfirmationToken();
    }
}
