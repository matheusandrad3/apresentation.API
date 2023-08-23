package br.com.matheusandrad3.apresentation_api.controller;

import br.com.matheusandrad3.apresentation_api.models.Email;
import br.com.matheusandrad3.apresentation_api.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/message")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody Email message) {
        emailService.sendEmail(message);
        return ResponseEntity.ok("Mensagem enviada com sucesso!");
    }
}
