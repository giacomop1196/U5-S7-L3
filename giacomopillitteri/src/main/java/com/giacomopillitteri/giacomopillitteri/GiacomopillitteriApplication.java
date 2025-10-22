package com.giacomopillitteri.giacomopillitteri;

import com.giacomopillitteri.giacomopillitteri.adapter.DataSource;
import com.giacomopillitteri.giacomopillitteri.adapter.Info;
import com.giacomopillitteri.giacomopillitteri.adapter.InfoAdapter;
import com.giacomopillitteri.giacomopillitteri.adapter.UserData;
import com.giacomopillitteri.giacomopillitteri.chain.Tenente;
import com.giacomopillitteri.giacomopillitteri.composite.Libro;
import com.giacomopillitteri.giacomopillitteri.composite.Pagina;
import com.giacomopillitteri.giacomopillitteri.composite.Sezione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class GiacomopillitteriApplication {
    // Esercizio 3
    @Autowired
    private Tenente tenente;

    public static void main(String[] args) {
        SpringApplication.run(GiacomopillitteriApplication.class, args);
    }

    public void run(String... args) throws Exception {
        System.out.println("=========================================");
        System.out.println("  ESERCIZI DESIGN PATTERNS CON SPRING BOOT");
        System.out.println("=========================================");

        demoAdapter();
        demoComposite();
        demoChainOfResponsibility();
    }

    // Metodo Demo Esercizio 1 (Adapter)
    private void demoAdapter() {
        System.out.println("\n--- Esercizio #1: PATTERN ADAPTER ---");

        // 1. Oggetto da adattare (Info)
        Date dataNascita = Date.from(
                LocalDate.of(1990, 10, 9)
                        .atStartOfDay(ZoneId.systemDefault())
                        .toInstant()
        );
        Info infoOriginale = new Info("Giacomo", "Pillitteri", dataNascita);

        // 2. Creiamo l'Adapter che avvolge Info per esporre l'interfaccia DataSource
        DataSource adapter = new InfoAdapter(infoOriginale);

        // 3. La classe cliente (UserData) usa l'Adapter
        UserData utente = new UserData();
        utente.getData(adapter);
        utente.stampaDati();
        System.out.println("-------------------------------------");
    }

    // Metodo Demo Esercizio 2 (Composite)
    private void demoComposite() {
        System.out.println("\n--- Esercizio #2: PATTERN COMPOSITE ---");

        // Crea i Leaf
        Pagina p1 = new Pagina("Introduzione...");
        Pagina p2 = new Pagina("La sintassi Java...");

        // Crea il Composite Sezione
        Sezione sezioneJava = new Sezione("Programmazione Java");
        sezioneJava.add(p2);

        // Crea un altro Composite Sezione (che contiene il Leaf e il Composite)
        Sezione sezionePrincipale = new Sezione("Fondamentali");
        sezionePrincipale.add(p1);
        sezionePrincipale.add(sezioneJava);

        // Crea il Composite Libro (Root)
        List<String> autori = List.of("Giacomo Pillitteri");
        Libro libro = new Libro("Web Dev in 5 Giorni", autori, 29.99);
        libro.add(sezionePrincipale);
        libro.add(new Pagina("Conclusione finale..."));

        // Test delle operazioni
        System.out.println("Pagine Totali del Libro: " + libro.getNumeroPagine());
        libro.stampa();
        System.out.println("-------------------------------------");
    }

    // Metodo Demo Esercizio 3 (Chain of Responsibility)
    private void demoChainOfResponsibility() {
        System.out.println("\n--- Esercizio #3: CHAIN OF RESPONSIBILITY ---");

        System.out.println("\nRichiesta 1: Stipendio di 2500€ (Gestito dal Maggiore)");
        tenente.gestisciRichiestaStipendio(2500);

        System.out.println("\nRichiesta 2: Stipendio di 5500€ (Non gestito)");
        tenente.gestisciRichiestaStipendio(5500);

        System.out.println("-------------------------------------");
    }
}
