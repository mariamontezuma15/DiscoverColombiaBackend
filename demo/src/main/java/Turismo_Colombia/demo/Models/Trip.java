package Turismo_Colombia.demo.Models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrip;

    @Column(length = 80, nullable = false)
    private String title;
    @Column(length = 50, nullable = false)
    private String destination;
    @Column(length = 200, nullable = false)
    private String description;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Integer availableSpots;
    @Column(nullable = false)
    private Integer Days;
    @Column(length = 30, nullable = false)
    private String type;   // Playa, Cultural, Aventura
    @Column(length = 150, nullable = false)
    private String ImageUrl;
    @Column(length = 30, nullable = false)
    private String cityDeparture;
    @Column(nullable = false)
    private Boolean active;


    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private java.util.List<Reserve> Reserves;

    public Trip() {
    }

    public Trip(Long idTrip, String title, String destination, String description, Double price, Integer availableSpots, Integer days, String type, String imageUrl, String cityDeparture, Boolean active, List<Reserve> reserves) {
        this.idTrip = idTrip;
        this.title = title;
        this.destination = destination;
        this.description = description;
        this.price = price;
        this.availableSpots = availableSpots;
        Days = days;
        this.type = type;
        ImageUrl = imageUrl;
        this.cityDeparture = cityDeparture;
        this.active = active;
        Reserves = reserves;
    }

    public Long getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(Long idTrip) {
        this.idTrip = idTrip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAvailableSpots() {
        return availableSpots;
    }

    public void setAvailableSpots(Integer availableSpots) {
        this.availableSpots = availableSpots;
    }

    public Integer getDays() {
        return Days;
    }

    public void setDays(Integer days) {
        Days = days;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getCityDeparture() {
        return cityDeparture;
    }

    public void setCityDeparture(String cityDeparture) {
        this.cityDeparture = cityDeparture;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public java.util.List<Reserve> getReserves() {
        return Reserves;
    }

    public void setReserves(java.util.List<Reserve> reserves) {
        Reserves = reserves;
    }

}
