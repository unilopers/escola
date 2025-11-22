package com.unilopers.mini_erp_escolar.controller;

import com.api.escola.dto.DisciplinaRequestDTO;
import com.api.escola.dto.DisciplinaResponseDTO;
import com.api.escola.model.Disciplina;
import com.api.escola.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    // CREATE
    @PostMapping
    public DisciplinaResponseDTO criar(@RequestBody DisciplinaRequestDTO dto) {
        Disciplina disciplina = new Disciplina(dto.nome());
        Disciplina salva = disciplinaRepository.save(disciplina);
        return new DisciplinaResponseDTO(salva.getId(), salva.getNome());
    }

    // GET - LISTA
    @GetMapping
    public List<DisciplinaResponseDTO> listar() {
        return disciplinaRepository.findAll()
                .stream()
                .map(d -> new DisciplinaResponseDTO(d.getId(), d.getNome()))
                .toList();
    }

    // GET - BUSCA POR ID
    @GetMapping("/{id}")
    public DisciplinaResponseDTO buscarPorId(@PathVariable Long id) {
        Disciplina d = disciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        return new DisciplinaResponseDTO(d.getId(), d.getNome());
    }

