package ru.yakhin.coincollections.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.yakhin.coincollections.model.Coin;

import java.util.List;

@Component
public class CoinDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public CoinDAO (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    public List<Coin> index() {

        return jdbcTemplate.query("SELECT * FROM public.coin", new CoinMapper());

    }
    public Coin showById(int id){
        return jdbcTemplate.query("SELECT * FROM public.coin WHERE id=?", new Object[]{id}, new CoinMapper())
                .stream().findAny().orElse(null);
    }

    public void add(Coin coin) {
        jdbcTemplate.update("INSERT INTO public.coin(name, denomination, date, description, coin_sides) VALUES(?, ?, ?, ?, ?)", coin.getName(),
                coin.getDenomination(), coin.getDate(), coin.getDescription(), coin.getCoin_sides());
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM public.coin WHERE id=?", id);
    }

    public void update(Coin updatedCoin, int id) {
        jdbcTemplate.update("UPDATE public.coin SET name=?, denomination=?, date=?, description=?, coin_sides=? WHERE id=?",
                updatedCoin.getName(), updatedCoin.getDenomination(), updatedCoin.getDate(), updatedCoin.getDescription(), updatedCoin.getCoin_sides(), id);
    }
}
