package com.unilopers.mini_erp_escolar.controller;

import com.unilopers.mini_erp_escolar.dto.PresencaRequestDTO;
import com.unilopers.mini_erp_escolar.dto.PresencaResponseDTO;
import com.unilopers.mini_erp_escolar.service.PresencaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/presencas")
public class PresencaController {

    private final PresencaService presencaService;

    public PresencaController(PresencaService presencaService) {
        this.presencaService = presencaService;
    }

    @PostMapping
    public PresencaResponseDTO registrar(@RequestBody @Valid PresencaRequestDTO dto) {
        return presencaService.registrar(dto);
    }

    @GetMapping("/aluno/{alunoId}")
    public List<PresencaResponseDTO> listarPorAluno(@PathVariable Long alunoId) {
        return presencaService.listarPorAluno(alunoId);
    }

    @GetMapping("/aula/{aulaId}")
    public List<PresencaResponseDTO> listarPorAula(@PathVariable Long aulaId) {
        return presencaService.listarPorAula(aulaId);
    }
}
