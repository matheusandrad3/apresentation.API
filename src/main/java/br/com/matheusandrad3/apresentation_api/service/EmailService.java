package br.com.matheusandrad3.apresentation_api.service;

import br.com.matheusandrad3.apresentation_api.models.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    public void sendEmail (Email email) {
        log.info("Mensagem enviada com sucesso");
    }
}
