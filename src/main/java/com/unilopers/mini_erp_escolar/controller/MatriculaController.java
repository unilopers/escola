package com.unilopers.mini_erp_escolar.controller;

import com.unilopers.mini_erp_escolar.dto.MatriculaRequestDTO;
import com.unilopers.mini_erp_escolar.dto.MatriculaResponseDTO;
import com.unilopers.mini_erp_escolar.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<MatriculaResponseDTO> criar(@RequestBody MatriculaRequestDTO dto) {
        return ResponseEntity.ok(matriculaService.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<MatriculaResponseDTO>> listar() {
        return ResponseEntity.ok(matriculaService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        matriculaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}



