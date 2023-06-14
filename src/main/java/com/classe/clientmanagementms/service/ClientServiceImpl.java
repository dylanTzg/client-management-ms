package com.classe.clientmanagementms.service;

import com.classe.clientmanagementms.dto.ClientDTO;
import com.classe.clientmanagementms.dto.CreationClientDTO;
import com.classe.clientmanagementms.entity.ClientEntity;
import com.classe.clientmanagementms.mapper.ClientMapper;
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
    public ClientEntity create(CreationClientDTO creationClientDTO) {
        ClientEntity clientEntity = ClientMapper.INSTANCE.clientDTOtoClient(creationClientDTO);
        clientRepository.save(clientEntity);
        return clientEntity;
    }

    @Override
    public Set<ClientDTO> getAllClients() {
        Set<ClientEntity> clients = StreamSupport.stream(clientRepository.findAll().spliterator(), false).collect(Collectors.toSet());
        Set<ClientDTO> clientsDto = ClientMapper.INSTANCE.clientToGetClientDTO(clients);
        return clientsDto;
    }

    @Override
    public ClientDTO getClientBydId(Long id) {
        ClientEntity client = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"Le client n'existe pas"));
        ClientDTO clientDTO = ClientMapper.INSTANCE.clientToGetClientDTO(client);
        return clientDTO;
    }
    @Override
    public void deleteClientBydId(Long id) {
        clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"Le client n'existe pas"));;
        clientRepository.deleteById(id);
    }

}
