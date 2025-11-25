package com.unilopers.mini_erp_escolar.repository;

import com.unilopers.mini_erp_escolar.model.Matricula;
import com.unilopers.mini_erp_escolar.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    boolean existsByAlunoIdAndTurmaId(Long alunoId, Long turmaId);
}


