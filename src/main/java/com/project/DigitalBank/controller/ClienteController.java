package com.project.DigitalBank.controller;

import com.project.DigitalBank.domain.Cliente;
import com.project.DigitalBank.service.ClienteService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.function.ServerRequest;

import javax.validation.Valid;
import java.net.URI;
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
    private ResponseEntity<Object> save(@RequestBody @Valid Cliente cliente) {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(URI.create("/enderecos"));

        return new ResponseEntity<Object>(clienteService.save(cliente),responseHeaders, HttpStatus.CREATED);

    }
}
