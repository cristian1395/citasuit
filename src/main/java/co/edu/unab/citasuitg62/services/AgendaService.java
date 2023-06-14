package co.edu.unab.citasuitg62.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.citasuitg62.models.AgendaModel;
import co.edu.unab.citasuitg62.repositories.AgendaRepository;

@Service
public class AgendaService {
    @Autowired
    AgendaRepository agendaRepository;

    public List<AgendaModel> getAllAgendas(){
        List<AgendaModel> agendas = agendaRepository.findAll();
        agendas.sort(Comparator.comparing(AgendaModel::getFecha));
        return agendas;
        }

    public Optional<AgendaModel> getAgendaById(String id){
        return agendaRepository.findById(id);
        }

    public AgendaModel saveAgenda(AgendaModel agenda) {
            return agendaRepository.save(agenda);
        }

    public String deleteAgendaById(String id) {
        if (agendaRepository.existsById(id)) {
                agendaRepository.deleteById(id);
                return "Agenda eliminada";
        } else {
                return "No existe Id de Agenda";
            }
        }

    public void deleteAllAgendas() {
        agendaRepository.deleteAll();
        }
}
