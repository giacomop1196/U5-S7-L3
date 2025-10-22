package com.giacomopillitteri.giacomopillitteri.composite;

public class Pagina implements BookComponent {
    private final String contenuto;

    public Pagina(String contenuto) {
        this.contenuto = contenuto;
    }

    @Override
    public int getNumeroPagine() {
        return 1; // Un Leaf ha 1 pagina
    }

    @Override
    public void stampa() {
        System.out.println("  -> Pagina: " + contenuto.substring(0, Math.min(contenuto.length(), 25)) + "...");
    }
}