package ru.yakhin.coincollections.model;



import jakarta.persistence.*;



@Entity
@Table(name = "coin")
public class Coin {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "denomination")
    private String denomination;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private String date;
    @Column(name = "description")
    private String description;
    @Column(name = "coin_sides")
    private String coin_sides;
    public Coin() {
    }
    public Coin(String denomination, String name, String date, String description, String coin_sides) {
        this.denomination = denomination;
        this.name = name;
        this.date = date;
        this.description = description;
        this.coin_sides = coin_sides;
    }
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
