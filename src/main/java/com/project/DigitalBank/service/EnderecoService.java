package com.project.DigitalBank.service;

import com.project.DigitalBank.domain.Cliente;
import com.project.DigitalBank.domain.Endereco;
import com.project.DigitalBank.repository.ClienteRepository;
import com.project.DigitalBank.repository.EnderecoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EnderecoService {

    EnderecoRepository enderecoRepository;
    ClienteService clienteService;
    ClienteRepository clienteRepository;

    public EnderecoService(EnderecoRepository enderecoRepository, ClienteService clienteService,ClienteRepository clienteRepository) {
        this.enderecoRepository = enderecoRepository;
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
    }

    public List<Endereco> findAll(){
        return  enderecoRepository.findAll();
    }

    public  Endereco findById(Long id){
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Endereço não encontrado"));
    }

    public Endereco save(Endereco endereco){
        Long idCliente = endereco.getCliente().getId();

        Cliente cli = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não existe!!"));
        endereco.setCliente(cli);
        return enderecoRepository.save(endereco);


    }
}
