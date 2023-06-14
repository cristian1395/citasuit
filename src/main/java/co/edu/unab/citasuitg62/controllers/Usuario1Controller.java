package co.edu.unab.citasuitg62.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.citasuitg62.models.Usuario1Model;
import co.edu.unab.citasuitg62.services.Usuario1Service;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/usuario")
public class Usuario1Controller {
    @Autowired
    Usuario1Service usuario1Service;

    @PostMapping()
    public Usuario1Model guardarUsuario(@RequestBody Usuario1Model usuario1) {
        return usuario1Service.saveUsuario(usuario1);
    }

    @GetMapping
    public List<Usuario1Model> getAllUsuarios() {
        return usuario1Service.getAllUsuario();
    }

    @GetMapping(path = "/{id}")
    public Optional<Usuario1Model> getUsuarioById(@PathVariable("id") String id){
        return usuario1Service.getUsuarioById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUsuarioById(@PathVariable("id") String id) {
        return usuario1Service.deleteUsuario1ById(id);
    }

    @DeleteMapping()
    public void deleteAllUsuarios() {
        usuario1Service.deleteAllUsuarios();
    }
}
