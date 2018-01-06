package pl.mjaznicki.rezerwation.hotel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "POKOJ")
public class Pokoj {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMER_POKOJU")
    private String numerPokoju;

    @Column(name = "WIELKOSC", nullable = false)
    private int wielkosc;
}
