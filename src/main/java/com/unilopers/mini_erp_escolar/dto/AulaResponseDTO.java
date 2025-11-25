package com.unilopers.mini_erp_escolar.dto;

import java.time.LocalDate;

public record AulaResponseDTO(
        Long id,
        LocalDate dataAula,
        Long idTurma,
        Long idDisciplina
) {}
