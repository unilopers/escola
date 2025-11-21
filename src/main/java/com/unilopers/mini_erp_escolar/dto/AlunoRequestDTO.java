package com.unilopers.mini_erp_escolar.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Data
public class AlunoRequestDTO {

    @NotBlank(message = "O nome é Obrigatório.")
    @Size(min = 3, max = 100, message = "O nome deve entre 3 e 100 caracteres.")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ ]+$", message = "O nome deve conter apenas letras e espaços.")
    private String nome;

    @NotBlank(message = "O email é Obrigatório.")
    @Email(message = "Email Inválido.")
    private String email;

    @NotBlank(message = "A matrícula é Obrigatória.")
    @Size(min = 5, max = 20, message = "O matrícula deve entre 5 e 20 caracteres.")
    @Pattern(regexp = "^[A-Za-z]{1,3}[0-9]{2,6}$", message = "Formato de matrícula inválido. EX: A1234 ou AB123")
    private String matricula;
}
