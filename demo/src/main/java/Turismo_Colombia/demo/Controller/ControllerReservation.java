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

import Turismo_Colombia.demo.Models.Reserve;
import Turismo_Colombia.demo.Servicios.ServiceReserva;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/discoverapi/v1/reservation")
public class ControllerReservation {

    @Autowired
    ServiceReserva service;
    
    @PostMapping
    public ResponseEntity <Reserve> createReserva(@RequestBody Reserve data){
        Reserve responsReserve = this.service.createReserva(data);
        return ResponseEntity.status(HttpStatus.OK).body(responsReserve);
    }

    @GetMapping
    public ResponseEntity <List<Reserve>>findAllReservas(){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.findAllReservas());
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity <Reserve> findReservaById(@PathVariable Long id){
         return ResponseEntity.status(HttpStatus.OK).body(this.service.findReservaById(id));
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity <Reserve> updateReserva(@PathVariable Long id, @RequestBody Reserve data){
        Reserve responsReserve = this.service.updateReserva(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(responsReserve);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity <Boolean> deleteReserva(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.deleteReserva(id));
    }

}
