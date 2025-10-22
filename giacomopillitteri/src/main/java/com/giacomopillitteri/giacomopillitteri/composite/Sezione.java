package com.giacomopillitteri.giacomopillitteri.composite;

import java.util.ArrayList;
import java.util.List;

public class Sezione implements BookComponent {
    private final String titolo;
    private final List<BookComponent> componenti = new ArrayList<>();

    public Sezione(String titolo) {
        this.titolo = titolo;
    }

    public void add(BookComponent componente) {
        componenti.add(componente);
    }

    @Override
    public int getNumeroPagine() {
        // La somma delle pagine dei sottoelementi
        return componenti.stream().mapToInt(BookComponent::getNumeroPagine).sum();
    }

    @Override
    public void stampa() {
        System.out.println("\n== Sezione: " + titolo + " (" + getNumeroPagine() + " pagine) ==");
        for (BookComponent componente : componenti) {
            componente.stampa();
        }
    }
}