package pl.mjaznicki.rezerwation.hotel.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WyszukiwaniePokoiDTO {
    private int wielkosc;
    private Date dataPoczatku;
    private Date dataKonca;
}
