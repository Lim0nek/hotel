package pl.mjaznicki.rezerwation.hotel.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ListaRezerwacjiDTO {
    private Long id;
    private Date dataPrzyjazdu;
    private Date dataOdjazdu;
    private String numerPokoju;
}
