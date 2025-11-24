package com.unilopers.mini_erp_escolar.dto;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record NotaRequestDTO(
    @NotNull(message = "O ID do aluno é obrigatório.")
    Long idAluno,
    
    @NotNull(message = "O ID da disciplina é obrigatório.")
    Long idDisciplina,
    
    @NotNull(message = "A nota é obrigatória.")
    @DecimalMin(value = "0.00", message = "A nota mínima deve ser 0.00.")
    @DecimalMax(value = "100.00", message = "A nota máxima deve ser 100.00.")
    BigDecimal nota
) {
}
