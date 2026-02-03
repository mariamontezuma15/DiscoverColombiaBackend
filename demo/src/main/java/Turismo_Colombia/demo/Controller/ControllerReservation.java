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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Turismo_Colombia.demo.Models.Reserve;
import Turismo_Colombia.demo.Servicios.ServiceReserve;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/discoverapi/v1/reservation")
@Tag(name = "CRUD Controller for Reservation web services")
public class ControllerReservation {

    @Autowired
    ServiceReserve service;
    
    @PostMapping
    @Operation(summary = "Create a new reservation", description = "Creates a new reservation with the provided information")
    @ApiResponse(responseCode = "201", description = "Reservation created successfully", content = @Content(schema = @Schema(implementation = Reserve.class)))
    @ApiResponse(responseCode = "400", description = "Invalid reservation data")
    public ResponseEntity <Reserve> createReserva(@RequestBody Reserve data){
        Reserve responsReserve = this.service.createReserve(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(responsReserve);
    }

    @GetMapping
    @Operation(summary = "Get all reservations", description = "Retrieves a list of all registered reservations")
    @ApiResponse(responseCode = "200", description = "List of reservations retrieved successfully", content = @Content(schema = @Schema(implementation = Reserve.class)))
    public ResponseEntity <List<Reserve>>findAllReservas(){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.findAllReservations());
    }

    @GetMapping(value ="/{id}")
    @Operation(summary = "Get reservation by ID", description = "Retrieves a specific reservation by its ID")
    @ApiResponse(responseCode = "200", description = "Reservation found and retrieved successfully", content = @Content(schema = @Schema(implementation = Reserve.class)))
    @ApiResponse(responseCode = "404", description = "Reservation not found")
    public ResponseEntity <Reserve> findReservaById(
            @Parameter(description = "Reservation ID", required = true)
            @PathVariable Long id){
        Reserve reserve = this.service.findReserveById(id);
        if (reserve == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(reserve);
    }

    @PutMapping(value ="/{id}")
    @Operation(summary = "Update reservation", description = "Updates an existing reservation with the provided information")
    @ApiResponse(responseCode = "200", description = "Reservation updated successfully", content = @Content(schema = @Schema(implementation = Reserve.class)))
    @ApiResponse(responseCode = "404", description = "Reservation not found")
    public ResponseEntity <Reserve> updateReserva(
            @Parameter(description = "Reservation ID", required = true)
            @PathVariable Long id, 
            @RequestBody Reserve data){
        Reserve responsReserve = this.service.updateReserve(id, data);
        if (responsReserve == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(responsReserve);
    }

    @DeleteMapping(value ="/{id}")
    @Operation(summary = "Delete reservation", description = "Deletes a reservation by its ID")
    @ApiResponse(responseCode = "200", description = "Reservation deleted successfully")
    @ApiResponse(responseCode = "404", description = "Reservation not found")
    public ResponseEntity <Boolean> deleteReserva(
            @Parameter(description = "Reservation ID", required = true)
            @PathVariable Long id){
        boolean isDeleted = this.service.deleteReserve(id);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

}
