package ru.yakhin.coincollections.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.yakhin.coincollections.model.Coin;

import java.util.List;

@Component
public class CoinDAO {

    private final SessionFactory sessionFactory;
    @Autowired
    public CoinDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Transactional
    public List<Coin> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Coin", Coin.class).getResultList();

    }
    @Transactional
    public Coin showById(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Coin.class, id);
    }
    @Transactional
    public void add(Coin coin) {
        Session session = sessionFactory.getCurrentSession();
        session.save(coin);
    }
    public void delete(int id){
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Coin.class,id));
    }

    public void update(Coin updatedCoin, int id) {
        Session session = sessionFactory.getCurrentSession();
        Coin coinToUpdate = session.get(Coin.class, id);
        coinToUpdate.setDenomination(updatedCoin.getDenomination());
        coinToUpdate.setName(updatedCoin.getName());
        coinToUpdate.setDate(updatedCoin.getDate());
        coinToUpdate.setDescription(updatedCoin.getDescription());
        coinToUpdate.setCoin_sides(updatedCoin.getCoin_sides());
    }
}
