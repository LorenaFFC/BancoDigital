package com.project.DigitalBank.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.DigitalBank.validationCustom.CNH.CnhConstraint;
import com.project.DigitalBank.validationCustom.DataNascimento.DtNascConstraint;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long Id;

    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String Nome;

    @NotEmpty(message = "{campo.sobrenome.obrigatorio}")
    private String Sobrenome;

    @NotEmpty(message = "{campo.email.obrigatorio}")
    @Column(unique=true)
    @Email(message = "{campo.formatemail.invalido}")
    private String Email;

    @CnhConstraint
    private String Cnh;

    @NotEmpty(message = "{campo.CPF.obrigatorio}")
    @CPF(message = "{campo.CPF.invalido}")
    private String CPF;

    @DtNascConstraint
    private LocalDate DtNasc;

    public Cliente() {
    }

    public Cliente(Long id, @NotEmpty(message = "{campo.nome.obrigatorio}") String nome, @NotEmpty(message = "{campo.sobrenome.obrigatorio}") String sobrenome, @NotEmpty(message = "{campo.email.obrigatorio}") @javax.validation.constraints.Email(message = "{campo.formatemail.invalido}") String email, @NotEmpty(message = "{campo.cnh.obrigatorio}") String cnh, @NotEmpty(message = "{campo.CPF.obrigatorio}") @org.hibernate.validator.constraints.br.CPF(message = "{campo.CPF.invalido}") String CPF, LocalDate dtNasc) {
        Id = id;
        Nome = nome;
        Sobrenome = sobrenome;
        Email = email;
        Cnh = cnh;
        this.CPF = CPF;
        DtNasc = dtNasc;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCnh() {
        return Cnh;
    }

    public void setCnh(String cnh) {
        Cnh = cnh;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public LocalDate getDtNasc() {
        return DtNasc;
    }

    public void setDtNasc(LocalDate dtNasc) {
        DtNasc = dtNasc;
    }

    @Override
    public String toString() {
        return "Cliente{" +

                " Nome='" + Nome + '\'' +
                ", Sobrenome='" + Sobrenome + '\'' +
                ", Email='" + Email + '\'' +
                ", Cnh='" + Cnh + '\'' +
                ", CPF='" + CPF + '\'' +
                ", DtNasc=" + DtNasc +
                '}';
    }
}


