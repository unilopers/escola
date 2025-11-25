package com.unilopers.mini_erp_escolar.service;

import com.unilopers.mini_erp_escolar.dto.PresencaRequestDTO;
import com.unilopers.mini_erp_escolar.dto.PresencaResponseDTO;
import com.unilopers.mini_erp_escolar.model.Aluno;
import com.unilopers.mini_erp_escolar.model.Aula;
import com.unilopers.mini_erp_escolar.model.Presenca;
import com.unilopers.mini_erp_escolar.repository.AlunoRepository;
import com.unilopers.mini_erp_escolar.repository.AulaRepository;
import com.unilopers.mini_erp_escolar.repository.PresencaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PresencaService {

    private final PresencaRepository presencaRepository;
    private final AlunoRepository alunoRepository;
    private final AulaRepository aulaRepository;

    public PresencaService(PresencaRepository presencaRepository,
                           AlunoRepository alunoRepository,
                           AulaRepository aulaRepository) {
        this.presencaRepository = presencaRepository;
        this.alunoRepository = alunoRepository;
        this.aulaRepository = aulaRepository;
    }

    public PresencaResponseDTO registrar(PresencaRequestDTO dto) {
        Aluno aluno = alunoRepository.findById(dto.alunoId())
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        Aula aula = aulaRepository.findById(dto.aulaId())
                .orElseThrow(() -> new EntityNotFoundException("Aula não encontrada"));

        Presenca presenca = new Presenca();
        presenca.setAluno(aluno);
        presenca.setAula(aula);
        presenca.setPresente(dto.presente());

        Presenca salvo = presencaRepository.save(presenca);

        return new PresencaResponseDTO(
                salvo.getId(),
                salvo.getAluno().getId(),
                salvo.getAula().getId(),
                salvo.getPresente()
        );
    }

    public List<PresencaResponseDTO> listarPorAluno(Long alunoId) {
        return presencaRepository.findByAlunoId(alunoId)
                .stream()
                .map(p -> new PresencaResponseDTO(
                        p.getId(),
                        p.getAluno().getId(),
                        p.getAula().getId(),
                        p.getPresente()))
                .toList();
    }

    public List<PresencaResponseDTO> listarPorAula(Long aulaId) {
        return presencaRepository.findByAulaId(aulaId)
                .stream()
                .map(p -> new PresencaResponseDTO(
                        p.getId(),
                        p.getAluno().getId(),
                        p.getAula().getId(),
                        p.getPresente()))
                .toList();
    }
}
