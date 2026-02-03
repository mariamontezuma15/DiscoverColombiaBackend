package Turismo_Colombia.demo.Servicios;

import Turismo_Colombia.demo.Models.Client;
import Turismo_Colombia.demo.Repositorios.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCliente {

    @Autowired
    private IClienteRepository clienteRepository;

    public Client createCliente(Client cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Client> findAllClientes() {
        return clienteRepository.findAll();
    }

    public Client findClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Client updateCliente(Long id, Client updatedCliente) {
        Optional<Client> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            Client existingCliente = optionalCliente.get();
            existingCliente.setName(updatedCliente.getName());
            existingCliente.setLastName(updatedCliente.getLastName());
            existingCliente.setEmail(updatedCliente.getEmail());
            existingCliente.setPhone(updatedCliente.getPhone());
            existingCliente.setCity(updatedCliente.getCity());
            existingCliente.setDocument(updatedCliente.getDocument());
            existingCliente.setStatus(updatedCliente.getStatus());
            existingCliente.setPassword(updatedCliente.getPassword());
            existingCliente.setCountry(updatedCliente.getCountry());
            existingCliente.setRol(updatedCliente.getRol());
            return clienteRepository.save(existingCliente);
        }
        return null;
    }

    public boolean deleteCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
