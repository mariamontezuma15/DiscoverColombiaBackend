package Turismo_Colombia.demo.Servicios;

import Turismo_Colombia.demo.Models.Reserve;
import Turismo_Colombia.demo.Repositorios.IReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceReserve {

    @Autowired
    private IReserveRepository reserveRepository;

    public Reserve createReserve(Reserve reserve) {
        return reserveRepository.save(reserve);
    }

    public List<Reserve> findAllReservations() {
        return reserveRepository.findAll();
    }

    public Reserve findReserveById(Long id) {
        return reserveRepository.findById(id).orElse(null);
    }

    public Reserve updateReserve(Long id, Reserve updatedReserve) {
        Optional<Reserve> optionalReserve = reserveRepository.findById(id);

        if (optionalReserve.isPresent()) {
            Reserve existingReserve = optionalReserve.get();
            existingReserve.setStatus(updatedReserve.getStatus());
            existingReserve.setReservationCode(updatedReserve.getReservationCode());
            existingReserve.setReservationDate(updatedReserve.getReservationDate());
            existingReserve.setActive(updatedReserve.getActive());
            existingReserve.setClient(updatedReserve.getClient());
            existingReserve.setPaymentDate(updatedReserve.getPaymentDate());
            existingReserve.setPaymentMethod(updatedReserve.getPaymentMethod());
            existingReserve.setPeopleAmmount(updatedReserve.getPeopleAmmount());
            existingReserve.setTotalPrice(updatedReserve.getTotalPrice());
            existingReserve.setTrip(updatedReserve.getTrip());
            return reserveRepository.save(existingReserve);
        }
        return null;
    }

    public boolean deleteReserve(Long id) {
        Optional<Reserve> optionalReserve = reserveRepository.findById(id);
        if (optionalReserve.isPresent()) {
            reserveRepository.delete(optionalReserve.get());
            return true;
        }
        return false;
    }
}
