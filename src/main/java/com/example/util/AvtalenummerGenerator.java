package com.example.util;


import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AvtalenummerGenerator {
    private int avtalenummer;

    public synchronized int generateAvtalenummer() {
        return ++avtalenummer;
    }

}
