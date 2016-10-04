package myapp.serviceContracts;

import emailModels.IEmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public abstract class EmailTemplate<EmailModel extends IEmailModel> {

    @Autowired
    private MailSender mailSender;

    private final String subject;

    public EmailTemplate(String subject)
    {
        this.subject = subject;
    }

    public void send(EmailModel model, String email)
    {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("mikhailasadchy@gmail.com");
        message.setTo(email);
        message.setSubject(subject);
        message.setText(BuildMessage(model));

        mailSender.send(message);
    }

    protected abstract String BuildMessage(EmailModel model);

}
