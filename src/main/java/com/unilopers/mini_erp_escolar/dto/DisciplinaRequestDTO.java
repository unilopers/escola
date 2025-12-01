package com.unilopers.mini_erp_escolar.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DisciplinaRequestDTO(

        @NotBlank(message = "O nome da disciplina é obrigatório.")
        @Size(min = 3, max = 100, message = "O nome da disciplina deve ter entre 3 e 100 caracteres.")
        @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ ]+$",
                message = "O nome da disciplina deve conter apenas letras e espaços.")
        String nome

) {}