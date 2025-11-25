package com.unilopers.mini_erp_escolar.dto;

public record PresencaResponseDTO(
        Long id,
        Long alunoId,
        Long aulaId,
        Boolean presente
) {}