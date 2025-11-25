package com.unilopers.mini_erp_escolar.controller;

import com.unilopers.mini_erp_escolar.repository.AulaRepository;
import com.unilopers.mini_erp_escolar.repository.TurmaRepository;
import com.unilopers.mini_erp_escolar.repository.DisciplinaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

}
