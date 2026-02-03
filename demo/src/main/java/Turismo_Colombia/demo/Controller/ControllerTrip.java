package Turismo_Colombia.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Turismo_Colombia.demo.Models.Trip;
import Turismo_Colombia.demo.Servicios.ServiceViaje;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/discoverapi/v1/trip")
public class ControllerTrip {
@Autowired
    ServiceViaje service;
    
    @PostMapping
    public ResponseEntity <Trip> createViaje(@RequestBody Trip data){
        Trip responsTrip = this.service.createViaje(data);
        return ResponseEntity.status(HttpStatus.OK).body(responsTrip);
    }

    @GetMapping
    public ResponseEntity <List<Trip>>findAllViajes(){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.findAllViajes());
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity <Trip> findViajeById(@PathVariable Long id){
         return ResponseEntity.status(HttpStatus.OK).body(this.service.findViajeById(id));
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity <Trip> updateViaje(@PathVariable Long id, @RequestBody Trip data){
        Trip responsTrip = this.service.updateViaje(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(responsTrip);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity <Boolean> deleteViaje(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.deleteViaje(id));
    }

}
