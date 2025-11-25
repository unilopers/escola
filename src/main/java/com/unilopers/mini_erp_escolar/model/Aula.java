package com.unilopers.mini_erp_escolar.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "aulas")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    private Long id;

    @Column(name = "data_aula", nullable = false)
    private LocalDate dataAula;

    @ManyToOne
    @JoinColumn(name = "id_turma", nullable = false)
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false)
    private Disciplina disciplina;

    public Aula() {}

    public Aula(LocalDate dataAula, Turma turma, Disciplina disciplina) {
        this.dataAula = dataAula;
        this.turma = turma;
        this.disciplina = disciplina;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataAula() {
        return dataAula;
    }

    public void setDataAula(LocalDate dataAula) {
        this.dataAula = dataAula;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
