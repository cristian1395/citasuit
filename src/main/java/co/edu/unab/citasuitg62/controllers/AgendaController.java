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

import co.edu.unab.citasuitg62.models.AgendaModel;
import co.edu.unab.citasuitg62.services.AgendaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/agenda")
public class AgendaController {
    @Autowired
    AgendaService agendaService;

    @PostMapping
    public AgendaModel guardarAgenda(@RequestBody AgendaModel agenda) {
        return agendaService.saveAgenda(agenda);
    }

    @GetMapping
    public List<AgendaModel> getAllAgendas() {
        return agendaService.getAllAgendas();
    }

    @GetMapping(path = "/{id}")
    public Optional<AgendaModel> getAgendaById(@PathVariable("id") String id){
        return agendaService.getAgendaById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteAgendaById(@PathVariable("id") String id) {
        return agendaService.deleteAgendaById(id);
    }

    @DeleteMapping()
    public void deleteAllAgendas() {
        agendaService.deleteAllAgendas();
    }
    
}
