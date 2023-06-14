package com.classe.clientmanagementms.mapper;

import com.classe.clientmanagementms.dto.CreationClientDTO;
import com.classe.clientmanagementms.dto.ClientDTO;
import com.classe.clientmanagementms.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    CreationClientDTO clientToClientDTO(ClientEntity entity);

    ClientDTO clientToGetClientDTO (ClientEntity entity);
    Set<ClientDTO> clientToGetClientDTO (Set <ClientEntity> entities);

    ClientEntity clientDTOtoClient(CreationClientDTO dto);


}
