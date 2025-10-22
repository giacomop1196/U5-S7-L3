package com.giacomopillitteri.giacomopillitteri.chain;

public abstract class Ufficiale {
    protected Ufficiale responsabile;
    protected final int stipendio;
    protected final String grado;

    public Ufficiale(String grado, int stipendio) {
        this.grado = grado;
        this.stipendio = stipendio;
    }

    public void setResponsabile(Ufficiale responsabile) {
        this.responsabile = responsabile;
    }

    public void gestisciRichiestaStipendio(int importoRichiesto) {
        if (this.stipendio >= importoRichiesto) {
            System.out.println("  " + grado + " (Stipendio: " + stipendio + "€) - OK. Questo ufficiale ha lo stipendio richiesto.");
        } else if (responsabile != null) {
            System.out.println("  " + grado + " (Stipendio: " + stipendio + "€) - NON OK. Passo al: " + responsabile.grado);
            responsabile.gestisciRichiestaStipendio(importoRichiesto);
        } else {
            System.out.println("  Richiesta (" + importoRichiesto + "€) non gestita. Nessun ufficiale con stipendio sufficiente.");
        }
    }

    public abstract void eseguiFunzioneSpecifica(); // Funzione diversa per ogni ufficiale
}