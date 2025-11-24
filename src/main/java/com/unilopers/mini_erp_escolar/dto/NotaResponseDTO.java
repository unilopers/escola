package com.unilopers.mini_erp_escolar.dto;
import java.math.BigDecimal;
import com.unilopers.mini_erp_escolar.model.Nota;

public record NotaResponseDTO(
    Long idNota,
    String nomeAluno,
    String nomeDisciplina,
    BigDecimal nota
) {
    public NotaResponseDTO(Nota nota) {
        this(
            nota.getIdNota(),
            nota.getAluno().getNome(),
            nota.getDisciplina().getNome(),
            nota.getNota()
        );
    }
}
