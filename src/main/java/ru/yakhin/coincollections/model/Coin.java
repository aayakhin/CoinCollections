package ru.yakhin.coincollections.model;



import jakarta.persistence.*;


@Entity(name = "coin")
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
    private String coinSides;
    @Column(name = "avers_name")
    private String aversName;
    @Column(name = "revers_name")
    private String reversName;
    @ManyToOne
    @JoinColumn(name = "c_id", referencedColumnName = "country_id")
    private Country country;

    public Coin() {
    }

    public Coin(int id, String denomination, String name, String date, String description, String coinSides, String aversName, String reversName, Country country) {
        this.id = id;
        this.denomination = denomination;
        this.name = name;
        this.date = date;
        this.description = description;
        this.coinSides = coinSides;
        this.aversName = aversName;
        this.reversName = reversName;
        this.country = country;
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
    public String getCoinSides() {
        return coinSides;
    }
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setCoinSides(String coinSides) {
        this.coinSides = coinSides;
    }
    public String getAversName() {
        return aversName;
    }

    public void setAversName(String aversName) {
        this.aversName = aversName;
    }

    public String getReversName() {
        return reversName;
    }

    public void setReversName(String reversName) {
        this.reversName = reversName;
    }
}
