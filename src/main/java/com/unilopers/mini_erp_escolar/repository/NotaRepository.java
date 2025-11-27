package com.unilopers.mini_erp_escolar.repository; 
import com.unilopers.mini_erp_escolar.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByAlunoId(Long idAluno); 
    
    @Query("SELECT AVG(n.nota) FROM Nota n WHERE n.aluno.id = :idAluno")
    BigDecimal calcularMediaGeralPorAluno(Long idAluno);
}
