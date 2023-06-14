package com.classe.clientmanagementms.repository;

import com.classe.clientmanagementms.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public  interface ClientRepository extends CrudRepository<ClientEntity,Long> {
}
