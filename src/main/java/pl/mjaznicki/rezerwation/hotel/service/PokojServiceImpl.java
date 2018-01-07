package pl.mjaznicki.rezerwation.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mjaznicki.rezerwation.hotel.dto.WyszukiwaniePokoiDTO;
import pl.mjaznicki.rezerwation.hotel.model.Pokoj;
import pl.mjaznicki.rezerwation.hotel.model.Rezerwacje;
import pl.mjaznicki.rezerwation.hotel.repository.PokojRepository;
import pl.mjaznicki.rezerwation.hotel.service.api.PokojService;
import pl.mjaznicki.rezerwation.hotel.service.api.RezerwacjaService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokojServiceImpl implements PokojService {

    @Autowired
    private PokojRepository pokojRepository;

    @Autowired
    private RezerwacjaService rezerwacjaService;

    @Override
    public List<Pokoj> znajdzWszystkie() {
        return pokojRepository.findAll();
    }

    @Override
    public List<Pokoj> znajdzPoWielkosci(int wielkosc) {
        return pokojRepository.findByWielkosc(wielkosc);
    }

    @Override
    public List<Pokoj> znajdzWolne(WyszukiwaniePokoiDTO wyszukiwaniePokoiDTO) {
        List<Pokoj> pokojeWszystkie  = pokojRepository.findByWielkosc(wyszukiwaniePokoiDTO.getWielkosc());
        List<Pokoj> pokojeTemp = new ArrayList<>();
        for (Pokoj p: pokojeWszystkie) {
            List<Rezerwacje> rezerwacjes = rezerwacjaService.znajdzPoPokojach(p);
            boolean czyZarezerwowany = false;
            for (Rezerwacje r : rezerwacjes) {
                if((wyszukiwaniePokoiDTO.getDataPoczatku().after(r.getDataPrzyjazdu()) && wyszukiwaniePokoiDTO.getDataPoczatku().before(r.getDataOdjazdu())||
                wyszukiwaniePokoiDTO.getDataPoczatku().equals(r.getDataPrzyjazdu())) ||
                        (wyszukiwaniePokoiDTO.getDataKonca().after(r.getDataPrzyjazdu())&& wyszukiwaniePokoiDTO.getDataKonca().before(r.getDataOdjazdu()))
                        ||wyszukiwaniePokoiDTO.getDataKonca().equals(r.getDataOdjazdu())){
                    czyZarezerwowany = true;
                }
            }
            if(!czyZarezerwowany){
                pokojeTemp.add(p);
            }
        }
        return pokojeTemp;
    }
}
