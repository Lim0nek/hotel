package pl.mjaznicki.rezerwation.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.mjaznicki.rezerwation.hotel.model.Pokoj;
import pl.mjaznicki.rezerwation.hotel.service.api.PokojService;

import java.util.List;

@RestController
public class PokojController {

    @Autowired
    private PokojService pokojService;

    @GetMapping("/pokojWielkosc/{wielkosc}")
    public List<Pokoj> odbierzPokojePoWielkosci(@PathVariable(value = "wielkosc") int wielkosc ){
        return pokojService.znajdzPoWielkosci(wielkosc);
    }

}
