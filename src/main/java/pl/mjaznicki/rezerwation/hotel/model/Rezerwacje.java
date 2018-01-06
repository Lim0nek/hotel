package pl.mjaznicki.rezerwation.hotel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "REZERWACJE")
public class Rezerwacje {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="DATA_PRZYJAZDU")
    private Date dataPrzyjazdu;

    @Column(name="DATA_ODJAZDU")
    private Date dataOdjazdu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POKOJ_ID")
    private Pokoj pokoj;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KLIENT_ID")
    private Klient klient;
}
