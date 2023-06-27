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

/*    public List<Coin> showByName(String name){
        List<Coin> coins = null;
        PreparedStatement pStatement = null;
        try {
            pStatement = connection.prepareStatement("SELECT * FROM public.coin WHERE name=?");
            pStatement.setString(1, name);
            ResultSet resultSet = pStatement.executeQuery();


            coins= new ArrayList<>();
            while (resultSet.next()) {
                Coin coin = new Coin();
                coin.setId(resultSet.getInt("id"));
                coin.setName(resultSet.getString("name"));
                coin.setCurrency(resultSet.getString("denomination"));
                coin.setDate(resultSet.getString("date"));
                coins.add(coin);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return coins;
    }*/

    public void add(Coin coin) {
        jdbcTemplate.update("INSERT INTO public.coin(name, denomination, date, description, coin_sides) VALUES(?, ?, ?, ?, ?)", coin.getName(),
                coin.getDenomination(), coin.getDate(), coin.getDescription(), coin.getCoin_sides());
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM public.coin WHERE id=?", id);
    }
}
