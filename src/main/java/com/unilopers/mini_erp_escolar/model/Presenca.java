package com.unilopers.mini_erp_escolar.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "presencas", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"aluno_id", "aula_id"})
})
public class Presenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne(optional = false)
    @JoinColumn(name = "aula_id")
    private Aula aula;

    @Column(nullable = false)
    private Boolean presente;

    @Column(nullable = false)
    private LocalDateTime dataRegistro = LocalDateTime.now();
    //tentativa2 de commit
}