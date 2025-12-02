package com.unilopers.mini_erp_escolar.dto;

public record MatriculaResponseDTO(
        Long id,
        Long alunoId,
        Long turmaId,
        String nomeAluno,
        String nomeTurma
) {}
