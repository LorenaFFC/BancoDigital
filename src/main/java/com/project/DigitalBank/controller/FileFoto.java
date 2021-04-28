package com.project.DigitalBank.controller;

import com.project.DigitalBank.service.FileFotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("upload")
public class FileFoto {

    private FileFotoService fileFotoService;

    public FileFoto(FileFotoService fileFotoService) {
        this.fileFotoService = fileFotoService;
    }

    @PostMapping
    private ResponseEntity<Object> fileUpload(@RequestBody MultipartFile file, Long id){
        if(fileFotoService.verificaCadastro(id)=="Encontrado") {
            return new ResponseEntity<>(fileFotoService.saveFile(file), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
