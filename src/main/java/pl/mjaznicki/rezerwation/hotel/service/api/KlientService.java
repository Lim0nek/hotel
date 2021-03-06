package pl.mjaznicki.rezerwation.hotel.service.api;

import pl.mjaznicki.rezerwation.hotel.dto.RezerwacjaDTO;
import pl.mjaznicki.rezerwation.hotel.model.Klient;

public interface KlientService {
    Klient zapiszKlienta(Klient klient);
    Klient zapiszKlienta(RezerwacjaDTO rezerwacjaDTO);
}
