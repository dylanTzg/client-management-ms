package com.classe.clientmanagementms.service;

import com.classe.clientmanagementms.dto.ClientDTO;
import com.classe.clientmanagementms.entity.ClientEntity;
import com.classe.clientmanagementms.mapper.ClientMapper;
import com.classe.clientmanagementms.model.Client;
import com.classe.clientmanagementms.repository.ClientRepository;
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
        ClientEntity client = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"Le client n'existe pas"));
        ClientDTO clientDTO = ClientMapper.INSTANCE.clientEntityToClientDTO(client);
        return clientDTO;
    }
    @Override
    public void deleteClientBydId(Long id) {
        clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"Le client n'existe pas"));;
        clientRepository.deleteById(id);
    }

}
