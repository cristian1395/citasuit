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

import co.edu.unab.citasuitg62.models.MedicoModel;
import co.edu.unab.citasuitg62.services.MedicoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/medico")
public class MedicoController {
    @Autowired
    MedicoService medicoService;

    @PostMapping
    public MedicoModel guardarMedico(@RequestBody MedicoModel medico) {
        return medicoService.saveMedico(medico);
    }

    @GetMapping
    public List<MedicoModel> getAllMedicos() {
        return medicoService.getAllMedicos();
    }

    @GetMapping(path = "/{id}")
    public Optional<MedicoModel> getMedicoById(@PathVariable("id") String id){
        return medicoService.getMedicoById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteMedicoById(@PathVariable("id") String id) {
        return medicoService.deleteMedicoById(id);
    }

    @DeleteMapping()
    public void deleteAllMedicos() {
        medicoService.deleteAllMedicos();
    }
    
}
