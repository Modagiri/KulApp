package com.example.repository;

import com.example.db.GargantuanDBMock;
import com.example.domain.Avtale;
import com.example.domain.Kunde;
import com.example.domain.dto.AvtaleDTORequest;
import com.example.util.KundenummerGenerator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class KundeRepositoryMock {

    private GargantuanDBMock gargantuanDBMock;

    @Inject
    public KundeRepositoryMock(GargantuanDBMock gargantuanDBMock) {
        this.gargantuanDBMock = gargantuanDBMock;
    }

    @Transactional
    public int opprettKunde(AvtaleDTORequest avtaleDTORequest, int kundenummner) {
        Kunde nyKunde = new Kunde(avtaleDTORequest.getNavn(),
                avtaleDTORequest.getAdresse(),
                avtaleDTORequest.getFodselsnummer(),
                avtaleDTORequest.getEpost(),
                avtaleDTORequest.getTelefonnummer(),
                kundenummner
        );

        nyKunde = gargantuanDBMock.leggTilNyKunde(nyKunde);

        return nyKunde.getKundenummer();
    }
}
