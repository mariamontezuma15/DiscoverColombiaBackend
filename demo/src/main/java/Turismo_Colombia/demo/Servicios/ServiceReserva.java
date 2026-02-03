package Turismo_Colombia.demo.Servicios;

import Turismo_Colombia.demo.Models.Reserve;
import Turismo_Colombia.demo.Repositorios.IReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceReserva {

    @Autowired
    private IReservaRepository reservaRepository;

    public Reserve createReserva(Reserve reserva){
        return reservaRepository.save(reserva);
    }

    public List<Reserve> findAllReservas(){
        return reservaRepository.findAll();
    }

    public Reserve findReservaById(Long id){
        return reservaRepository.findById(id).orElse(null);
    }

    public Reserve updateReserva(Long id, Reserve updatedReserva){
        Optional<Reserve> optionalReserva = reservaRepository.findById(id);

        if (optionalReserva.isPresent()){
            Reserve existingReserva = optionalReserva.get();
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

    public boolean deleteReserva(Long id){
        Optional<Reserve> optionalReserva = reservaRepository.findById(id);
        if (optionalReserva.isPresent()){
            reservaRepository.delete(optionalReserva.get());
            return true;
        }
        return false;
    }
}
