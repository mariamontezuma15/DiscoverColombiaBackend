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

import Turismo_Colombia.demo.Models.Client;
import Turismo_Colombia.demo.Servicios.ServiceClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/discoverapi/v1/client")
@Tag(name = "CRUD Controller for Client web services")
public class ControllerClient {

    @Autowired
    ServiceClient serviceClient;

    @PostMapping
    @Operation(summary = "Create a new client", description = "Creates a new client with the provided information")
    @ApiResponse(responseCode = "201", description = "Client created successfully", content = @Content(schema = @Schema(implementation = Client.class)))
    @ApiResponse(responseCode = "400", description = "Invalid client data")
    public ResponseEntity<Client> createClient(@RequestBody Client data) {
        Client responseClient = this.serviceClient.createClient(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseClient);
    }

    @GetMapping
    @Operation(summary = "Get all clients", description = "Retrieves a list of all registered clients")
    @ApiResponse(responseCode = "200", description = "List of clients retrieved successfully", content = @Content(schema = @Schema(implementation = Client.class)))
    public ResponseEntity<List<Client>> findAllClients() {
        return ResponseEntity.status(HttpStatus.OK).body(this.serviceClient.findAllClients());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get client by ID", description = "Retrieves a specific client by their ID")
    @ApiResponse(responseCode = "200", description = "Client found and retrieved successfully", content = @Content(schema = @Schema(implementation = Client.class)))
    @ApiResponse(responseCode = "404", description = "Client not found")
    public ResponseEntity<Client> findClientById(
            @Parameter(description = "Client ID", required = true)
            @PathVariable Long id) {
        Client client = this.serviceClient.findClientById(id);
        if (client == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update client", description = "Updates an existing client with the provided information")
    @ApiResponse(responseCode = "200", description = "Client updated successfully", content = @Content(schema = @Schema(implementation = Client.class)))
    @ApiResponse(responseCode = "404", description = "Client not found")
    public ResponseEntity<Client> updateClient(
            @Parameter(description = "Client ID", required = true)
            @PathVariable Long id, 
            @RequestBody Client data) {
        Client updatedClient = this.serviceClient.updateClient(id, data);
        if (updatedClient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedClient);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete client", description = "Deletes a client by their ID")
    @ApiResponse(responseCode = "200", description = "Client deleted successfully")
    @ApiResponse(responseCode = "404", description = "Client not found")
    public ResponseEntity<Boolean> deleteClient(
            @Parameter(description = "Client ID", required = true)
            @PathVariable Long id) {
        boolean isDeleted = this.serviceClient.deleteClient(id);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
}