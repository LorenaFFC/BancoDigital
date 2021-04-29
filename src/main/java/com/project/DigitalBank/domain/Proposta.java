package com.project.DigitalBank.domain;

import javax.persistence.*;

@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @OneToOne
    @JoinColumn(name="Fk_Cliente",  referencedColumnName ="id", nullable = false, unique = true)
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name="Fk_Endereco",  referencedColumnName ="idEnd", nullable = false, unique = true)
    private Endereco endereco;
    private Boolean aceite;

    public Proposta() {
    }

    public Proposta(Long id, Cliente cliente, Endereco endereco, Boolean aceite) {
        this.id = id;
        this.cliente = cliente;
        this.endereco = endereco;
        this.aceite = aceite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Boolean getAceite() {
        return aceite;
    }

    public void setAceite(Boolean aceite) {
        this.aceite = aceite;
    }

    @Override
    public String toString() {
        return "Proposta{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", endereco=" + endereco +
                ", aceite=" + aceite +
                '}';
    }
}
