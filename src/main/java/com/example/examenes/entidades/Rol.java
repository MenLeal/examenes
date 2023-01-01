package com.example.examenes.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rol")

public class Rol {
    @Id
    private Long rolId;

    private String nombre;


    @JsonManagedReference("ROL")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "rol")
    private Set<UsuarioRol> usuario_roles = new HashSet<>();
}
