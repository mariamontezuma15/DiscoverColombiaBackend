package Turismo_Colombia.demo.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "viajes")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idViaje;

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

    @OneToMany(mappedBy = "viaje", cascade = CascadeType.ALL)
    private java.util.List<Reserve> Reserves;

    public Trip() {}

    public Trip(Long idViaje, String titulo, String destino, String descripcion, Double precio,
                Integer cuposDisponibles, Integer duracionDias, String tipo, String imagenUrl,
                String ciudadSalida, Boolean activo) {
        this.idViaje = idViaje;
        this.title = titulo;
        this.destination = destino;
        this.description = descripcion;
        this.price = precio;
        this.availableSpots = cuposDisponibles;
        this.Days = duracionDias;
        this.type = tipo;
        this.ImageUrl = imagenUrl;
        this.cityDeparture = ciudadSalida;
        this.active = activo;
    }


    public Long getIdViaje() { return idViaje; }
    public void setIdViaje(Long idViaje) { this.idViaje = idViaje; }

    public String getTitulo() { return title; }
    public void setTitulo(String titulo) { this.title = titulo; }

    public String getDestino() { return destination; }
    public void setDestino(String destino) { this.destination = destino; }

    public String getDescripcion() { return description; }
    public void setDescripcion(String descripcion) { this.description = descripcion; }

    public Double getPrecio() { return price; }
    public void setPrecio(Double precio) { this.price = precio; }

    public Integer getCuposDisponibles() { return availableSpots ; }
    public void setCuposDisponibles(Integer cuposDisponibles) { this.availableSpots = cuposDisponibles; }

    public Integer getDuracionDias() { return Days; }
    public void setDuracionDias(Integer duracionDias) { this.Days = duracionDias; }

    public String getTipo() { return type; }
    public void setTipo(String tipo) { this.type = tipo; }

    public String getImagenUrl() { return ImageUrl; }
    public void setImagenUrl(String imagenUrl) { this.ImageUrl = imagenUrl; }

    public String getCiudadSalida() { return cityDeparture; }
    public void setCiudadSalida(String ciudadSalida) { this.cityDeparture = ciudadSalida; }

    public Boolean getActivo() { return active; }
    public void setActivo(Boolean activo) { this.active = activo; }
}
