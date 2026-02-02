package Turismo_Colombia.demo.Servicios;

import Turismo_Colombia.demo.Modelos.Reserva;
import Turismo_Colombia.demo.Repositorios.IReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceReserva {

    @Autowired
    private IReservaRepository reservaRepository;

    public Reserva createReserva(Reserva reserva){
        return reservaRepository.save(reserva);
    }

    public List<Reserva> findAllReservas(){
        return reservaRepository.findAll();
    }

    public Reserva findReservaById(Integer id){
        return reservaRepository.findById(id).orElse(null);
    }

    public Reserva updateReserva(Integer id, Reserva updatedReserva){
        Optional<Reserva> optionalReserva = reservaRepository.findById(id);

        if (optionalReserva.isPresent()){
            Reserva existingReserva = optionalReserva.get();
            existingReserva.setCodigoReserva(updatedReserva.getCodigoReserva());
            existingReserva.setFechaReserva(updatedReserva.getFechaReserva());
            existingReserva.setEstado(updatedReserva.getEstado());
            existingReserva.setActiva(updatedReserva.getActiva());
            existingReserva.setCantidadPersonas(updatedReserva.getCantidadPersonas());
            existingReserva.setCliente(updatedReserva.getCliente());
            existingReserva.setPrecioTotal(updatedReserva.getPrecioTotal());
            existingReserva.setMetodoPago(updatedReserva.getMetodoPago());
            existingReserva.setFechaPago(updatedReserva.getFechaPago());
            existingReserva.setViaje(updatedReserva.getViaje());
            return  reservaRepository.save(existingReserva);
        }
        return null;
    }

    public boolean deleteReserva(Integer id){
        Optional<Reserva> optionalReserva = reservaRepository.findById(id);
        if (optionalReserva.isPresent()){
            reservaRepository.delete(optionalReserva.get());
            return true;
        }
        return false;
    }
}
