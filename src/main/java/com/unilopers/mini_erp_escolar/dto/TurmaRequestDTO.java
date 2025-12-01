package com.unilopers.mini_erp_escolar.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TurmaRequestDTO {

    @NotBlank(message = "O nome da turma é obrigatório.")
    @Size(min = 2, max = 100, message = "O nome da turma deve ter entre 2 e 100 caracteres.")
    private String nome;

    @NotNull(message = "O ID do professor é obrigatório.")
    private Long professorId;

    public Long getProfessorId() { return professorId; }
    public void setProfessorId(Long professorId) { this.professorId = professorId; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
