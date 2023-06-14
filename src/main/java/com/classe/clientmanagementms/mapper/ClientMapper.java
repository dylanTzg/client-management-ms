package com.classe.clientmanagementms.mapper;

import com.classe.clientmanagementms.dto.ClientDTO;
import com.classe.clientmanagementms.dto.CreationClientDTO;
import com.classe.clientmanagementms.entity.ClientEntity;
import com.classe.clientmanagementms.model.Client;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "id", ignore = true)
        // Ignore the 'id' property during mapping
    Client creationClientDtoToClientModel(CreationClientDTO creationClientDTO);

    ClientEntity clientModelToClientEntity(Client client);

    ClientDTO clientToClientDTO(Client client);

    Set<ClientDTO> clientsToClientDTOs(Set<Client> clients);

    Set<ClientDTO> clientEntitiesToClientDTOs(Set<ClientEntity> clientEntities);

    ClientDTO clientEntityToClientDTO(ClientEntity clientEntity);

    ClientEntity clientToClientEntity(Client client);

}
