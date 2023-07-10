package com.app.mappers;

import com.app.dto.ClientDTO;
import com.app.dto.CreationClientDTO;
import com.app.entities.ClientEntity;
import com.app.models.Client;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "id", ignore = true)
    Client creationClientDtoToClientModel(CreationClientDTO creationClientDTO);

    ClientEntity clientModelToClientEntity(Client client);

    ClientDTO clientToClientDTO(Client client);

    Set<ClientDTO> clientsToClientDTOs(Set<Client> clients);

    Set<ClientDTO> clientEntitiesToClientDTOs(Set<ClientEntity> clientEntities);

    ClientDTO clientEntityToClientDTO(ClientEntity clientEntity);

    ClientEntity clientToClientEntity(Client client);

    ClientDTO creationClientDtoToClientDto(CreationClientDTO creationClientDTO);
}
