package com.unilopers.mini_erp_escolar.dto;

public record PresencaRequestDTO(
        Long alunoId,
        Long aulaId,
        Boolean presente
) {}
