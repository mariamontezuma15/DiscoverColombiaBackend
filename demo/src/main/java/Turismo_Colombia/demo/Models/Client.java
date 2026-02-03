package Turismo_Colombia.demo.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String lastName;
    @Column(length = 50)
    private String phone;
    @Column(length = 80)
    private String email;
    @Column(length = 50)
    private String city;
    @Column(length = 50)
    private String country;
    @Column(length = 50)
    private String document;
    @Column(length = 20)
    private String rol;   // CLIENTE / ADMIN
    @Column
    private Boolean status;
    @Column
    private String password;

    public Client() {
    }

    public Client(Long idClient, String name, String lastName, String phone, String email, String city, String country,
                  String document, String rol, Boolean status, String password) {
        this.idClient = idClient;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.country = country;
        this.document = document;
        this.rol = rol;
        this.status = status;
        this.password = password;
    }

    public Long getIdClients() {
        return idClient;
    }

    public void setIdClients(Long idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
