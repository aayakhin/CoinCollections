package ru.yakhin.coincollections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yakhin.coincollections.model.Coin;
@Repository
public interface CoinRepository extends JpaRepository<Coin, Integer> {
}
