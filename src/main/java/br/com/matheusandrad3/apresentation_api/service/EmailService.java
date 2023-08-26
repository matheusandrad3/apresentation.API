package br.com.matheusandrad3.apresentation_api.service;

import br.com.matheusandrad3.apresentation_api.models.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@Service
@Slf4j
public class EmailService {


    private final AmazonSESCA aws;

    @Autowired
    public EmailService(AmazonSESCA aws) {
        this.aws = aws;
    }

    public void sendEmail (Email email) throws MessagingException, UnsupportedEncodingException {
        log.info("Enviando email from: [{}]", email.getEmail());
        aws.sendEmail(email);
        log.info("Mensagem enviada com sucesso");
    }
}
