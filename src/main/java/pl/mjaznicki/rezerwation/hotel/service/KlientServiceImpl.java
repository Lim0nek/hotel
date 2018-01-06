package pl.mjaznicki.rezerwation.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mjaznicki.rezerwation.hotel.model.Klient;
import pl.mjaznicki.rezerwation.hotel.repository.KlientRepository;
import pl.mjaznicki.rezerwation.hotel.service.api.KlientService;

@Service
public class KlientServiceImpl implements KlientService {

    @Autowired
    private KlientRepository klientRepository;

    @Override
    public Klient zapiszKlienta(Klient klient) {
        return klientRepository.save(klient);
    }
}

