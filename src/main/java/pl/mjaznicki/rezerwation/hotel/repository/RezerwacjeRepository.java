package pl.mjaznicki.rezerwation.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mjaznicki.rezerwation.hotel.model.Pokoj;
import pl.mjaznicki.rezerwation.hotel.model.Rezerwacje;

import java.util.List;

public interface RezerwacjeRepository extends JpaRepository<Rezerwacje, Long> {
    List<Rezerwacje> findAllByPokoj(Pokoj pokoj);
}
