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

import Turismo_Colombia.demo.Models.Trip;
import Turismo_Colombia.demo.Servicios.ServiceTrip;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/discoverapi/v1/trip")
@Tag(name = "CRUD Controller for Trip web services")
public class ControllerTrip {
    @Autowired
    ServiceTrip service;
    
    @PostMapping
    @Operation(summary = "Create a new trip", description = "Creates a new trip with the provided information")
    @ApiResponse(responseCode = "201", description = "Trip created successfully", content = @Content(schema = @Schema(implementation = Trip.class)))
    @ApiResponse(responseCode = "400", description = "Invalid trip data")
    public ResponseEntity <Trip> createViaje(@RequestBody Trip data){
        Trip responsTrip = this.service.createTrip(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(responsTrip);
    }

    @GetMapping
    @Operation(summary = "Get all trips", description = "Retrieves a list of all available trips")
    @ApiResponse(responseCode = "200", description = "List of trips retrieved successfully", content = @Content(schema = @Schema(implementation = Trip.class)))
    public ResponseEntity <List<Trip>>findAllViajes(){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.findAllTrips());
    }

    @GetMapping(value ="/{id}")
    @Operation(summary = "Get trip by ID", description = "Retrieves a specific trip by its ID")
    @ApiResponse(responseCode = "200", description = "Trip found and retrieved successfully", content = @Content(schema = @Schema(implementation = Trip.class)))
    @ApiResponse(responseCode = "404", description = "Trip not found")
    public ResponseEntity <Trip> findViajeById(
            @Parameter(description = "Trip ID", required = true)
            @PathVariable Long id){
        Trip trip = this.service.findTripById(id);
        if (trip == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(trip);
    }

    @PutMapping(value ="/{id}")
    @Operation(summary = "Update trip", description = "Updates an existing trip with the provided information")
    @ApiResponse(responseCode = "200", description = "Trip updated successfully", content = @Content(schema = @Schema(implementation = Trip.class)))
    @ApiResponse(responseCode = "404", description = "Trip not found")
    public ResponseEntity <Trip> updateViaje(
            @Parameter(description = "Trip ID", required = true)
            @PathVariable Long id, 
            @RequestBody Trip data){
        Trip responsTrip = this.service.updateTrip(id, data);
        if (responsTrip == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(responsTrip);
    }

    @DeleteMapping(value ="/{id}")
    @Operation(summary = "Delete trip", description = "Deletes a trip by its ID")
    @ApiResponse(responseCode = "200", description = "Trip deleted successfully")
    @ApiResponse(responseCode = "404", description = "Trip not found")
    public ResponseEntity <Boolean> deleteViaje(
            @Parameter(description = "Trip ID", required = true)
            @PathVariable Long id){
        boolean isDeleted = this.service.deleteTrip(id);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

}
