package com.classe.clientmanagementms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Table(name = "client")
@Entity
@Data
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column()
    private String prenom;  // firstName

    @Column()
    private String nom;  // lastName

    @Column(unique = true)
    private String email;

    @Column()
    private String motDePasse;  // password

    @Column()
    private String telephone;

    @Column()
    private String adresse;  // address

    @Column()
    private LocalDate dateNaissance;  // date of birth

    @Column()
    private String profession;  // occupation

    @Column()
    private String genre;  // gender


}
