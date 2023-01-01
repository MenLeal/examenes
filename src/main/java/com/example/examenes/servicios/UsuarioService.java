package com.example.examenes.servicios;

import com.example.examenes.entidades.Usuario;
import com.example.examenes.entidades.UsuarioRol;
import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long uid);
}
