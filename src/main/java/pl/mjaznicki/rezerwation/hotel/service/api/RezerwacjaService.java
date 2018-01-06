package pl.mjaznicki.rezerwation.hotel.service.api;

import pl.mjaznicki.rezerwation.hotel.model.Pokoj;
import pl.mjaznicki.rezerwation.hotel.model.Rezerwacje;

import java.util.Date;
import java.util.List;

public interface RezerwacjaService {
   List<Rezerwacje> znajdzPoPokojach(Pokoj pokoj);
   Rezerwacje zapiszRezerwacje(Rezerwacje rezerwacje);
}
