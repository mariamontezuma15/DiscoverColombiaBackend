package Turismo_Colombia.demo.Servicios;

import Turismo_Colombia.demo.Models.Trip;
import Turismo_Colombia.demo.Repositorios.IViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceViaje {

    @Autowired
    private IViajeRepository viajeRepository;

    public Trip createViaje(Trip Viaje){
        return viajeRepository.save(Viaje);
    }

    public List<Trip> findAllViajes(){
        return viajeRepository.findAll();
    }

    public Trip findViajeById(Long id){
        return viajeRepository.findById(id).orElse(null);
    }

    public Trip updateViaje(Long id, Trip updatedViaje){
        Optional<Trip> optionalViaje = viajeRepository.findById(id);

        if (optionalViaje.isPresent()){
            Trip existingViaje = optionalViaje.get();
            existingViaje.setActive(updatedViaje.getActive());
            existingViaje.setCityDeparture(updatedViaje.getCityDeparture());
            existingViaje.setDestination(updatedViaje.getDestination());
            existingViaje.setDescription(updatedViaje.getDescription());
            existingViaje.setAvailableSpots(updatedViaje.getAvailableSpots());
            existingViaje.setDays(updatedViaje.getDays());
            existingViaje.setImageUrl(updatedViaje.getImageUrl());
            existingViaje.setPrice(updatedViaje.getPrice());
            existingViaje.setType(updatedViaje.getType());
            existingViaje.setTitle(updatedViaje.getTitle());
            return  viajeRepository.save(existingViaje);
        }
        return null;
    }

    public boolean deleteViaje(Long id){
        Optional<Trip> optionalViaje = viajeRepository.findById(id);
        if (optionalViaje.isPresent()){
            viajeRepository.delete(optionalViaje.get());
            return true;
        }
        return false;
    }
}
