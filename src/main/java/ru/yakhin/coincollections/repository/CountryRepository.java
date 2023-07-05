package ru.yakhin.coincollections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yakhin.coincollections.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
