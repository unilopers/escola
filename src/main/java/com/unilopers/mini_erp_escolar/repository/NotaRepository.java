package com.unilopers.mini_erp_escolar.repository; 
import com.unilopers.mini_erp_escolar.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByAlunoId(Long idAluno); 
}
