package Turismo_Colombia.demo.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "viajes")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idViaje;

    @Column(length = 80, nullable = false)
    private String titulo;

    @Column(length = 50, nullable = false)
    private String destino;

    @Column(length = 200, nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Integer cuposDisponibles;

    @Column(nullable = false)
    private Integer duracionDias;

    @Column(length = 30, nullable = false)
    private String tipo;   // Playa, Cultural, Aventura

    @Column(length = 150, nullable = false)
    private String imagenUrl;

    @Column(length = 30, nullable = false)
    private String ciudadSalida;

    @Column(nullable = false)
    private Boolean activo;

    @OneToMany(mappedBy = "viaje", cascade = CascadeType.ALL)
    private java.util.List<Reserva> reservas;

    public Viaje() {}

    public Viaje(Long idViaje, String titulo, String destino, String descripcion, Double precio,
                 Integer cuposDisponibles, Integer duracionDias, String tipo, String imagenUrl,
                 String ciudadSalida, Boolean activo) {
        this.idViaje = idViaje;
        this.titulo = titulo;
        this.destino = destino;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cuposDisponibles = cuposDisponibles;
        this.duracionDias = duracionDias;
        this.tipo = tipo;
        this.imagenUrl = imagenUrl;
        this.ciudadSalida = ciudadSalida;
        this.activo = activo;
    }


    public Long getIdViaje() { return idViaje; }
    public void setIdViaje(Long idViaje) { this.idViaje = idViaje; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Integer getCuposDisponibles() { return cuposDisponibles; }
    public void setCuposDisponibles(Integer cuposDisponibles) { this.cuposDisponibles = cuposDisponibles; }

    public Integer getDuracionDias() { return duracionDias; }
    public void setDuracionDias(Integer duracionDias) { this.duracionDias = duracionDias; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }

    public String getCiudadSalida() { return ciudadSalida; }
    public void setCiudadSalida(String ciudadSalida) { this.ciudadSalida = ciudadSalida; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}
