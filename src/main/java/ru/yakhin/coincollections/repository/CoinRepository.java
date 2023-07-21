package ru.yakhin.coincollections.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yakhin.coincollections.model.Coin;

import java.util.List;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Integer> {
    Page<Coin> findByNameContainingIgnoreCase(String keyword, Pageable pageable);

    Page<Coin> findAllByCountryIdIn(List<Integer> countryIds, Pageable pageable);

    Coin findById(int id);

}
