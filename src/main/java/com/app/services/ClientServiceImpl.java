package com.app.services;

import com.app.dto.ClientDTO;
import com.app.entities.ClientEntity;
import com.app.mappers.ClientMapper;
import com.app.models.Client;
import com.app.repositories.ClientRepository;
import com.app.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public ClientDTO create(Client client) {
        ClientEntity clientEntity = ClientMapper.INSTANCE.clientModelToClientEntity(client);
        clientRepository.save(clientEntity);
        ClientDTO clientDTO = ClientMapper.INSTANCE.clientEntityToClientDTO(clientEntity);
        return clientDTO;
    }

    @Override
    public Set<ClientDTO> getAllClients() {
        Set<ClientEntity> clients = StreamSupport.stream(clientRepository.findAll().spliterator(), false).collect(Collectors.toSet());
        Set<ClientDTO> clientsDto = ClientMapper.INSTANCE.clientEntitiesToClientDTOs(clients);
        return clientsDto;
    }

    @Override
    public ClientDTO getClientBydId(Long id) {
        ClientEntity client = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Le client n'existe pas"));
        ClientDTO clientDTO = ClientMapper.INSTANCE.clientEntityToClientDTO(client);
        return clientDTO;
    }

    @Override
    public void deleteClientBydId(Long id) {
        clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Le client n'existe pas"));
        clientRepository.deleteById(id);
    }

    @Override
    public ClientDTO updateAll(Long id, Client client) {
        ClientEntity clientEntity = ClientMapper.INSTANCE.clientToClientEntity(client);
        ClientDTO clientDTO = ClientMapper.INSTANCE.clientEntityToClientDTO(clientRepository.save(clientEntity));
        return clientDTO;
    }

    @Override
    public ClientDTO update(Long id, Client client) throws IllegalAccessException {
        ClientEntity clientEntity = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Le client n'existe pas"));
        Util.updateClientEntityFromClient(client, clientEntity);
        clientRepository.save(clientEntity);
        ClientDTO clientDTO = ClientMapper.INSTANCE.clientEntityToClientDTO(clientEntity);
        return clientDTO;
    }


}
