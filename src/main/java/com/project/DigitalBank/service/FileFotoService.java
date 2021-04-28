package com.project.DigitalBank.service;

import com.project.DigitalBank.domain.Foto;
import com.project.DigitalBank.repository.ClienteRepository;
import com.project.DigitalBank.repository.EnderecoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileFotoService {

    ClienteRepository clienteRepository;
    String Varendereco;
    private String raiz = "C:\\Users\\loren\\Pictures";
    private String diretorioFotos = "teste";

    public FileFotoService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Foto saveFile(MultipartFile foto){
        Foto ft = new Foto(
               foto.getOriginalFilename(),
               foto.getSize());
        this.save(this.diretorioFotos, foto);
        return ft;


    }

    private void save(String diretorio,MultipartFile arquivo){
        Path diretorioPath = Paths.get(this.raiz, diretorio);
        Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());
        try {
            Files.createDirectories(diretorioPath);
            arquivo.transferTo(arquivoPath.toFile());
        }
        catch (IOException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Problema no Arquivo");
        }
    }

    //Verificar se o cadastro do cliente e endereço deu certo
    public  String verificaCadastro(Long id){
        // cliente
       if(clienteRepository.findById(id) != null && !clienteRepository.findById(id).isEmpty())
       {
           Varendereco = "Encontrado";
           return  "Encontrado";
       } else {
           Varendereco="Não encontrado";
           return "Não encontrado";}
    }
    // endereco

}
