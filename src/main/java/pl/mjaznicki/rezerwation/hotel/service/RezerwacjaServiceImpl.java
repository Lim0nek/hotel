package pl.mjaznicki.rezerwation.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mjaznicki.rezerwation.hotel.dto.RezerwacjaDTO;
import pl.mjaznicki.rezerwation.hotel.model.Klient;
import pl.mjaznicki.rezerwation.hotel.model.Pokoj;
import pl.mjaznicki.rezerwation.hotel.model.Rezerwacje;
import pl.mjaznicki.rezerwation.hotel.repository.RezerwacjeRepository;
import pl.mjaznicki.rezerwation.hotel.service.api.RezerwacjaService;

import java.util.Date;
import java.util.List;

@Service
public class RezerwacjaServiceImpl implements RezerwacjaService {

    @Autowired
    private RezerwacjeRepository rezerwacjeRepository;


    @Override
    public List<Rezerwacje> znajdzPoPokojach(Pokoj pokoj) {
        return rezerwacjeRepository.findAllByPokoj(pokoj);
    }

    @Override
    public Rezerwacje zapiszRezerwacje(Rezerwacje rezerwacje) {
        return rezerwacjeRepository.save(rezerwacje);
    }

    @Override
    public Rezerwacje zapiszRezerwacje(RezerwacjaDTO rezerwacjaDTO, Klient klient) {
        Rezerwacje rezerwacja = new Rezerwacje();
        rezerwacja.setKlient(klient);
        rezerwacja.setPokoj(rezerwacjaDTO.getPokoj());
        rezerwacja.setDataOdjazdu(rezerwacjaDTO.getDataKonca());
        rezerwacja.setDataPrzyjazdu(rezerwacjaDTO.getDataPoczatku());
        return  rezerwacjeRepository.save(rezerwacja);
    }

}
