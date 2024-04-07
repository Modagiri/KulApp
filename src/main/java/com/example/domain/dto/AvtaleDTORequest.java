package com.example.domain.dto;

public class AvtaleDTORequest {
    private String navn;
    private int fodselsnummer;
    private String adresse;
    private String epost;
    private int telefonnummer;

    public AvtaleDTORequest(String navn, int fodselsnummer, String adresse, String epost, int telefonnummer) {
        this.navn = navn;
        this.fodselsnummer = fodselsnummer;
        this.adresse = adresse;
        this.epost = epost;
        this.telefonnummer = telefonnummer;
    }

    public AvtaleDTORequest() {
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getFodselsnummer() {
        return fodselsnummer;
    }

    public void setFodselsnummer(int fodselsnummer) {
        this.fodselsnummer = fodselsnummer;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public int getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(int telefonnummer) {
        this.telefonnummer = telefonnummer;
    }
}
