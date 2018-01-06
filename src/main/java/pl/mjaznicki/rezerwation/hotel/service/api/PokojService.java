package pl.mjaznicki.rezerwation.hotel.service.api;

import pl.mjaznicki.rezerwation.hotel.dto.WyszukiwaniePokoiDTO;
import pl.mjaznicki.rezerwation.hotel.model.Pokoj;

import java.util.List;

public interface PokojService {
    List<Pokoj> znajdzWszystkie();
    List<Pokoj> znajdzPoWielkosci(int wielkosc);
    List<Pokoj> znajdzWolne(WyszukiwaniePokoiDTO wyszukiwaniePokoiDTO);

}
