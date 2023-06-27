package ru.yakhin.coincollections.model;

public class Coin {
    private int id;
    private String denomination;
    private String name;
    private String date;
    private String description;
    private String coin_sides;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getCoin_sides() {
        return coin_sides;
    }

    public void setCoin_sides(String coin_sides) {
        this.coin_sides = coin_sides;
    }
}
