package pl.mjaznicki.rezerwation.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        List<Pokoj> pokojeWszystkie  = pokojService.znajdzPoWielkosci(wyszukiwaniePokoiDTO.getWielkosc());
        List<Pokoj> pokojeTemp = new ArrayList<>();
        for (Pokoj p: pokojeWszystkie) {
            List<Rezerwacje> rezerwacjes = rezerwacjaService.znajdzPoPokojach(p);
            boolean czyZarezerwowany = false;
            for (Rezerwacje r : rezerwacjes) {
                if((r.getDataPrzyjazdu().after(wyszukiwaniePokoiDTO.getDataPoczatku()) && r.getDataPrzyjazdu().before(wyszukiwaniePokoiDTO.getDataKonca())) ||
                        (r.getDataOdjazdu().after(wyszukiwaniePokoiDTO.getDataPoczatku()) && r.getDataOdjazdu().before(wyszukiwaniePokoiDTO.getDataKonca())) );
                czyZarezerwowany = true;
            }
            if(!czyZarezerwowany){
                pokojeTemp.add(p);
            }
        }
        return pokojeTemp;
    }

    @PostMapping("/dokonajRezerwacji")
    public Rezerwacje dokonajRezerwacji(@RequestBody RezerwacjaDTO rezerwacjaDTO){
        Klient klient = new Klient();
        klient.setImie(rezerwacjaDTO.getImie());
        klient.setNazwisko(rezerwacjaDTO.getNazwisko());
        klient = klientService.zapiszKlienta(klient);
        Rezerwacje rezerwacja = new Rezerwacje();
        rezerwacja.setKlient(klient);
        rezerwacja.setPokoj(rezerwacjaDTO.getPokoj());
        rezerwacja.setDataOdjazdu(rezerwacjaDTO.getDataKonca());
        rezerwacja.setDataPrzyjazdu(rezerwacjaDTO.getDataPoczatku());
        return rezerwacjaService.zapiszRezerwacje(rezerwacja);
    }

}
