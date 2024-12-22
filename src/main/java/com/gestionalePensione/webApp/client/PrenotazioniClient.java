package com.gestionalePensione.webApp.client;

import com.gestionalePensione.webApp.model.Prenotazione;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "gestionalegateway")
public interface PrenotazioniClient {

    @GetMapping("/gestionalepensione/prenotazioni")
    List<Prenotazione> getAllPrenotazioni();

    @PostMapping("/gestionalepensione/nuovaPrenotazione")
    void addPrenotazione(@RequestParam("nomeCliente") String nomeCliente,
                         @RequestParam("numeroCani") int numeroCani,
                         @RequestParam("dataInizio") String dataInizio, // Cambiato a String
                         @RequestParam("dataFine") String dataFine);   // Cambiato a String

    @GetMapping("/gestionalepensione/verificaDisponibilita")
    Integer getDisponibilita(@RequestParam("dataInizio") String dataInizio, // Cambiato a String
                             @RequestParam("dataFine") String dataFine);   // Cambiato a String
}
