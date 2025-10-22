package com.giacomopillitteri.giacomopillitteri.chain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Capitano extends Ufficiale {
    public Capitano() { super("Capitano", 2000); }
    @Autowired public void setResponsabile(Maggiore responsabile) { super.setResponsabile(responsabile); }
    @Override public void eseguiFunzioneSpecifica() {}
}