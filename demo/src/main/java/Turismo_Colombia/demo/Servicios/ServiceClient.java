package Turismo_Colombia.demo.Servicios;

import Turismo_Colombia.demo.Models.Client;
import Turismo_Colombia.demo.Repositorios.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceClient {

    @Autowired
    private IClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public Client findClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client updateClient(Long id, Client updatedClient) {
        Optional<Client> optionalClient = clientRepository.findById(id);

        if (optionalClient.isPresent()) {
            Client existingClient = optionalClient.get();
            existingClient.setName(updatedClient.getName());
            existingClient.setLastName(updatedClient.getLastName());
            existingClient.setEmail(updatedClient.getEmail());
            existingClient.setPhone(updatedClient.getPhone());
            existingClient.setCity(updatedClient.getCity());
            existingClient.setDocument(updatedClient.getDocument());
            existingClient.setStatus(updatedClient.getStatus());
            existingClient.setPassword(updatedClient.getPassword());
            existingClient.setCountry(updatedClient.getCountry());
            existingClient.setRol(updatedClient.getRol());
            return clientRepository.save(existingClient);
        }
        return null;
    }

    public boolean deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
