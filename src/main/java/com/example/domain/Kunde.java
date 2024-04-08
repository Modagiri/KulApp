package com.example.domain;

public class Kunde {

    int kundenummer;
    private String navn;
    private int fodselsnummer;
    private String adresse;
    private String epost;
    private int telefonnummer;


    public Kunde(String navn, String adresse, int fodselsnummer, String epost, int telefonnummer, int kundenummer) {
        this.navn = navn;
        this.adresse = adresse;
        this.fodselsnummer = fodselsnummer;
        this.epost = epost;
        this.telefonnummer = telefonnummer;
        this.kundenummer = kundenummer;
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

    public int getKundenummer() {
        return kundenummer;
    }

    public void setKundenummer(int kundenummer) {
        this.kundenummer = kundenummer;
    }
}
