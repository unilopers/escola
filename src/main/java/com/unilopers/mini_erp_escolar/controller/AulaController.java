package com.unilopers.mini_erp_escolar.controller;

import com.unilopers.mini_erp_escolar.dto.AulaRequestDTO;
import com.unilopers.mini_erp_escolar.dto.AulaResponseDTO;
import com.unilopers.mini_erp_escolar.model.Aula;
import com.unilopers.mini_erp_escolar.model.Turma;
import com.unilopers.mini_erp_escolar.model.Disciplina;
import com.unilopers.mini_erp_escolar.repository.AulaRepository;
import com.unilopers.mini_erp_escolar.repository.TurmaRepository;
import com.unilopers.mini_erp_escolar.repository.DisciplinaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @PostMapping
    public AulaResponseDTO criar(@RequestBody AulaRequestDTO dto) {

        Turma turma = turmaRepository.findById(dto.idTurma())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        Disciplina disciplina = disciplinaRepository.findById(dto.idDisciplina())
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        Aula aula = new Aula(dto.dataAula(), turma, disciplina);
        Aula salva = aulaRepository.save(aula);

        return new AulaResponseDTO(
                salva.getId(),
                salva.getDataAula(),
                salva.getTurma().getId(),
                salva.getDisciplina().getId()
        );
    }

    @GetMapping
    public List<AulaResponseDTO> listar() {
        return aulaRepository.findAll().stream()
                .map(a -> new AulaResponseDTO(
                        a.getId(),
                        a.getDataAula(),
                        a.getTurma().getId(),
                        a.getDisciplina().getId()
                ))
                .toList();
    }

    @GetMapping("/{id}")
    public AulaResponseDTO buscar(@PathVariable Long id) {
        Aula a = aulaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula não encontrada"));

        return new AulaResponseDTO(
                a.getId(),
                a.getDataAula(),
                a.getTurma().getId(),
                a.getDisciplina().getId()
        );
    }

    @PutMapping("/{id}")
    public AulaResponseDTO atualizar(@PathVariable Long id, @RequestBody AulaRequestDTO dto) {

        Aula a = aulaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula não encontrada"));

        Turma turma = turmaRepository.findById(dto.idTurma())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        Disciplina disciplina = disciplinaRepository.findById(dto.idDisciplina())
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        a.setDataAula(dto.dataAula());
        a.setTurma(turma);
        a.setDisciplina(disciplina);
        Aula atualizado = aulaRepository.save(a);

        return new AulaResponseDTO(
                atualizado.getId(),
                atualizado.getDataAula(),
                atualizado.getTurma().getId(),
                atualizado.getDisciplina().getId()
        );
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        aulaRepository.deleteById(id);
    }
}
