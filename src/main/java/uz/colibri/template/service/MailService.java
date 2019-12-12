package uz.colibri.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.colibri.template.dto.RequestMail;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;


    @Async
    public String sendMail(RequestMail requestMail){
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.postForObject("http://colibrisoftmailservice.herokuapp.com/sendMail",requestMail, String.class);
        }catch (Exception e){
            e.printStackTrace();
            return e.getCause().getLocalizedMessage();
        }
    }

    @Async
    void simpleMail(RequestMail requestMail){
        try {
            String email = requestMail.getEmailAddress();
            String title = requestMail.getTitle();
            String content = requestMail.getContent();

            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(email);
            msg.setSubject(title);
            msg.setText(content);
            javaMailSender.send(msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //for future
    public void testMail(){
        String email = "requestMail.getEmailAddress()";
        String title = "requestMail.getTitle()";
        String content = "requestMail.getContent()";

        new Thread(()->{
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo("zokirovbobur93@gmail.com");
            msg.setSubject(title);
            msg.setText(content);

            javaMailSender.send(msg);
        }).start();
    }

}
