package co.edu.unab.citasuitg62.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.citasuitg62.models.PacienteModel;
import co.edu.unab.citasuitg62.repositories.PacienteRepository;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienterRepository;

    public List<PacienteModel> getAllPacientes(){
        List<PacienteModel> pacientes = pacienterRepository.findAll();
        pacientes.sort(Comparator.comparing(PacienteModel::getIdPaciente));
        return pacientes;
        }

    public Optional<PacienteModel> getPacienteById(String id){
        return pacienterRepository.findById(id);
        }

    public PacienteModel savePaciente(PacienteModel paciente) {
            paciente.setTipoAfiliacion(paciente.getTipoAfiliacion().toLowerCase());
            return pacienterRepository.save(paciente);
        }

    public String deletePacienteById(String id) {
        if (pacienterRepository.existsById(id)) {
                pacienterRepository.deleteById(id);
                return "Paciente eliminado";
        } else {
                return "no existe Id";
            }
        }

    public void deleteAllPacientes() {
        pacienterRepository.deleteAll();
        }
            
}
