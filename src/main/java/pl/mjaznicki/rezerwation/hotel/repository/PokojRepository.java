package pl.mjaznicki.rezerwation.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mjaznicki.rezerwation.hotel.model.Pokoj;

import java.util.List;

public interface PokojRepository extends JpaRepository<Pokoj,Long> {
    List<Pokoj> findByWielkosc(int wielksc);
}
