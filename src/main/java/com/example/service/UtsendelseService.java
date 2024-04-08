package com.example.service;

import com.example.domain.Avtalestatus;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UtsendelseService {

    public Avtalestatus sendAvtale(int kunde, int avtale) {
        if(avtale < 1 || kunde < 1) {
            return Avtalestatus.UTSENDELSE_FEILET;
        }

        return Avtalestatus.SENDT;
    }
}
