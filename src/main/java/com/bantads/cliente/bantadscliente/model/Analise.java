package com.bantads.cliente.bantadscliente.model;

import java.io.Serializable;
import java.security.Timestamp;

public class Analise implements Serializable {
    private int id;
    private String motivo;
    private boolean aprovacao;
    private Timestamp dataHora;
    private Cliente cliente;
    private int idExternoGerente;

    public Analise() {
        super();
    }

    public Analise(int id, String motivo, boolean aprovacao, Timestamp dataHora, Cliente cliente,
            int idExternoGerente) {
        super();
        this.id = id;
        this.motivo = motivo;
        this.aprovacao = aprovacao;
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.idExternoGerente = idExternoGerente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdExternoGerente() {
        return idExternoGerente;
    }

    public void setIdExternoGerente(int idExternoGerente) {
        this.idExternoGerente = idExternoGerente;
    }

}
