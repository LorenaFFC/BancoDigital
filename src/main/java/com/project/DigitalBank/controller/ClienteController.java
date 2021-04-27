package com.project.DigitalBank.controller;

import com.project.DigitalBank.domain.Cliente;
import com.project.DigitalBank.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    private ResponseEntity<List<Cliente>> findAll() {
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }
    @GetMapping(path="/{id}")
    private ResponseEntity<Cliente> findById(@PathVariable long id) {
        return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    private ResponseEntity<Cliente> save(@RequestBody @Valid Cliente cliente) {

            return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);

    }
}
