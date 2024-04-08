package com.example.service;

import com.example.domain.Avtale;
import com.example.domain.Avtalestatus;
import com.example.domain.dto.AvtaleDTORequest;
import com.example.domain.dto.AvtaleDTOResponse;
import com.example.repository.AvtaleRepositoryMock;
import com.example.util.AvtalenummerGenerator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class AvtaleService {

    private KundeService kundeService;
    private AvtalenummerGenerator avtalenummerGenerator;
    private AvtaleRepositoryMock avtaleRepositoryMock;
    private UtsendelseService utsendelseService;

    @Inject
    public AvtaleService(KundeService kundeService, AvtalenummerGenerator avtalenummerGenerator, AvtaleRepositoryMock avtaleRepositoryMock, UtsendelseService utsendelseService) {
        this.kundeService = kundeService;
        this.avtalenummerGenerator = avtalenummerGenerator;
        this.avtaleRepositoryMock = avtaleRepositoryMock;
        this.utsendelseService = utsendelseService;
    }

    public List<AvtaleDTOResponse> hentalleAvtalerForKunde(int kundenummer) {
        return avtaleRepositoryMock.hentAlleAvtalerForKundenummer(kundenummer)
                .stream()
                .filter(avtale -> !avtale.getAvtalestatus().equals(Avtalestatus.AVSLUTTET))
                .map(a -> new AvtaleDTOResponse(a.getAvtalenummer(), a.getAvtalestatus().name(), a.getKundenummer())).toList();
    }

    @Transactional
    public AvtaleDTOResponse opprettAvtaleForNyKunde(AvtaleDTORequest avtaleDTORequest) {
        int kundenummer = kundeService.opprettNyKunde(avtaleDTORequest);
        int avtalenummer = opprettAvtale(kundenummer);

        Avtalestatus avtalestatus = utsendelseService.sendAvtale(kundenummer, avtalenummer);
        oppdaterAvtalestatus(avtalenummer, avtalestatus);

        return new AvtaleDTOResponse(avtalenummer, avtalestatus.name(), kundenummer);
    }

    @Transactional
    public AvtaleDTOResponse opprettAvtaleForEksisterendeKunde(int kundenummer) {
        int avtalenummer = opprettAvtale(kundenummer);

        Avtalestatus avtalestatus = utsendelseService.sendAvtale(kundenummer, avtalenummer);
        oppdaterAvtalestatus(avtalenummer, avtalestatus);

        return new AvtaleDTOResponse(avtalenummer, avtalestatus.name(), kundenummer);
    }

    private int opprettAvtale(int kundenummer) {
        return avtaleRepositoryMock.opprettAvtale(new Avtale(kundenummer, avtalenummerGenerator.generateAvtalenummer(), Avtalestatus.SIGNERT));
    }

    private String oppdaterAvtalestatus(int avtalenummer, Avtalestatus avtalestatus) {

        if(avtalenummer > 3) {
            throw new RuntimeException("Ikke plass til flere avtaler i dagens system");
        }

        return avtaleRepositoryMock.oppdaterAvtalestatus(avtalenummer, avtalestatus);
    }

    @Transactional
    public AvtaleDTOResponse avsluttAvtale(int avtalenummer) {
       Avtale slettetAvtale = avtaleRepositoryMock.avsluttAvtale(avtalenummer);

       return new AvtaleDTOResponse(slettetAvtale.getAvtalenummer(), slettetAvtale.getAvtalestatus().name(), slettetAvtale.getKundenummer());
    }
}
