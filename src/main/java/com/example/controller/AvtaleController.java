package com.example.controller;

import com.example.domain.dto.AvtaleDTORequest;
import com.example.domain.dto.AvtaleDTOResponse;
import com.example.service.AvtaleService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/avtale")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AvtaleController {
    private AvtaleService avtaleService;

    @Inject
    public AvtaleController(AvtaleService avtaleService) {
        this.avtaleService = avtaleService;
    }

    @POST
    public AvtaleDTOResponse opprettAvtale(AvtaleDTORequest avtaleDTORequest) {
        return avtaleService.opprettAvtale(avtaleDTORequest);
    }

}
