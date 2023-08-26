package br.com.matheusandrad3.apresentation_api.service;

import br.com.matheusandrad3.apresentation_api.models.Email;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

@Service
public class AmazonSESCA {
    public void sendEmail(Email email) throws UnsupportedEncodingException, MessagingException {

        String FROM = "matheusandradedesouza77@gmail.com";
        String FROMNAME = email.getName();
        String TO = "matheusandradedesouza77@gmail.com";
        String SMTP_USERNAME = "SUA CREDENCIAL";
        String SMTP_PASSWORD = "SUA CREDENCIAL";
        String HOST = "email-smtp.us-east-1.amazonaws.com";
        int PORT = 587;
        String SUBJECT = email.getSubject();
        String BODY = "<h1>Nome: </h1>" + email.getName() +
                "<p> Email: </p>" + email.getEmail()
                + "</p>" + email.getMessage() + "</p>";

        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        System.setProperty("mail.debug", "true");

        Session session = Session.getDefaultInstance(props);

        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM,FROMNAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        msg.setSubject(SUBJECT);
        msg.setContent(BODY,"text/html");

        try (Transport transport = session.getTransport()) {
            System.out.println("Sending...");
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        } catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        }
    }

