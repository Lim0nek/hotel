package pl.mjaznicki.rezerwation.hotel.dto;

import lombok.Getter;
import lombok.Setter;
import pl.mjaznicki.rezerwation.hotel.model.Pokoj;

import java.util.Date;

@Getter
@Setter
public class RezerwacjaDTO {
    private Pokoj pokoj;
    private String imie;
    private String nazwisko;
    private Date dataPoczatku;
    private Date dataKonca;
}
