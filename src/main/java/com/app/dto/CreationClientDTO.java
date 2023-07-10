package com.app.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
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

