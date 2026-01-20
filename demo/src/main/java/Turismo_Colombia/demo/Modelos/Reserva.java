package Turismo_Colombia.demo.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "viaje_id", nullable = false)
    private Viaje viaje;

    @Column(nullable = false)
    private Integer cantidadPersonas;

    @Column(nullable = false)
    private Double precioTotal;

    @Column(length = 30, nullable = false)
    private String estado;   // PENDIENTE, PAGADO, CANCELADO

    @Column(length = 30, nullable = false)
    private String metodoPago;

    @Column(length = 30, nullable = false)
    private String fechaReserva;

    @Column(length = 30)
    private String fechaPago;

    @Column(length = 50, nullable = false)
    private String codigoReserva;

    @Column(nullable = false)
    private Boolean activa;

    public Reserva() {}

    public Reserva(Long idReserva, Cliente cliente, Viaje viaje, Integer cantidadPersonas,
                   Double precioTotal, String estado, String metodoPago, String fechaReserva,
                   String fechaPago, String codigoReserva, Boolean activa) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.viaje = viaje;
        this.cantidadPersonas = cantidadPersonas;
        this.precioTotal = precioTotal;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.fechaReserva = fechaReserva;
        this.fechaPago = fechaPago;
        this.codigoReserva = codigoReserva;
        this.activa = activa;
    }

    // Getters y Setters

    public Long getIdReserva() { return idReserva; }
    public void setIdReserva(Long idReserva) { this.idReserva = idReserva; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Viaje getViaje() { return viaje; }
    public void setViaje(Viaje viaje) { this.viaje = viaje; }

    public Integer getCantidadPersonas() { return cantidadPersonas; }
    public void setCantidadPersonas(Integer cantidadPersonas) { this.cantidadPersonas = cantidadPersonas; }

    public Double getPrecioTotal() { return precioTotal; }
    public void setPrecioTotal(Double precioTotal) { this.precioTotal = precioTotal; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public String getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(String fechaReserva) { this.fechaReserva = fechaReserva; }

    public String getFechaPago() { return fechaPago; }
    public void setFechaPago(String fechaPago) { this.fechaPago = fechaPago; }

    public String getCodigoReserva() { return codigoReserva; }
    public void setCodigoReserva(String codigoReserva) { this.codigoReserva = codigoReserva; }

    public Boolean getActiva() { return activa; }
    public void setActiva(Boolean activa) { this.activa = activa; }
}
