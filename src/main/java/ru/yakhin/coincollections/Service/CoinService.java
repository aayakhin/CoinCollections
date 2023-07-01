package ru.yakhin.coincollections.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yakhin.coincollections.model.Coin;
import ru.yakhin.coincollections.repository.CoinRepository;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CoinService {
  
    private final CoinRepository coinRepository;
    @Autowired
    public CoinService(CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }
    public List<Coin> findall(){
        return coinRepository.findAll();
    }

    public Coin findOne(int id){

        Optional<Coin> foundCoin = coinRepository.findById(id);
        return foundCoin.orElse(null);
    }
    @Transactional
    public void save(Coin coin){
        coinRepository.save(coin);
    }
    @Transactional
    public void update(Coin updatedCoin, int id){
        updatedCoin.setId(id);
        coinRepository.save(updatedCoin);
    }
    @Transactional
    public void delete(int id){
        coinRepository.deleteById(id);
    }

    public Page<Coin> findPaginated(Pageable pageable){
        final List<Coin> coins = coinRepository.findAll();

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage*pageSize;
        List<Coin> list;

        if (coins.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem+pageSize, coins.size());
            list = coins.subList(startItem, toIndex);
        }

        return new PageImpl<>(list, PageRequest.of(currentPage,pageSize), coins.size());
    }
}
