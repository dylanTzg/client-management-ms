package com.classe.clientmanagementms.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreationClientDTO {

    private String prenom;
    private String nom;
    private String email;
    private String motDePasse;
    private String telephone;
    private String adresse;
    private LocalDate dateNaissance;
    private String profession;
    private String genre;
}

