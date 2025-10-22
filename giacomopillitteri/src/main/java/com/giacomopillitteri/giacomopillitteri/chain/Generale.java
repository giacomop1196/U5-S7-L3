package com.giacomopillitteri.giacomopillitteri.chain;

import org.springframework.stereotype.Component;

@Component
public class Generale extends Ufficiale {
    public Generale() {
        super("Generale", 5000);
        // Non ha un setResponsabile con @Autowired perché la catena finisce qui.
    }
    @Override public void eseguiFunzioneSpecifica() {}
}