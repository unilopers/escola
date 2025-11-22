package com.unilopers.mini_erp_escolar.controller;

import com.unilopers.mini_erp_escolar.dto.ProfessorRequestDTO;
import com.unilopers.mini_erp_escolar.dto.ProfessorResponseDTO;
import com.unilopers.mini_erp_escolar.model.Professor;
import com.unilopers.mini_erp_escolar.repository.ProfessorRepository;
import org.aspectj.apache.bcel.classfile.annotation.RuntimeInvisTypeAnnos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    public ProfessorResponseDTO criar(@RequestBody ProfessorRequestDTO dto) {
        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());

        Professor salvo = professorRepository.save(professor);

        ProfessorResponseDTO response = new ProfessorResponseDTO();
        response.setId(salvo.getId());
        response.setNome(salvo.getNome());
        response.setEmail(salvo.getEmail());

        return response;
    }

    //GET (lista todos)
    @GetMapping
    public List<ProfessorResponseDTO> listar() {
        return professorRepository.findAll().stream()
                .map(prof -> {
                    ProfessorResponseDTO dto = new ProfessorResponseDTO();
                    dto.setId((prof.getId()));
                    dto.setNome(prof.getNome());
                    dto.setEmail(prof.getEmail());
                    return dto;
                })
                .toList();
    }

    //GET (por ID)
    @GetMapping("/{id}")
    public  ProfessorResponseDTO buscarPorId(@PathVariable Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        ProfessorResponseDTO dto = new ProfessorResponseDTO();
        dto.setId(professor.getId());
        dto.setNome(professor.getNome());
        dto.setEmail(professor.getEmail());

        return  dto;
    }

    //UPDATE
    @PutMapping("/{id}")
    public ProfessorResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody ProfessorRequestDTO dto) {

        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());

        Professor atualizado = professorRepository.save(professor);

        ProfessorResponseDTO resp = new ProfessorResponseDTO();
        resp.setId(atualizado.getId());
        resp.setNome(atualizado.getNome());
        resp.setEmail(atualizado.getEmail());

        return resp;
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        if (!professorRepository.existsById(id)) {
            throw new RuntimeException("Professor não encontrado");
        }
        professorRepository.deleteById(id);
    }



}
