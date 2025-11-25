package com.unilopers.mini_erp_escolar.dto;

import java.time.LocalDate;

public record AulaRequestDTO(
        LocalDate dataAula,
        Long idTurma,
        Long idDisciplina
) {}
