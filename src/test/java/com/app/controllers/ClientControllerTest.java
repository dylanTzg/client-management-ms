package com.app.controllers;

import com.app.dto.ClientDTO;
import com.app.dto.CreationClientDTO;
import com.app.mappers.ClientMapper;
import com.app.models.Client;
import com.app.services.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@WebMvcTest(ClientController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @Autowired
    private ObjectMapper objectMapper;

    CreationClientDTO creationClientDTO = null;
    ClientDTO clientDTO = null;

    @BeforeEach
    public void setUp() throws Exception {
        creationClientDTO = CreationClientDTO.builder()
                .prenom("prenom")
                .nom("nom")
                .email("email")
                .motDePasse("motDePasse")
                .telephone("telephone")
                .adresse("adresse")
                .dateNaissance(null)
                .profession("profession")
                .genre("genre")
                .build();
         clientDTO = ClientMapper.INSTANCE.creationClientDtoToClientDto(creationClientDTO);
    }

    @Test
    public void create() throws Exception {
        given(clientService.create(any(Client.class))).willReturn(clientDTO);

        ResultActions response = mockMvc.perform(
                MockMvcRequestBuilders.post("/clients")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(creationClientDTO))
        );
        response.andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
