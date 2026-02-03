package Turismo_Colombia.demo.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Turismo_Colombia.demo.Models.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {
}
