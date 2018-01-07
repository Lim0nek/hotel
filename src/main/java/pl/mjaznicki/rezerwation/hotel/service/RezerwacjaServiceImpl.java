package pl.mjaznicki.rezerwation.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mjaznicki.rezerwation.hotel.dto.ListaRezerwacjiDTO;
import pl.mjaznicki.rezerwation.hotel.dto.RezerwacjaDTO;
import pl.mjaznicki.rezerwation.hotel.model.Klient;
import pl.mjaznicki.rezerwation.hotel.model.Pokoj;
import pl.mjaznicki.rezerwation.hotel.model.Rezerwacje;
import pl.mjaznicki.rezerwation.hotel.repository.RezerwacjeRepository;
import pl.mjaznicki.rezerwation.hotel.service.api.RezerwacjaService;

import java.util.ArrayList;
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

    @Override
    public List<ListaRezerwacjiDTO> znajdzWszystkie() {
        List<Rezerwacje> rezerwacje = rezerwacjeRepository.findAll();
        List<ListaRezerwacjiDTO> listaRezerwacjiDTO = new ArrayList<>();
        for (Rezerwacje r: rezerwacje) {
            ListaRezerwacjiDTO temp = new ListaRezerwacjiDTO();
            temp.setId(r.getId());
            temp.setDataOdjazdu(r.getDataOdjazdu());
            temp.setDataPrzyjazdu(r.getDataPrzyjazdu());
            temp.setNumerPokoju(r.getPokoj().getNumerPokoju());
            listaRezerwacjiDTO.add(temp);
        }
        return listaRezerwacjiDTO;
    }

    @Override
    public void usunRezerwacje(Long id) {
        rezerwacjeRepository.delete(id);
    }

}
