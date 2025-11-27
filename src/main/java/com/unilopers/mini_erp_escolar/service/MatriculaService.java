package com.unilopers.mini_erp_escolar.service;

import com.unilopers.mini_erp_escolar.dto.MatriculaRequestDTO;
import com.unilopers.mini_erp_escolar.dto.MatriculaResponseDTO;
import com.unilopers.mini_erp_escolar.model.Aluno;
import com.unilopers.mini_erp_escolar.model.Matricula;
import com.unilopers.mini_erp_escolar.model.Turma;
import com.unilopers.mini_erp_escolar.repository.AlunoRepository;
import com.unilopers.mini_erp_escolar.repository.MatriculaRepository;
import com.unilopers.mini_erp_escolar.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    public MatriculaResponseDTO criar(MatriculaRequestDTO dto) {

        if (matriculaRepository.existsByAlunoIdAndTurmaId(dto.alunoId(), dto.turmaId())) {
            throw new RuntimeException("Aluno já está matriculado nessa turma.");
        }

        Aluno aluno = alunoRepository.findById(dto.alunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Turma turma = turmaRepository.findById(dto.turmaId())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        matricula.setTurma(turma);

        matriculaRepository.save(matricula);

        return new MatriculaResponseDTO(
                matricula.getId(),
                aluno.getId(),
                turma.getId(),
                aluno.getNome(),
                turma.getNome()
        );
    }

    public List<MatriculaResponseDTO> listar() {
        return matriculaRepository.findAll().stream()
                .map(m -> new MatriculaResponseDTO(
                        m.getId(),
                        m.getAluno().getId(),
                        m.getTurma().getId(),
                        m.getAluno().getNome(),
                        m.getTurma().getNome()
                ))
                .toList();
    }

    public void deletar(Long id) {
        matriculaRepository.deleteById(id);
    }
}

