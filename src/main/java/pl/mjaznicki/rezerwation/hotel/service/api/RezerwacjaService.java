package pl.mjaznicki.rezerwation.hotel.service.api;

import pl.mjaznicki.rezerwation.hotel.dto.ListaRezerwacjiDTO;
import pl.mjaznicki.rezerwation.hotel.dto.RezerwacjaDTO;
import pl.mjaznicki.rezerwation.hotel.model.Klient;
import pl.mjaznicki.rezerwation.hotel.model.Pokoj;
import pl.mjaznicki.rezerwation.hotel.model.Rezerwacje;

import java.util.Date;
import java.util.List;

public interface RezerwacjaService {
   List<Rezerwacje> znajdzPoPokojach(Pokoj pokoj);
   Rezerwacje zapiszRezerwacje(Rezerwacje rezerwacje);
   Rezerwacje zapiszRezerwacje(RezerwacjaDTO rezerwacjaDTO, Klient klient);
   List<ListaRezerwacjiDTO> znajdzWszystkie();
   void usunRezerwacje(Long id);
}
