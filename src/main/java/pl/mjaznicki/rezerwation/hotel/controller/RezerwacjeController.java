package pl.mjaznicki.rezerwation.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mjaznicki.rezerwation.hotel.dto.ListaRezerwacjiDTO;
import pl.mjaznicki.rezerwation.hotel.dto.RezerwacjaDTO;
import pl.mjaznicki.rezerwation.hotel.dto.WyszukiwaniePokoiDTO;
import pl.mjaznicki.rezerwation.hotel.model.Klient;
import pl.mjaznicki.rezerwation.hotel.model.Pokoj;
import pl.mjaznicki.rezerwation.hotel.model.Rezerwacje;
import pl.mjaznicki.rezerwation.hotel.service.api.KlientService;
import pl.mjaznicki.rezerwation.hotel.service.api.PokojService;
import pl.mjaznicki.rezerwation.hotel.service.api.RezerwacjaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RezerwacjeController {

    @Autowired
    private PokojService pokojService;

    @Autowired
    private RezerwacjaService rezerwacjaService;

    @Autowired
    private KlientService klientService;


    @PostMapping("/pokojeWolne")
    public List<Pokoj> pobierzWolnePokoje(@RequestBody WyszukiwaniePokoiDTO wyszukiwaniePokoiDTO){
        List<Pokoj> pokojeTemp = pokojService.znajdzWolne(wyszukiwaniePokoiDTO);
        return pokojeTemp;
    }



    @PostMapping("/dokonajRezerwacji")
    public Rezerwacje dokonajRezerwacji(@RequestBody RezerwacjaDTO rezerwacjaDTO){
        Klient klient;
        klient = klientService.zapiszKlienta(rezerwacjaDTO);
        Rezerwacje rezerwacja;
        rezerwacja = rezerwacjaService.zapiszRezerwacje(rezerwacjaDTO,klient);
        return rezerwacja;
    }

    @GetMapping("/pobierzRezerwacje")
    public List<ListaRezerwacjiDTO> pobierzRezerwacje(){
        return rezerwacjaService.znajdzWszystkie();
    }

    @DeleteMapping("/usunRezerwacje/{id}")
    public void usunRezerwacje(@PathVariable(value = "id") Long id){
        rezerwacjaService.usunRezerwacje(id);

    }
    String test;

}
