package com.app.repositories;

import com.app.entities.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public  interface ClientRepository extends CrudRepository<ClientEntity,Long> {
}
