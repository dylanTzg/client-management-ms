package com.classe.clientmanagementms.controller;

import com.classe.clientmanagementms.dto.ClientDTO;
import com.classe.clientmanagementms.dto.CreationClientDTO;
import com.classe.clientmanagementms.entity.ClientEntity;
import com.classe.clientmanagementms.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ClientEntity create(@RequestBody CreationClientDTO creationClientDTO) {
        return  clientService.create(creationClientDTO);
    }


    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Set<ClientDTO> getAllClients() {
        return  clientService.getAllClients();
    }


    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ClientDTO getClientById(@PathVariable Long id){
        return clientService.getClientBydId(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteClientById(@PathVariable Long id){
        clientService.deleteClientBydId(id);
    }

}
