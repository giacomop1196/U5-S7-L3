package com.giacomopillitteri.giacomopillitteri.chain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Maggiore extends Ufficiale {
    public Maggiore() { super("Maggiore", 3000); }
    @Autowired public void setResponsabile(Colonnello responsabile) { super.setResponsabile(responsabile); }
    @Override public void eseguiFunzioneSpecifica() {}
}