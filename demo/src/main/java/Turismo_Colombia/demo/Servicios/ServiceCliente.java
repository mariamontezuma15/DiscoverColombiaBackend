package Turismo_Colombia.demo.Servicios;

import Turismo_Colombia.demo.Modelos.Cliente;
import Turismo_Colombia.demo.Repositorios.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCliente {

    @Autowired
    private IClienteRepository clienteRepository;

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente findClienteById(int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente updateCliente(Integer id, Cliente updatedCliente) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente existingCliente = optionalCliente.get();
            existingCliente.setNombre(updatedCliente.getNombre());
            existingCliente.setApellido(updatedCliente.getApellido());
            existingCliente.setEmail(updatedCliente.getEmail());
            existingCliente.setTelefono(updatedCliente.getTelefono());
            existingCliente.setCiudad(updatedCliente.getCiudad());
            existingCliente.setDocumento(updatedCliente.getDocumento());
            existingCliente.setEstado(updatedCliente.getEstado());
            existingCliente.setPassword(updatedCliente.getPassword());
            existingCliente.setPais(updatedCliente.getPais());
            existingCliente.setRol(updatedCliente.getRol());
            return clienteRepository.save(existingCliente);
        }
        return null;
    }

    public boolean deleteCliente(Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
