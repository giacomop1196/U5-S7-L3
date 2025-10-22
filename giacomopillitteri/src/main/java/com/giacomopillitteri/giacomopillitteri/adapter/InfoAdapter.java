package com.giacomopillitteri.giacomopillitteri.adapter;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class InfoAdapter implements DataSource {
    private final Info info;

    public InfoAdapter(Info info) {
        this.info = info;
    }

    @Override
    public String getNomeCompleto() {
        return info.getNome() + " " + info.getCognome();
    }

    @Override
    public int getEta() {
        if (info.getDataDiNascita() == null) return 0;

        // Calcolo dell'età
        LocalDate dataNascita = info.getDataDiNascita().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        return Period.between(dataNascita, LocalDate.now()).getYears();
    }
}
