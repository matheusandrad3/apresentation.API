package br.com.matheusandrad3.apresentation_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Email {

    @Id
    private Long id;
    private String email;
    private String name;
    private String subject;
    private String message;
    private String from;

}
