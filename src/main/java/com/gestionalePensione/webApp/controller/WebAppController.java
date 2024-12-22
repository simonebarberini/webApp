package com.gestionalePensione.webApp.controller;

import com.gestionalePensione.webApp.client.PrenotazioniClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class WebAppController {

    @Autowired
    PrenotazioniClient prenotazioniClient;

    @GetMapping("/")
    public String homeView(){
        return "home";
    }

    @GetMapping("/nuovaPrenotazioneView")
    public String nuovaPrenotazioneView(){
        return "nuovaPrenotazione";
    }

    @GetMapping("/listaPrenotazioniView")
    public String listaPrenotazioniView(){
        return "listaPrenotazioni";
    }

    @PostMapping("/submitPrenotazione")
    public String submitPrenotazione(@RequestParam String nomeCliente,
                                     @RequestParam int numeroCani,
                                     @RequestParam String dataInizio,
                                     @RequestParam String dataFine,
                                     Model model ){
        prenotazioniClient.addPrenotazione(nomeCliente, numeroCani, dataInizio, dataFine);

        model.addAttribute("message", "Prenotazione aggiunta con successo!");
        return "prenotazioneResult";

    }

//    @GetMapping("/getListaPrenotazioni")
//    public String
}
