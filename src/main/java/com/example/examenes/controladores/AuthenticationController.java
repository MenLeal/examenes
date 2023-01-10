package com.example.examenes.controladores;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RestController;

import com.example.examenes.configuraciones.JwtUtils;
import com.example.examenes.entidades.JwtRequest;
import com.example.examenes.entidades.JwtResponse;
import com.example.examenes.entidades.Usuario;
import com.example.examenes.servicios.impl.UserDetailsImp;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsImp userDetailsImp;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/actual-usuario")
    public Usuario obtenerUsuarioActual(Principal principal) {
        return (Usuario) this.userDetailsImp.loadUserByUsername(principal.getName());
    }

    @PostMapping(value = "/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authentication(jwtRequest.getUsername(), jwtRequest.getPassword());

        } catch (Exception exception) {
            exception.printStackTrace();
            throw new Exception("Usuario no autenticado");
        }

        UserDetails userDetails = this.userDetailsImp.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authentication(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException disabledException) {
            throw new Exception("USUARIO DESHABILITAD0 " + disabledException.getMessage());

        } catch (BadCredentialsException badCredentialsException) {
            throw new Exception("CREDENCIALES INVALIDAS " + badCredentialsException.getMessage());

        }
    }

}
