package com.example.db;

import com.example.domain.Avtale;
import com.example.domain.Avtalestatus;
import com.example.domain.Kunde;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class GargantuanDBMock {
    private Map<Integer, Kunde> kundebase = new HashMap<>();
    private Map<Integer, Avtale> avtalebase = new HashMap<>();
    private Map<Kunde, List<Avtale>> kundeAvtaleBase = new HashMap<>();


    public Kunde getKunde(int kundeId) {
        return kundebase.get(kundeId);
    }

    public List<Avtale> getAvtalerForKunde(int kundeId) {
        Kunde kunde = getKunde(kundeId);
        return kundeAvtaleBase.get(kunde);
    }

    public Avtale getAvtale(int avtaleId) {
        return avtalebase.get(avtaleId);
    }

    public Kunde leggTilNyKunde(Kunde kunde) {
        kundebase.put(kunde.getKundenummer(), kunde);
        kundeAvtaleBase.put(kunde, new ArrayList<>());

        return kunde;
    }

    public int leggTilNyAvtale(Integer kundenummer, Avtale avtale) {
        Kunde kunde = kundebase.get(kundenummer);
        List<Avtale> kundesAvtaler = kundeAvtaleBase.get(kunde);
        avtalebase.put(avtale.getAvtalenummer(), avtale);
        kundesAvtaler.add(avtale);
        kundeAvtaleBase.put(kunde, kundesAvtaler);

        return avtale.getAvtalenummer();
    }

    public String oppdaterAvtalestatus(int avtalenummer, Avtalestatus avtalestatus) {
        Avtale avtale = getAvtale(avtalenummer);
        avtale.setAvtalestatus(avtalestatus);

        return avtale.getAvtalestatus().name();
    }


    public Avtale slettAvtale(int avtalenummer) {
        Avtale avtale = getAvtale(avtalenummer);
        avtale.setAvtalestatus(Avtalestatus.AVSLUTTET);

        return avtale;
    }
}
