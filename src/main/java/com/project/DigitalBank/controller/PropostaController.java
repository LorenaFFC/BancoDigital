package com.project.DigitalBank.controller;

import com.project.DigitalBank.domain.Proposta;
import com.project.DigitalBank.service.PropostaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("proposta")
public class PropostaController {

    PropostaService propostaService;

    public PropostaController(PropostaService propostaService) {
        this.propostaService = propostaService;
    }

    @GetMapping(path= "/{id}")
    public ResponseEntity<Proposta> findById( Long id){
        return  new ResponseEntity<>(propostaService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    private  ResponseEntity<Proposta> save(@RequestBody Proposta proposta){
        return new ResponseEntity<>(propostaService.save(proposta), HttpStatus.CREATED);
    }

    @PutMapping(path= "/{id}")
    private ResponseEntity<Proposta> aceite(Long id){
        propostaService.editAceite(id);
        return new ResponseEntity<>(propostaService.findById(id),HttpStatus.OK);
    }
}
