package ru.yakhin.coincollections.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yakhin.coincollections.model.Coin;
import ru.yakhin.coincollections.model.Country;
import ru.yakhin.coincollections.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country countryById(int id) {
        Optional<Country> country = countryRepository.findById(id);
        return country.orElse(null);
    }

    public List<Country> countryAll(){
        return countryRepository.findAll();
    }
}
