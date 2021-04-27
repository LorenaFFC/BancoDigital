package com.project.DigitalBank.domain;



public class Foto {
    private String Nome;
    private Long Size;


    public Foto(String nome, Long size) {
        Nome = nome;
        Size = size;

    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Long getSize() {
        return Size;
    }

    public void setSize(Long size) {
        Size = size;
    }


}
