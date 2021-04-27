package com.project.DigitalBank.controller;

import com.project.DigitalBank.domain.Endereco;
import com.project.DigitalBank.service.EnderecoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.GeneratedValue;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {

    private EnderecoService enderecoService;


    private EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    private ResponseEntity<List<Endereco>> findAll(){
        return new ResponseEntity<>(enderecoService.findAll(), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    private ResponseEntity<Endereco> findById(Long id){
        return new ResponseEntity<>(enderecoService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Object> save(@RequestBody @Valid  Endereco endereco){

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(URI.create("/upload"));
        return new ResponseEntity<>(enderecoService.save(endereco), responseHeaders, HttpStatus.CREATED);

    }
}
