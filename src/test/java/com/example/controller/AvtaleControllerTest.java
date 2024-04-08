package com.example.controller;

import com.example.domain.Avtalestatus;
import com.example.domain.dto.AvtaleDTORequest;
import com.example.domain.dto.AvtaleDTOResponse;
import com.example.service.AvtaleService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AvtaleControllerTest {

    @Inject
    AvtaleService avtaleService;

    @Test
    @Order(1)
    void opprettelseAvFoersteKundeGirKundenummer1ogAvtalenummer1ogStatuskode200() {
        AvtaleDTORequest avtaleDTORequest = new AvtaleDTORequest("Mo", 170586, "Slottet", "mail@mail.com", 94479202);
        AvtaleDTOResponse forventetRespons = new AvtaleDTOResponse(1, Avtalestatus.SENDT.name(), 1);

        given()
                .contentType("application/json")
                .body(avtaleDTORequest)
                .when().post("/avtale")
                .then()
                .statusCode(200)
                .body("avtalenummer", equalTo(forventetRespons.getAvtalenummer()),
                        "avtalestatus", equalTo(forventetRespons.getAvtalestatus()),
                        "kundenummer", equalTo(forventetRespons.getKundenummer()));
    }

    @Test
    @Order(2)
    void opprettelseAvAndreKundeGirKundenummer2ogAvtalenummer2ogStatuskode200() {
        //public AvtaleDTORequest(String navn, int fodselsnummer, String adresse, String epost, int telefonnummer) {
        AvtaleDTORequest avtaleDTORequest = new AvtaleDTORequest("Mo", 170587, "Holstein", "mailesen@mail.com", 94479203);
        AvtaleDTOResponse forventetRespons = new AvtaleDTOResponse(2, Avtalestatus.SENDT.name(), 2);

        given()
                .contentType("application/json")
                .body(avtaleDTORequest)
                .when().post("/avtale")
                .then()
                .statusCode(200)
                .body("avtalenummer", equalTo(forventetRespons.getAvtalenummer()),
                        "avtalestatus", equalTo(forventetRespons.getAvtalestatus()),
                        "kundenummer", equalTo(forventetRespons.getKundenummer()));
    }

    @Test
    @Order(3)
    void nyAvtaleForKundeNummer1FaarAvtalenummer3ogStatuskode200() {
        AvtaleDTORequest avtaleDTORequest = new AvtaleDTORequest(1);
        AvtaleDTOResponse forventetRespons = new AvtaleDTOResponse(3, Avtalestatus.SENDT.name(), 1);

        given()
                .contentType("application/json")
                .body(avtaleDTORequest)
                .when().post("/avtale/kunde")
                .then()
                .statusCode(200)
                .body("avtalenummer", equalTo(forventetRespons.getAvtalenummer()),
                        "avtalestatus", equalTo(forventetRespons.getAvtalestatus()),
                        "kundenummer", equalTo(forventetRespons.getKundenummer()));
    }

    @Test
    @Order(4)
    void opprettelseAvAvtaleNummer4ResulteterIException() {
        AvtaleDTOResponse forventetRespons = new AvtaleDTOResponse(1, Avtalestatus.AVSLUTTET.name(), 1);
        AvtaleDTORequest avtaleDTORequest = new AvtaleDTORequest(1);

        given()
                .contentType("application/json")
                .body(avtaleDTORequest)
                .when().post("/avtale/kunde")
                .then()
                .statusCode(500);
    }

    @Test
    @Order(5)
    void avsluttingAvAtaleReturnererAvsluttetAvtaleNummerOgStatuskode200() {
        AvtaleDTOResponse forventetRespons = new AvtaleDTOResponse(1, Avtalestatus.AVSLUTTET.name(), 1);

        given()
                .contentType("application/json")
                .when().delete("/avtale/{id}", 1)
                .then()
                .statusCode(200)
                .body("avtalenummer", equalTo(forventetRespons.getAvtalenummer()),
                        "avtalestatus", equalTo(forventetRespons.getAvtalestatus()),
                        "kundenummer", equalTo(forventetRespons.getKundenummer()));
    }

}