package com.gestionalePensione.webApp.controller;

import com.gestionalePensione.webApp.client.PrenotazioniClient;
import com.gestionalePensione.webApp.model.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

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

    @GetMapping("/verificaDisponibilitaView")
    public String verificaDisponibilitaView(){
        return "verificaDisponibilita";
    }

    @PostMapping("/submitPrenotazione")
    public String submitPrenotazione(@RequestParam String nomeCliente,
                                     @RequestParam int numeroCani,
                                     @RequestParam String dataInizio,
                                     @RequestParam String dataFine,
                                     Model model ){
        prenotazioniClient.addPrenotazione(nomeCliente, numeroCani, dataInizio, dataFine);

        model.addAttribute("message", "Prenotazione aggiunta con successo!");
        return "operationResult";

    }

    @GetMapping("/listaPrenotazioniView")
    public String getListaPrenotazioni(Model model){
        List<Prenotazione> listaPrenotazioni = prenotazioniClient.getAllPrenotazioni();
        model.addAttribute("prenotazioni", listaPrenotazioni);
        return "listaPrenotazioni";
    }

    @PostMapping("/elimina")
    public String eliminaPrenotazione(@RequestParam String id){
        prenotazioniClient.eliminaPrenotazione(id);
        return "redirect:/listaPrenotazioniView";
    }


    @PostMapping("/verificaDisponibilita")
    public String verificaDisponibilita(@RequestParam String dataInizio, @RequestParam String dataFine, Model model){
        Integer disponibilita = prenotazioniClient.getDisponibilita(dataInizio, dataFine);
        model.addAttribute("disponibilita", disponibilita);
        model.addAttribute("dataInizio", dataInizio);
        model.addAttribute("dataFine", dataFine);
        return "verificaDisponibilita";
    }


}
