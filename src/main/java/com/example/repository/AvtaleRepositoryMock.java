package com.example.repository;

import com.example.db.GargantuanDBMock;
import com.example.domain.Avtale;
import com.example.domain.Avtalestatus;
import com.example.util.AvtalenummerGenerator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class AvtaleRepositoryMock {
    private AvtalenummerGenerator avtalenummerGenerator;
    private GargantuanDBMock gargantuanDBMock;

    @Inject
    public AvtaleRepositoryMock(AvtalenummerGenerator avtalenummerGenerator, GargantuanDBMock gargantuanDBMock) {
        this.avtalenummerGenerator = avtalenummerGenerator;
        this.gargantuanDBMock = gargantuanDBMock;
    }

    public int opprettAvtale(Avtale avtale) {
       return gargantuanDBMock
               .leggTilNyAvtale(avtale.getKundenummer(), avtale);
    }

    public String oppdaterAvtalestatus(int avtalenummer, Avtalestatus avtalestatus) {
        return gargantuanDBMock.oppdaterAvtalestatus(avtalenummer, avtalestatus);
    }

    public List<Avtale> hentAlleAvtalerForKundenummer(int kundenummer) {
        return gargantuanDBMock.getAvtalerForKunde(kundenummer);
    }

    public Avtale avsluttAvtale(int avtalenummer) {
        return gargantuanDBMock.slettAvtale(avtalenummer);
    }
}
