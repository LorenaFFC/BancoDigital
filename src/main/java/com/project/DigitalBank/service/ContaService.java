package com.project.DigitalBank.service;


import com.project.DigitalBank.domain.Conta;
import com.project.DigitalBank.repository.ContaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ContaService {

    private ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;

    }
    public List<Conta> findAll(){

        return  contaRepository.findAll();
    }

    public ResponseEntity<Conta> createConta(){
        Conta conta = gerarConta();
        return new ResponseEntity<>(contaRepository.save(conta), HttpStatus.CREATED);
    }

    private Conta gerarConta(){

        Random random = new Random();
        String Num_Agencia = String.format("%04d", random.nextInt(10000));
        String Num_Conta = String.format("%08d", random.nextInt(100000000));
        String Num_Banco = "654";

        Conta conta = new Conta();
        conta.setAgencia(Num_Agencia);
        conta.setConta(Num_Conta);
        conta.setBanco(Num_Banco);
        conta.setSaldo(0.00);
        return conta;
    }
}
