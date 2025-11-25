package com.unilopers.mini_erp_escolar.repository;

import com.unilopers.mini_erp_escolar.model.Presenca;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface PresencaRepository extends JpaRepository<Presenca, Long> {

    Optional<Presenca> findByAlunoIdAndAulaId(Long alunoId, Long aulaId);

    List<Presenca> findByAlunoId(Long alunoId);

    List<Presenca> findByAulaId(Long aulaId);
}