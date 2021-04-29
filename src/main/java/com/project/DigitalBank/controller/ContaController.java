package com.project.DigitalBank.controller;

import com.project.DigitalBank.domain.Conta;
import com.project.DigitalBank.service.ContaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contas")
public class ContaController {

    private ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    private List<Conta> findAll(){
        return contaService.findAll();
    }
}
