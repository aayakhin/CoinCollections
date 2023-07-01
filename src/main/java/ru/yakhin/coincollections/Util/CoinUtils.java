package ru.yakhin.coincollections.Util;

import ru.yakhin.coincollections.model.Coin;

import java.util.*;
import java.util.stream.IntStream;

public class CoinUtils {

    private static List<Coin> coins = new ArrayList<Coin>();

    private static final int NUM_COINS = 30;

    private static final int MIN_COIN_NUM = 1000;

    public static List<Coin> buildCoins() {
        if (coins.isEmpty()) {
            IntStream.range(0, NUM_COINS).forEach(n -> {
                coins.add(new Coin());
            });

        }

        return coins;
    }

}