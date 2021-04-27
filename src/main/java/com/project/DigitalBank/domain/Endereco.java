package com.project.DigitalBank.domain;

import com.project.DigitalBank.validationCustom.CEP.CepConstraint;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @CepConstraint
    private String Cep;
    @NotEmpty(message = "O campo rua não deve ser nulo ou vazio")
    private String Rua;
    @NotEmpty(message = "O campo Complemento não deve ser nulo ou vazio")
    private String Complemento;
    @NotEmpty(message = "O campo Cidade não deve ser nulo ou vazio")
    private String Cidade;
    @NotEmpty(message = "O campo Estado não deve ser nulo ou vazio")
    private String Estado;

    public Endereco() {
    }

    public Endereco(Long id, String cep, String rua, String complemento, String cidade, String estado) {
        Id = id;
        Cep = cep;
        Rua = rua;
        Complemento = complemento;
        Cidade = cidade;
        Estado = estado;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}

