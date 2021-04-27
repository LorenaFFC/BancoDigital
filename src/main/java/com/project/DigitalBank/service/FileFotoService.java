package com.project.DigitalBank.service;

import com.project.DigitalBank.domain.Foto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileFotoService {

    private String raiz = "C:\\Users\\loren\\Pictures";
    private String diretorioFotos = "teste";


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
}
