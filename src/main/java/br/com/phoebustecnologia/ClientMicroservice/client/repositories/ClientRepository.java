package br.com.phoebustecnologia.ClientMicroservice.client.repositories;

import br.com.phoebustecnologia.ClientMicroservice.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);

}

