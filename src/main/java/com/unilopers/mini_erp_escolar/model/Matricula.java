package com.unilopers.mini_erp_escolar.model;

import jakarta.persistence.*;

@Entity
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

    // getters e setters
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Turma getTurma() {
        return turma;
    }
}

