package ru.yakhin.coincollections.DAO;

import org.springframework.jdbc.core.RowMapper;
import ru.yakhin.coincollections.model.Coin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoinMapper implements RowMapper<Coin> {
    @Override
    public Coin mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Coin coin = new Coin();
        coin = new Coin();
        coin.setId(resultSet.getInt("id"));
        coin.setCurrency(resultSet.getString("currency"));
        coin.setName(resultSet.getString("name"));
        coin.setDate(resultSet.getString("date"));
        return coin;
    }
}
