package pl.mjaznicki.rezerwation.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mjaznicki.rezerwation.hotel.model.Pokoj;
import pl.mjaznicki.rezerwation.hotel.repository.PokojRepository;
import pl.mjaznicki.rezerwation.hotel.service.api.PokojService;

import java.util.List;

@Service
public class PokojServiceImpl implements PokojService {

    @Autowired
    private PokojRepository pokojRepository;

    @Override
    public List<Pokoj> znajdzWszystkie() {
        return pokojRepository.findAll();
    }

    @Override
    public List<Pokoj> znajdzPoWielkosci(int wielkosc) {
        return pokojRepository.findByWielkosc(wielkosc);
    }
}
