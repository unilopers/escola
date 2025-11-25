package com.unilopers.mini_erp_escolar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "presencas", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_aluno", "id_aula"})
})
public class Presenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presenca")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_aula", nullable = false)
    private Aula aula;

    @Column(nullable = false)
    private Boolean presente;

    public Presenca() {}

    public Presenca(Aluno aluno, Aula aula, Boolean presente) {
        this.aluno = aluno;
        this.aula = aula;
        this.presente = presente;
    }
    public Long getId() {
        return id;
    }
    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public Aula getAula() {
        return aula;
    }
    public void setAula(Aula aula) {
        this.aula = aula;
    }
    public Boolean getPresente() {
        return presente;
    }
    public void setPresente(Boolean presente) {
        this.presente = presente;
    }
}