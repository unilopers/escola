package com.unilopers.mini_erp_escolar.service;
import com.unilopers.mini_erp_escolar.dto.NotaRequestDTO;
import com.unilopers.mini_erp_escolar.model.Aluno;
import com.unilopers.mini_erp_escolar.model.Disciplina;
import com.unilopers.mini_erp_escolar.model.Nota;
import com.unilopers.mini_erp_escolar.repository.AlunoRepository;
import com.unilopers.mini_erp_escolar.repository.DisciplinaRepository;
import com.unilopers.mini_erp_escolar.repository.NotaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class NotaService {

    private final NotaRepository notaRepository;
    private final AlunoRepository alunoRepository;
    private final DisciplinaRepository disciplinaRepository;

    public NotaService(NotaRepository notaRepository, AlunoRepository alunoRepository, DisciplinaRepository disciplinaRepository) {
        this.notaRepository = notaRepository;
        this.alunoRepository = alunoRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    private Aluno buscarAluno(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado com ID: " + id));
    }

    private Disciplina buscarDisciplina(Long id) {
        return disciplinaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Disciplina não encontrada com ID: " + id));
    }

    @Transactional
    public Nota criar(NotaRequestDTO dto) {
        Aluno aluno = buscarAluno(dto.idAluno());
        Disciplina disciplina = buscarDisciplina(dto.idDisciplina());

        Nota nota = new Nota(dto.nota(), aluno, disciplina);
        return notaRepository.save(nota);
    }

    public List<Nota> buscarTodas() {
        return notaRepository.findAll();
    }
    
    public Nota buscarPorId(Long id) {
        return notaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nota não encontrada com ID: " + id)); //FALTOU O PONTO E VÍRGULA
    }
  
    @Transactional
    public void deletar(Long id) {
        if (!notaRepository.existsById(id)) {
            throw new EntityNotFoundException("Não é possível deletar. Nota não encontrada com ID: " + id);
        }
        notaRepository.deleteById(id);
    }

    @Transactional
    public Nota atualizar(Long id, NotaRequestDTO dto) {
        Nota notaExistente = buscarPorId(id);

        notaExistente.setNota(dto.nota());
        
        if (!notaExistente.getAluno().getId().equals(dto.idAluno())) {
            notaExistente.setAluno(buscarAluno(dto.idAluno()));
        }
        if (!notaExistente.getDisciplina().getId().equals(dto.idDisciplina())) {
            notaExistente.setDisciplina(buscarDisciplina(dto.idDisciplina()));
        }
        
        return notaRepository.save(notaExistente);
    }
    
    public BigDecimal calcularMediaGeralAluno(Long idAluno) {
        BigDecimal media = notaRepository.calcularMediaGeralPorAluno(idAluno);
        
        return media != null ? media : BigDecimal.ZERO;
    }
}
