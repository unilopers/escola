package com.unilopers.mini_erp_escolar.controller;
import com.unilopers.mini_erp_escolar.dto.NotaRequestDTO;
import com.unilopers.mini_erp_escolar.dto.NotaResponseDTO;
import com.unilopers.mini_erp_escolar.model.Nota;
import com.unilopers.mini_erp_escolar.service.NotaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @PostMapping
    public ResponseEntity<NotaResponseDTO> criar(@RequestBody @Valid NotaRequestDTO dto) {
        Nota notaCriada = notaService.criar(dto);
        return new ResponseEntity<>(new NotaResponseDTO(notaCriada), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<NotaResponseDTO>> buscarTodas() {
        List<NotaResponseDTO> notas = notaService.buscarTodas().stream()
                .map(NotaResponseDTO::new)
                .toList();
        return ResponseEntity.ok(notas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaResponseDTO> buscarPorId(@PathVariable Long id) {
        Nota nota = notaService.buscarPorId(id);
        return ResponseEntity.ok(new NotaResponseDTO(nota));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid NotaRequestDTO dto) {
        Nota notaAtualizada = notaService.atualizar(id, dto);
        return ResponseEntity.ok(new NotaResponseDTO(notaAtualizada));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        notaService.deletar(id);
    }

    @GetMapping("/media/{idAluno}")
    public ResponseEntity<BigDecimal> calcularMedia(@PathVariable Long idAluno) {
        BigDecimal media = notaService.calcularMediaGeralAluno(idAluno);
        return ResponseEntity.ok(media);
    }
}
