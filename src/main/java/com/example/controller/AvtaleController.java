package com.example.controller;

import com.example.domain.dto.AvtaleDTORequest;
import com.example.domain.dto.AvtaleDTOResponse;
import com.example.service.AvtaleService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

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
    public AvtaleDTOResponse opprettAvtaleForNyKunde(AvtaleDTORequest avtaleDTORequest) {
        return avtaleService.opprettAvtaleForNyKunde(avtaleDTORequest);
    }

    @GET
    @Path("/kunde/{id}")
    public List<AvtaleDTOResponse> hentAlleAvtalerForKunde(int id) {
        return avtaleService.hentalleAvtalerForKunde(id);
    }

    @POST
    @Path("/kunde")
    public AvtaleDTOResponse opprettNyAvtaleForEksisterendeKunde(AvtaleDTORequest avtaleDTORequest) {
        return avtaleService.opprettAvtaleForEksisterendeKunde(avtaleDTORequest.getKundenummer());
    }

    @DELETE
    @Path("/{id}")
    public AvtaleDTOResponse slettAvtale(int id) {
        return avtaleService.avsluttAvtale(id);
    }
}
