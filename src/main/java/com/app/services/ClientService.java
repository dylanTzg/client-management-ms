package com.app.services;

import com.app.dto.ClientDTO;
import com.app.models.Client;
import org.springframework.stereotype.Service;

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
