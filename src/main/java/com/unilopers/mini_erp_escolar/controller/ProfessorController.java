package com.unilopers.mini_erp_escolar.controller;

import com.unilopers.mini_erp_escolar.dto.ProfessorRequestDTO;
import com.unilopers.mini_erp_escolar.dto.ProfessorResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @PostMapping
    public ProfessorResponseDTO criar(@RequestBody ProfessorRequestDTO dto) {
        return null;
    }

}
