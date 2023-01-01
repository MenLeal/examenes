package com.example.examenes;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.examenes.entidades.Rol;
import com.example.examenes.entidades.Usuario;
import com.example.examenes.entidades.UsuarioRol;
import com.example.examenes.servicios.UsuarioService;

@SpringBootApplication
public class ExamenesApplication implements CommandLineRunner{

	@Autowired
	UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(ExamenesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

/* Usuario usuario = new Usuario();
		
		usuario.setNombre("Raulito");
		usuario.setApellido("Meneses");
		usuario.setUsername("MENLEA");
		usuario.setPassword("null");
		usuario.setEmail("mau@mau.com");
		usuario.setTelefono("123456789");

		Rol rol = new Rol();
		rol.setRolId(1L);
		rol.setNombre("ADMIN");

		Set<UsuarioRol> usuarioRols = new HashSet<>();
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setUsuario(usuario);
		usuarioRol.setRol(rol);
		usuarioRols.add(usuarioRol);

		Usuario guardado = usuarioService.guardarUsuario(usuario, usuarioRols);
		System.out.println(guardado.getEmail());*/
		



	}

}
