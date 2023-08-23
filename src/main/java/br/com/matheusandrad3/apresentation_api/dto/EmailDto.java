package br.com.matheusandrad3.apresentation_api.dto;

import lombok.Data;

@Data
public class EmailDto {

    private String name;
    private String email;
    private String subject;
    private String message;
}
