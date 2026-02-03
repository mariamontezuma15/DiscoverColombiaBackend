package Turismo_Colombia.demo.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "reservas")
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserve;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @Column(nullable = false)
    private Integer peopleAmmount;

    @Column(nullable = false)
    private Double totalPrice;

    @Column(length = 30, nullable = false)
    private String status;   // PENDIENTE, PAGADO, CANCELADO

    @Column(length = 30, nullable = false)
    private String paymentMethod;

    @Column(length = 30, nullable = false)
    private String reservationDate;

    @Column(length = 30)
    private String paymentDate;

    @Column(length = 50, nullable = false)
    private String reservationCode;

    @Column(nullable = false)
    private Boolean active;

    public Reserve() {}

    public Reserve(Long idReserve, Client client, Trip trip, Integer peopleAmmount,
                   Double totalPrice, String status, String paymentMethod, String reservationDate,
                   String paymentDate, String reservationCode, Boolean active) {
        this.idReserve = idReserve;
        this.client = client;
        this.trip = trip;
        this.peopleAmmount = peopleAmmount;
        this.totalPrice = totalPrice;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.reservationDate = reservationDate;
        this.paymentDate = paymentDate;
        this.reservationCode = reservationCode;
        this.active = active;
    }

    // Getters y Setters

    public Long getidReserve() { return idReserve; }
    public void setidReserve(Long idReserve) { this.idReserve = idReserve; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Trip getTrip() { return trip; }
    public void setTrip(Trip trip) { this.trip = trip; }

    public Integer getPeopleAmmount() { return peopleAmmount; }
    public void setPeopleAmmount(Integer peopleAmmount) { this.peopleAmmount = peopleAmmount; }

    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getReservationDate() { return reservationDate; }
    public void setReservationDate(String reservationDate) { this.reservationDate = reservationDate; }

    public String getPaymentDate() { return paymentDate; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }

    public String getReservationCode() { return reservationCode; }
    public void setReservationCode(String reservationCode) { this.reservationCode = reservationCode; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
