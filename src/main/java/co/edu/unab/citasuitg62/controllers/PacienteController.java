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

import co.edu.unab.citasuitg62.models.PacienteModel;
import co.edu.unab.citasuitg62.services.PacienteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/paciente")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public PacienteModel guardarPaciente(@RequestBody PacienteModel paciente) {
        return pacienteService.savePaciente(paciente);
    }

    @GetMapping
    public List<PacienteModel> getAllPacientes() {
        return pacienteService.getAllPacientes();
    }

    @GetMapping(path = "/{id}")
    public Optional<PacienteModel> getPacienteById(@PathVariable("id") String id){
        return pacienteService.getPacienteById(id);
    }

    @DeleteMapping("/{id}")
    public String deletePacienteById(@PathVariable("id") String id) {
        return pacienteService.deletePacienteById(id);
    }

    @DeleteMapping()
    public void deleteAllPacientes() {
        pacienteService.deleteAllPacientes();
    }
    
}
