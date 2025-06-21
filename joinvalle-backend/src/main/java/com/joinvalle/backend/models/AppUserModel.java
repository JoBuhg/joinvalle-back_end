package com.joinvalle.backend.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
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
    private String local; //todo: confirmar tipo depois

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private ProfileModel profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<NotificationModel> notifications;

    // Métodos auxiliares (mesmo com Lombok, você pode querer deixá-los explícitos):

    public ProfileModel getPerfil() {
        return this.profile;
    }

    public List<NotificationModel> getNotificacoes() {
        return this.notifications;
    }
}
