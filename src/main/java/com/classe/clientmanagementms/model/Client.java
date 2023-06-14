package com.classe.clientmanagementms.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Client {
    private Long id;
    private String prenom;
    private String nom;
    private String email;
    private String telephone;
    private String adresse;
    private LocalDate dateNaissance;
    private String profession;
    private String motDePasse;
    private String genre;
}
