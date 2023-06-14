package com.classe.clientmanagementms.service;

import com.classe.clientmanagementms.dto.ClientDTO;
import com.classe.clientmanagementms.dto.CreationClientDTO;
import com.classe.clientmanagementms.entity.ClientEntity;
import com.classe.clientmanagementms.model.Client;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
@Service
public interface ClientService {

    public ClientDTO create(Client client);

    public Set<ClientDTO> getAllClients();

    public ClientDTO getClientBydId(Long id);

    public void deleteClientBydId(Long id);

    ClientDTO updateAll(Long id, Client client);

    ClientDTO update(Long id, Client client) throws IllegalAccessException;
}
