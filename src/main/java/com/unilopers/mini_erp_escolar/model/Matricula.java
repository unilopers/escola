package com.unilopers.mini_erp_escolar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "matriculas",
        uniqueConstraints = @UniqueConstraint(columnNames = {"aluno_id", "turma_id"}))
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne(optional = false)
    @JoinColumn(name = "turma_id")
    private Turma turma;
}
