package com.giacomopillitteri.giacomopillitteri.composite;

import java.util.ArrayList;
import java.util.List;

public class Libro implements BookComponent {
    private final String titolo;
    private final List<String> autori;
    private final double prezzo;
    private final List<BookComponent> componenti = new ArrayList<>();

    public Libro(String titolo, List<String> autori, double prezzo) {
        this.titolo = titolo;
        this.autori = autori;
        this.prezzo = prezzo;
    }

    public void add(BookComponent componente) {
        componenti.add(componente);
    }

    @Override
    public int getNumeroPagine() {
        // Chiede il totale delle pagine a tutti i suoi componenti
        return componenti.stream().mapToInt(BookComponent::getNumeroPagine).sum();
    }

    @Override
    public void stampa() {
        System.out.println("\n#### LIBRO: " + titolo);
        System.out.println("#### Autori: " + String.join(", ", autori) + " | Prezzo: " + prezzo + "€");

        for (BookComponent componente : componenti) {
            componente.stampa();
        }
    }
}
