package com.unilopers.mini_erp_escolar.controller;

import com.unilopers.mini_erp_escolar.repository.AlunoRepository;
import com.unilopers.mini_erp_escolar.dto.AlunoRequestDTO;
import com.unilopers.mini_erp_escolar.dto.AlunoResponseDTO;
import com.unilopers.mini_erp_escolar.model.Aluno;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public AlunoResponseDTO criarAluno(@Valid @RequestBody AlunoRequestDTO dto){

        if (alunoRepository.existsByMatricula(dto.getMatricula())){
            throw new RuntimeException("Matrícula já cadastrada.");
        }

        if (alunoRepository.existsByEmail(dto.getEmail())){
            throw new RuntimeException("Email já cadastrada.");
        }

        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setMatricula(dto.getMatricula());

        alunoRepository.save(aluno);

        return toResponse(aluno);
    }

    @GetMapping
    public List<AlunoResponseDTO> listarAlunos(){
        return alunoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AlunoResponseDTO buscarPorId(@PathVariable Long id){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));

        return toResponse(aluno);
    }

    @PutMapping("/{id}")
    public AlunoResponseDTO atualizarAluno(@PathVariable Long id, @RequestBody @Valid AlunoRequestDTO dto){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));

        if (!aluno.getEmail().equalsIgnoreCase(dto.getEmail()) && alunoRepository.existsByEmail(dto.getEmail())){
            throw new RuntimeException("Email já cadastrado por outro aluno.");
        }

        if (!aluno.getMatricula().equalsIgnoreCase(dto.getMatricula()) && alunoRepository.existsByMatricula(dto.getMatricula())){
            throw new RuntimeException("Matrícula já cadastrada por outro aluno.");
        }

        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setMatricula(dto.getMatricula());

        alunoRepository.save(aluno);

        return toResponse(aluno);
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id){
        if(!alunoRepository.existsById(id)){
            throw new RuntimeException("Aluno não encontrado!");
        }
        alunoRepository.deleteById(id);
    }

    private AlunoResponseDTO toResponse(Aluno aluno){
        AlunoResponseDTO dto = new AlunoResponseDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        dto.setMatricula(aluno.getMatricula());
        return dto;
    }
}
