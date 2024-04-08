package com.example.util;


import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KundenummerGenerator {
    private int kundenummer = 0;

    public synchronized int generateKundenummer() {
        return ++kundenummer;
    }
}
