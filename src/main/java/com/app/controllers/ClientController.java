package com.app.controllers;

import com.app.dto.ClientDTO;
import com.app.dto.CreationClientDTO;
import com.app.mappers.ClientMapper;
import com.app.services.ClientService;
import com.app.models.Client;
import com.app.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ClientDTO create(@RequestBody CreationClientDTO creationClientDTO) {
        Client client = ClientMapper.INSTANCE.creationClientDtoToClientModel(creationClientDTO);
        return clientService.create(client);
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


    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void updateAll(@PathVariable Long id ,@RequestBody CreationClientDTO creationClientDTO){
        Client client = ClientMapper.INSTANCE.creationClientDtoToClientModel(creationClientDTO);
        clientService.updateAll(id,client);
    }



    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@PathVariable Long id , @RequestBody Map<String, Object> clientPatch) throws IllegalAccessException {
        Client client = new Client();
        Util.updateClientEntityFromClient(clientPatch,client);
        clientService.update(id, client);
    }



}
