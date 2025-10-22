package com.giacomopillitteri.giacomopillitteri.adapter;

public class UserData {
    private String nomeCompleto;
    private int eta;

    public void getData(DataSource ds) {
        this.nomeCompleto = ds.getNomeCompleto();
        this.eta = ds.getEta();
    }

    public void stampaDati() {
        System.out.println("  Dati utente caricati:");
        System.out.println("  - Nome Completo: " + nomeCompleto);
        System.out.println("  - Età: " + eta + " anni");
    }
}
