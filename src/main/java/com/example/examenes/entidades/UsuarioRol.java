package com.example.examenes.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class UsuarioRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioRolId;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    @JsonBackReference("ROL")
    @ManyToOne
    private Rol rol;
}
