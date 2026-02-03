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

import Turismo_Colombia.demo.Models.Client;
import Turismo_Colombia.demo.Servicios.ServiceCliente;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/discoverapi/v1/client")
@Tag(name = "CRUD Controller for Client web services")
public class ControllerClient {

    // inyteccion de dependencia
    @Autowired
    ServiceCliente service;
    
    @PostMapping
    public ResponseEntity <Client> createCliente(@RequestBody Client data){
        Client responsClient = this.service.createCliente(data);
        return ResponseEntity.status(HttpStatus.OK).body(responsClient);
    }

    @GetMapping
    public ResponseEntity <List<Client>>findAllClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.findAllClientes());
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity <Client> findClienteById(@PathVariable Long id){
         return ResponseEntity.status(HttpStatus.OK).body(this.service.findClienteById(id));
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity <Client> updateCliente(@PathVariable Long id, @RequestBody Client data){
        Client responsClient = this.service.updateCliente(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(responsClient);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity <Boolean> deleteCliente(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.deleteCliente(id));
    }

}
