package pl.mjaznicki.rezerwation.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mjaznicki.rezerwation.hotel.model.Klient;

public interface KlientRepository extends JpaRepository<Klient,Long> {
}
