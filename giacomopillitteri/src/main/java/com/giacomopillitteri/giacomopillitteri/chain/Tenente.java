package com.giacomopillitteri.giacomopillitteri.chain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tenente extends Ufficiale {
    public Tenente() { super("Tenente", 1000); }

    // Spring inietterà Capitano in questo metodo
    @Autowired
    public void setResponsabile(Capitano responsabile) {
        super.setResponsabile(responsabile);
    }

    @Override public void eseguiFunzioneSpecifica() {}
}
