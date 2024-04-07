package com.example.service;

import com.example.domain.Avtalestatus;
import com.example.domain.dto.AvtaleDTORequest;
import com.example.domain.dto.AvtaleDTOResponse;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AvtaleService {

    public AvtaleDTOResponse opprettAvtale(AvtaleDTORequest avtaleDTORequest) {
        return new AvtaleDTOResponse(100, Avtalestatus.AKTIV.name());
    }
}
