package Turismo_Colombia.demo.Servicios;

import Turismo_Colombia.demo.Modelos.Viaje;
import Turismo_Colombia.demo.Repositorios.IViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceViaje {

    @Autowired
    private IViajeRepository viajeRepository;

    public Viaje createViaje(Viaje Viaje){
        return viajeRepository.save(Viaje);
    }

    public List<Viaje> findAllViajes(){
        return viajeRepository.findAll();
    }

    public Viaje findViajeById(Integer id){
        return viajeRepository.findById(id).orElse(null);
    }

    public Viaje updateViaje(Integer id, Viaje updatedViaje){
        Optional<Viaje> optionalViaje = viajeRepository.findById(id);

        if (optionalViaje.isPresent()){
            Viaje existingViaje = optionalViaje.get();
            existingViaje.setActivo(updatedViaje.getActivo());
            existingViaje.setCiudadSalida(updatedViaje.getCiudadSalida());
            existingViaje.setDestino(updatedViaje.getDestino());
            existingViaje.setDescripcion(updatedViaje.getDescripcion());
            existingViaje.setCuposDisponibles(updatedViaje.getCuposDisponibles());
            existingViaje.setDuracionDias(updatedViaje.getDuracionDias());
            existingViaje.setImagenUrl(updatedViaje.getImagenUrl());
            existingViaje.setPrecio(updatedViaje.getPrecio());
            existingViaje.setTipo(updatedViaje.getTipo());
            existingViaje.setTitulo(updatedViaje.getTitulo());
            return  viajeRepository.save(existingViaje);
        }
        return null;
    }

    public boolean deleteViaje(Integer id){
        Optional<Viaje> optionalViaje = viajeRepository.findById(id);
        if (optionalViaje.isPresent()){
            viajeRepository.delete(optionalViaje.get());
            return true;
        }
        return false;
    }
}
