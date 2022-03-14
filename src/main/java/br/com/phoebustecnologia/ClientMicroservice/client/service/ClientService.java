package br.com.phoebustecnologia.ClientMicroservice.client.service;

import br.com.phoebustecnologia.ClientMicroservice.client.dto.ClientDTO;
import br.com.phoebustecnologia.ClientMicroservice.client.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    //Listar clientes
    List<ClientDTO> findAll();

    //Pesquisar Client por ID
    ClientDTO findById(Long id);

    //Deletar client
    void delete(Long id);

    //Salvar client
    ClientDTO save(ClientDTO client);

    //Atualizar client
    ClientDTO update(Long id, ClientDTO client);

    Optional<Client> findByEmail(String email);

}
