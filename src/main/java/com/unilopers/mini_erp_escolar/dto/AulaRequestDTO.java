package com.unilopers.mini_erp_escolar.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AulaRequestDTO(

        @NotNull(message = "A data da aula é obrigatória.")
        @FutureOrPresent(message = "A data da aula não pode estar no passado.")
        LocalDate dataAula,

        @NotNull(message = "O ID da turma é obrigatório.")
        Long idTurma,

        @NotNull(message = "O ID da disciplina é obrigatório.")
        Long idDisciplina

) { }