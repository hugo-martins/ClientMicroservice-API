package br.com.phoebustecnologia.ClientMicroservice.client.controller;

import br.com.phoebustecnologia.ClientMicroservice.client.dto.ClientDTO;
import br.com.phoebustecnologia.ClientMicroservice.client.model.Client;
import br.com.phoebustecnologia.ClientMicroservice.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientServices;

    @GetMapping(value = "/all")
    public List<ClientDTO> clientList() {
        return clientServices.findAll();

    }

    @GetMapping(path = "/findClient/{email}")
    public Optional<Client> findByEmail(@PathVariable String email ) {
        return clientServices.findByEmail(email);
    }

    @GetMapping(value = "/{id}")
    public ClientDTO clientById(@PathVariable Long id){
        return clientServices.findById(id);

    }
    @PostMapping
    public ClientDTO addClient(@RequestBody ClientDTO clientDTO) {
        return clientServices.save(clientDTO);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientServices.delete(id);

    }

    @PutMapping(value = "/{id}")
    public ClientDTO updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO){
        return clientServices.update(id,clientDTO);
    }
}
