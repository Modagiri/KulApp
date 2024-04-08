package com.example.domain;

public class Avtale {
    private int avtalenummer;
    private int kundenummer;
    private Avtalestatus avtalestatus;

    public Avtale(int kundenummer, int avtalenummer, Avtalestatus avtalestatus) {
        this.kundenummer = kundenummer;
        this.avtalenummer = avtalenummer;
        this.avtalestatus = avtalestatus;
    }

    public Avtale() {
    }

    public int getAvtalenummer() {
        return avtalenummer;
    }

    public void setAvtalenummer(int avtalenummer) {
        this.avtalenummer = avtalenummer;
    }

    public Avtalestatus getAvtalestatus() {
        return avtalestatus;
    }

    public void setAvtalestatus(Avtalestatus avtalestatus) {
        this.avtalestatus = avtalestatus;
    }

    public int getKundenummer() {
        return kundenummer;
    }

    public void setKundenummer(int kundenummer) {
        this.kundenummer = kundenummer;
    }
}
