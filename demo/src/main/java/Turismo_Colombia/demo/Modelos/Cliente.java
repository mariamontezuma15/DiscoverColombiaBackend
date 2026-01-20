package Turismo_Colombia.demo.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String apellido;

    @Column(length = 50, nullable = false)
    private String telefono;

    @Column(length = 80, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String ciudad;

    @Column(length = 50, nullable = false)
    private String pais;

    @Column(length = 50, nullable = false)
    private String documento;

    @Column(length = 20, nullable = false)
    private String rol;   // CLIENTE / ADMIN

    @Column(nullable = false)
    private Boolean estado;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private java.util.List<Reserva> reservas;

    public Cliente() {}

    public Cliente(Long idCliente, String nombre, String apellido, String telefono, String email, String ciudad,
                   String pais, String documento, String rol, Boolean estado, String password) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.ciudad = ciudad;
        this.pais = pais;
        this.documento = documento;
        this.rol = rol;
        this.estado = estado;
        this.password = password;
    }



    public Long getIdCliente() { return idCliente; }
    public void setIdCliente(Long idCliente) { this.idCliente = idCliente; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
