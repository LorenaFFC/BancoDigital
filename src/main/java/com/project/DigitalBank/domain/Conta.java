package com.project.DigitalBank.domain;

import javax.persistence.*;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Agencia;
    private String Conta;
    private String Banco;
    //@OneToOne
   // @JoinColumn(name="fK_Proposta",  referencedColumnName ="id", nullable = false, unique = true)
   // private Proposta proposta;
    private double Saldo = 0.00;

    public Conta() {
    }

    public Conta(Long id, String agencia, String conta, String banco, double saldo) {
        Id = id;
        Agencia = agencia;
        Conta = conta;
        Banco = banco;
        Saldo = saldo;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getAgencia() {
        return Agencia;
    }

    public void setAgencia(String agencia) {
        Agencia = agencia;
    }

    public String getConta() {
        return Conta;
    }

    public void setConta(String conta) {
        Conta = conta;
    }

    public String getBanco() {
        return Banco;
    }

    public void setBanco(String banco) {
        Banco = banco;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "Id=" + Id +
                ", Agencia='" + Agencia + '\'' +
                ", Conta='" + Conta + '\'' +
                ", Banco='" + Banco + '\'' +
                ", Saldo=" + Saldo +
                '}';
    }
}
