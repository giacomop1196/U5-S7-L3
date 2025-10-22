package com.giacomopillitteri.giacomopillitteri.chain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Colonnello extends Ufficiale {
    public Colonnello() { super("Colonnello", 4000); }
    @Autowired public void setResponsabile(Generale responsabile) { super.setResponsabile(responsabile); }
    @Override public void eseguiFunzioneSpecifica() {}
}