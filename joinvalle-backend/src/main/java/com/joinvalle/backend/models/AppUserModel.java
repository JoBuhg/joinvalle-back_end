package com.joinvalle.backend.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import lombok.Data;

@Data
@Entity
public class AppUserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String cpf;
    private LocalDate birthDate;
    private String local; // todo: confirmar tipo depois
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private ProfileModel profile;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<NotificationModel> notifications;

    // métodos
    // getPerfil
    // getNotificações
}