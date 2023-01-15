package com.example.examenes.servicios.impl;

import com.example.examenes.entidades.Usuario;
import com.example.examenes.entidades.UsuarioRol;
import com.example.examenes.repositorios.RolRepository;
import com.example.examenes.repositorios.UsuarioRepository;
import com.example.examenes.servicios.UsuarioService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioLocal != null) {
            System.out.println("Existe el usuario");
            throw new Exception("No tiene caso guardar ya que existe el usuario");
        } else {
            usuarioRoles.stream().forEach(usuarioRol -> rolRepository.save(usuarioRol.getRol()));
            usuario.getUsuario_roles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long uid) {
        usuarioRepository.deleteById(uid);
    }

}
