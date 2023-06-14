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

import co.edu.unab.citasuitg62.models.AdministradorModel;
import co.edu.unab.citasuitg62.services.AdministradorService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/administrador")
public class AdministradorController {
    @Autowired
    AdministradorService administradorService;

    @PostMapping
    public AdministradorModel guardarAdministrador(@RequestBody AdministradorModel administrador) {
        return administradorService.saveAdministrador(administrador);
    }

    @GetMapping
    public List<AdministradorModel> getAllAdministradores() {
        return administradorService.getAllAdministradores();
    }

    @GetMapping(path = "/{id}")
    public Optional<AdministradorModel> getAgendaById(@PathVariable("id") String id){
        return administradorService.getAdministradorById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteAdministradorById(@PathVariable("id") String id) {
        return administradorService.deleteAdministradorById(id);
    }

    @DeleteMapping()
    public void deleteAllAdministradores() {
        administradorService.deleteAllAdministradores();
    }
    
}
