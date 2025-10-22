package com.giacomopillitteri.giacomopillitteri.adapter;

import java.util.Date;

public class Info {

    private String nome;
    private String cognome;
    private Date dataDiNascita;

    public Info(String nome, String cognome, Date dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public Date getDataDiNascita() { return dataDiNascita; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
}
