package com.unilopers.mini_erp_escolar.repository;

import com.unilopers.mini_erp_escolar.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    boolean existsByEmail(String email);
    boolean existsByMatricula(String matricula);
}
