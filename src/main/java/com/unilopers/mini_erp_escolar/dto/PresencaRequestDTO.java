package com.unilopers.mini_erp_escolar.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PresencaRequestDTO(
        @NotNull(message = "O ID do aluno é obrigatório.")
        @Positive(message = "O ID do aluno deve ser positivo.")
        Long alunoId,

        @NotNull(message = "O ID da aula é obrigatório.")
        @Positive(message = "O ID da aula deve ser positivo.")
        Long aulaId,

        @NotNull(message = "O status de presença é obrigatório.")
        Boolean presente
) {}
