package com.example.service;


import com.example.domain.Avtale;
import com.example.domain.Kunde;
import com.example.domain.dto.AvtaleDTORequest;
import com.example.domain.dto.AvtaleDTOResponse;
import com.example.repository.KundeRepositoryMock;
import com.example.util.KundenummerGenerator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class KundeService {

    private KundenummerGenerator kundenummerGenerator;
    private KundeRepositoryMock kundeRepositoryMock;

    @Inject
    public KundeService(KundeRepositoryMock kundeRepositoryMock, KundenummerGenerator kundenummerGenerator) {
        this.kundeRepositoryMock = kundeRepositoryMock;
        this.kundenummerGenerator = kundenummerGenerator;
    }

    public int opprettNyKunde(AvtaleDTORequest avtaleDTORequest) {
        return kundeRepositoryMock.opprettKunde(avtaleDTORequest, kundenummerGenerator.generateKundenummer());
    }
}
