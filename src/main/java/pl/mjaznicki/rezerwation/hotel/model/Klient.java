package pl.mjaznicki.rezerwation.hotel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "KLIENT")
public class Klient {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="IMIE")
    private String imie;

    @Column(name="NAZWISKO")
    private String nazwisko;


}
