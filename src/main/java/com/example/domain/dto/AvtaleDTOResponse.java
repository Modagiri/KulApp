package com.example.domain.dto;

public class AvtaleDTOResponse {
    private int avtalenummer;
    private String avtalestatus;

    public AvtaleDTOResponse(int avtalenummer, String avtalestatus) {
        this.avtalenummer = avtalenummer;
        this.avtalestatus = avtalestatus;
    }

    public int getAvtalenummer() {
        return avtalenummer;
    }

    public String getAvtalestatus() {
        return avtalestatus;
    }
}
