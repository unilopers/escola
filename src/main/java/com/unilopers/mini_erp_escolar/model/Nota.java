package com.unilopers.mini_erp_escolar.model;

import java.math.BigDecimal;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "notas")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNota;

    @Column(nullable = false, precision = 5, scale = 2)
    @NotNull(message = "A nota é obrigatória.")
    @DecimalMin(value = "0.00", message = "A nota mínima deve ser 0.00.")
    @DecimalMax(value = "10.00", message = "A nota máxima deve ser 10.00.")
    private BigDecimal nota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_disciplina", nullable = false)
    private Disciplina disciplina;

    public Nota(BigDecimal nota, Aluno aluno, Disciplina disciplina) {
        this.nota = nota;
        this.aluno = aluno;
        this.disciplina = disciplina;
    }
}
