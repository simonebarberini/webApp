package com.gestionalePensione.webApp.client;

import com.gestionalePensione.webApp.model.Prenotazione;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "gestionalepensione")
public interface PrenotazioniClient {

    @GetMapping("/prenotazioni")
    List<Prenotazione> getAllPrenotazioni();

    @PostMapping("/nuovaPrenotazione")
    void addPrenotazione(@RequestParam("nomeCliente") String nomeCliente,
                         @RequestParam("numeroCani") int numeroCani,
                         @RequestParam("dataInizio") String dataInizio,
                         @RequestParam("dataFine") String dataFine);


    @GetMapping("/verificaDisponibilita")
    Integer getDisponibilita(@RequestParam("dataInizio") String dataInizio,
                             @RequestParam("dataFine") String dataFine);

    @DeleteMapping("/eliminaPrenotazione")
     void eliminaPrenotazione(@RequestParam() String id);

}
