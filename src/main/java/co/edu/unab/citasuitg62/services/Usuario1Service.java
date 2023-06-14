package co.edu.unab.citasuitg62.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.citasuitg62.models.Usuario1Model;
import co.edu.unab.citasuitg62.repositories.Usuario1Repository;

@Service
public class Usuario1Service {
    @Autowired
    Usuario1Repository usuario1Repository;

    public Usuario1Model saveUsuario(Usuario1Model usuario1) {
        usuario1.setNombre(usuario1.getNombre().toLowerCase());
        usuario1.setApellido(usuario1.getApellido().toLowerCase());
        usuario1.setTipoDocumento(usuario1.getTipoDocumento().toUpperCase());
        usuario1.setEstado(usuario1.getEstado().toLowerCase());
        usuario1.setGenero(usuario1.getGenero().toUpperCase());
        usuario1.setCorreo(usuario1.getCorreo().toLowerCase());
        usuario1.setTipoUsuario(usuario1.getTipoUsuario().toLowerCase());
        return usuario1Repository.save(usuario1);
    }

    public List<Usuario1Model> getAllUsuario() {
        List<Usuario1Model> usuarios = usuario1Repository.findAll();
        usuarios.sort(Comparator.comparing(Usuario1Model::getNombre));
        return usuarios;
    }

    public Optional<Usuario1Model> getUsuarioById(String id){
        return usuario1Repository.findById(id);
    }

    public String deleteUsuario1ById(String id) {
        if (usuario1Repository.existsById(id)) {
            usuario1Repository.deleteById(id);
            return "Usuario eliminado";
        } else {
            return "no existe Id";
        }
    }

    public void deleteAllUsuarios() {
        usuario1Repository.deleteAll();
    }
}
