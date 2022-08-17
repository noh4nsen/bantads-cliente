package com.bantads.cliente.bantadscliente.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cliente implements Serializable {
    private int id;
    private int idExternoUsuario;
    private String nome;
    private String cpf;
    private Endereco endereco;
    private BigDecimal salario;

    public Cliente() {
        super();
    }

    public Cliente(int id, int idExternoUsuario, String nome, String cpf, Endereco endereco, BigDecimal salario) {
        super();
        this.id = id;
        this.idExternoUsuario = idExternoUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public int getIdExternoUsuario() {
        return idExternoUsuario;
    }

    public void setIdExternoUsuario(int idExternoUsuario) {
        this.idExternoUsuario = idExternoUsuario;
    }

}
