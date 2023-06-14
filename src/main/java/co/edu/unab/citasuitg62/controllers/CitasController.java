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

import co.edu.unab.citasuitg62.models.CitasModel;
import co.edu.unab.citasuitg62.services.CitasService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/cita")
public class CitasController {
    @Autowired
    CitasService citasService;

    @PostMapping
    public CitasModel guardarCita(@RequestBody CitasModel cita) {
        return citasService.saveCita(cita);
    }

    @GetMapping
    public List<CitasModel> getAllCitas() {
        return citasService.getAllCitas();
    }

    @GetMapping(path = "/{id}")
    public Optional<CitasModel> getCitaById(@PathVariable("id") String id){
        return citasService.getCitasById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCitaById(@PathVariable("id") String id) {
        return citasService.deleteCitaById(id);
    }

    @DeleteMapping()
    public void deleteAllCitas() {
        citasService.deleteAllCitas();
    }
    
}
