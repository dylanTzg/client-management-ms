package com.classe.clientmanagementms.service;

import com.classe.clientmanagementms.dto.ClientDTO;
import com.classe.clientmanagementms.dto.CreationClientDTO;
import com.classe.clientmanagementms.entity.ClientEntity;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface ClientService {

    public ClientEntity create(CreationClientDTO creationClientDTO);

    public Set<ClientDTO> getAllClients();

    public ClientDTO getClientBydId(Long id);

    void deleteClientBydId(Long id);
}
