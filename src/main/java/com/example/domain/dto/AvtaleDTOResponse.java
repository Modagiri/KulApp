package com.example.domain.dto;

public class AvtaleDTOResponse {
    private int kundenummer;
    private int avtalenummer;
    private String avtalestatus;

    public AvtaleDTOResponse(int avtalenummer, String avtalestatus, int kundenummer) {
        this.avtalenummer = avtalenummer;
        this.avtalestatus = avtalestatus;
        this.kundenummer = kundenummer;
    }

    public int getAvtalenummer() {
        return avtalenummer;
    }

    public String getAvtalestatus() {
        return avtalestatus;
    }

    public int getKundenummer() {
        return this.kundenummer;
    }

    public void setKundenummer(int kundenummer) {
        this.kundenummer = kundenummer;
    }
}
