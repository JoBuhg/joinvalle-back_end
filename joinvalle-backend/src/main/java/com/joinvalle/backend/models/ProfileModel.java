package com.joinvalle.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class ProfileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private AppUserModel user;

    private String description;
    private String phone;

    private Boolean aproved = false;
    private Boolean rejected = false;

    // Métodos auxiliares (apesar do @Data)
    // Exemplo: um perfil pode ser o criador de vários eventos
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<EventModel> eventos;

    // Exemplo opcional: contatos associados ao perfil
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<ContactModel> contatos;

}
