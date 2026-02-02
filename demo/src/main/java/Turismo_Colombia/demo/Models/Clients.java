package Turismo_Colombia.demo.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClients;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 50, nullable = false)
    private String telephone;

    @Column(length = 80, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String city;

    @Column(length = 50, nullable = false)
    private String country;

    @Column(length = 50, nullable = false)
    private String document;

    @Column(length = 20, nullable = false)
    private String rol;   // CLIENTE / ADMIN

    @Column(nullable = false)
    private Boolean estado;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private java.util.List<Reserve> Reserves;

    public Clients() {}

    public Clients(Long idCliente, String nombre, String apellido, String telefono, String email, String ciudad,
                   String pais, String documento, String rol, Boolean estado, String password) {
        this.idClients = idCliente;
        this.name = nombre;
        this.lastName = apellido;
        this.telephone = telefono;
        this.email = email;
        this.city = ciudad;
        this.country = pais;
        this.document = documento;
        this.rol = rol;
        this.estado = estado;
        this.password = password;
    }



    public Long getIdCliente() { return idClients; }
    public void setIdCliente(Long idCliente) { this.idClients = idCliente; }

    public String getNombre() { return name; }
    public void setNombre(String nombre) { this.name = nombre; }

    public String getApellido() { return lastName; }
    public void setApellido(String apellido) { this.lastName = apellido; }

    public String getTelefono() { return telephone; }
    public void setTelefono(String telefono) { this.telephone = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCiudad() { return city; }
    public void setCiudad(String ciudad) { this.city = ciudad; }

    public String getPais() { return country; }
    public void setPais(String pais) { this.country = pais; }

    public String getDocumento() { return document; }
    public void setDocumento(String documento) { this.document = documento; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
