package Turismo_Colombia.demo.Servicios;

import Turismo_Colombia.demo.Models.Trip;
import Turismo_Colombia.demo.Repositorios.ITripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTrip {

    @Autowired
    private ITripRepository tripRepository;

    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<Trip> findAllTrips() {
        return tripRepository.findAll();
    }

    public Trip findTripById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    public Trip updateTrip(Long id, Trip updatedTrip) {
        Optional<Trip> optionalTrip = tripRepository.findById(id);

        if (optionalTrip.isPresent()) {
            Trip existingTrip = optionalTrip.get();
            existingTrip.setActive(updatedTrip.getActive());
            existingTrip.setCityDeparture(updatedTrip.getCityDeparture());
            existingTrip.setDestination(updatedTrip.getDestination());
            existingTrip.setDescription(updatedTrip.getDescription());
            existingTrip.setAvailableSpots(updatedTrip.getAvailableSpots());
            existingTrip.setDays(updatedTrip.getDays());
            existingTrip.setImageUrl(updatedTrip.getImageUrl());
            existingTrip.setPrice(updatedTrip.getPrice());
            existingTrip.setType(updatedTrip.getType());
            existingTrip.setTitle(updatedTrip.getTitle());
            existingTrip.setReserves(updatedTrip.getReserves());
            return tripRepository.save(existingTrip);
        }
        return null;
    }

    public boolean deleteTrip(Long id) {
        Optional<Trip> optionalTrip = tripRepository.findById(id);
        if (optionalTrip.isPresent()) {
            tripRepository.delete(optionalTrip.get());
            return true;
        }
        return false;
    }
}
