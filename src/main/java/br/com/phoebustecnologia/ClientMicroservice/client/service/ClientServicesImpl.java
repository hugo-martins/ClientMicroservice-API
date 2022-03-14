package br.com.phoebustecnologia.ClientMicroservice.client.service;

import br.com.phoebustecnologia.ClientMicroservice.client.dto.ClientDTO;
import br.com.phoebustecnologia.ClientMicroservice.client.model.Client;
import br.com.phoebustecnologia.ClientMicroservice.client.repositories.ClientRepository;
import br.com.phoebustecnologia.ClientMicroservice.exceptions.ClientNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServicesImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServicesImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //Listar Clientes
    @Override
    public List<ClientDTO> findAll(){
        return ClientDTO.ListFromAllClients(clientRepository.findAll());

    }

    //Pesquisar Cliente por ID
    @Override
    public ClientDTO findById(Long id)  {
        Client result = clientRepository.findById(id)
                .orElseThrow(ClientNotFoundException::new);

        return ClientDTO.clientDTO(result);
    }

    //Deletar cliente
    @Override
    public void delete(Long id){
        Client client = clientRepository.findById(id)
                .orElseThrow(ClientNotFoundException::new);

        clientRepository.delete(client);
    }

    //Salvar cliente
    @Override
    public ClientDTO save(ClientDTO clientDTO){
        Client clientSaved = clientRepository.save(Client.clientSaved(clientDTO));
        return ClientDTO.clientDTO(clientSaved);
    }

    //Atualizar client
    public ClientDTO update(Long id, ClientDTO clientRequest)  {
        Client client =  clientRepository.findById(id)
                .orElseThrow(ClientNotFoundException::new);

        ClientDTO dto = ClientDTO.clientDTO(client);
        updateValuesClient(dto,clientRequest);

        return this.save(dto);

    }

    //Método para salvar e atualizar entidades dos clientes
    public void updateValuesClient(ClientDTO newObj, ClientDTO oldObj) {
        newObj.setName(oldObj.getName());
        newObj.setEmail(oldObj.getEmail());
        newObj.setPhone(oldObj.getPhone());
        newObj.setAge(oldObj.getAge());
        newObj.setSex(oldObj.getSex());
    }

    public Optional<Client> findByEmail(String email){
        return clientRepository.findByEmail(email);

    }
}
