package com.project.DigitalBank.service;

import com.project.DigitalBank.domain.*;
import com.project.DigitalBank.repository.ClienteRepository;
import com.project.DigitalBank.repository.EnderecoRepository;
import com.project.DigitalBank.repository.PropostaRepositorty;
import com.project.DigitalBank.service.email.Mailer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class PropostaService {

    private ContaService contaService ;
    private PropostaService propostaService;
    private PropostaRepositorty propostaRepositorty;
    private ClienteRepository clienteRepository;
    private EnderecoRepository enderecoRepository;
    private Mailer emailService;

    public PropostaService(ContaService contaService,
                           PropostaRepositorty propostaRepositorty,
                           ClienteRepository clienteRepository,
                           EnderecoRepository enderecoRepository,
                           Mailer emailService) {
        this.contaService = contaService;
        this.propostaRepositorty = propostaRepositorty;
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.emailService = emailService;
    }

    public List<Proposta> findAll(){
        return propostaRepositorty.findAll();
    }
    public Proposta findById(Long id){
   ;
        return propostaRepositorty.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Proposta não encontrado"));
    }


    public Proposta save(Proposta proposta){
        Cliente cliente = clienteRepository.findById(proposta.getCliente().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe Cliente"));

        Endereco endereco = enderecoRepository.findById(proposta.getEndereco().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe Endereço cadastrado"));


        proposta.setCliente(cliente);
        proposta.setEndereco(endereco);
        envioEmail(proposta);

        return  propostaRepositorty.save(proposta);
    }

    public  void  delete(Long id){
        propostaRepositorty.deleteById(id);
    }
    public Proposta editAceite(Long id){
        Proposta proposta = propostaRepositorty.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Proposta não encontrada"));

        contaService.createConta();
        proposta.setAceite(true);
         return save(proposta);
    }



    public  void envioEmail(Proposta proposta){
        String destinatario = proposta.getCliente().getEmail();
        String body= proposta.getCliente().toString() +  "   " + proposta.getEndereco().toString();
        Email email = new Email("fernandescunhalorena3@gmail.com",
                destinatario,
                "Criação Conta",
                body);
        emailService.enviar(email);
    }


}
