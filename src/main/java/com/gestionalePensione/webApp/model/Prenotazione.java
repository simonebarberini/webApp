package com.gestionalePensione.webApp.model;

import java.time.LocalDate;

public class Prenotazione {
    private String id;
    private String nomeCliente;
    private int numeroCani;
    private LocalDate dataInizio;
    private LocalDate dataFine;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getNumeroCani() {
        return numeroCani;
    }

    public void setNumeroCani(int numeroCani) {
        this.numeroCani = numeroCani;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }
}
