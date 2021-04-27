package com.project.DigitalBank.service;

import com.project.DigitalBank.domain.Endereco;
import com.project.DigitalBank.repository.EnderecoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EnderecoService {

    EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> findAll(){
        return  enderecoRepository.findAll();
    }

    public  Endereco findById(Long id){
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Endereço não encontrado"));
    }

    public Endereco save(Endereco endereco){
        return enderecoRepository.save(endereco);
    }
}
