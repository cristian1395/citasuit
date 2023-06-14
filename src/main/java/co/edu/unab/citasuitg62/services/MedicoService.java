package co.edu.unab.citasuitg62.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.citasuitg62.models.MedicoModel;
import co.edu.unab.citasuitg62.repositories.MedicoRepository;

@Service
public class MedicoService {
    @Autowired
    MedicoRepository medicoRepository;

    public List<MedicoModel> getAllMedicos(){
        List<MedicoModel> medicos = medicoRepository.findAll();
        medicos.sort(Comparator.comparing(MedicoModel::getIdMedico));
        return medicos;
        }

    public Optional<MedicoModel> getMedicoById(String id){
        return medicoRepository.findById(id);
        }

    public MedicoModel saveMedico(MedicoModel medico) {
            medico.setEspecializacion(medico.getEspecializacion().toLowerCase());
            return medicoRepository.save(medico);
        }

    public String deleteMedicoById(String id) {
        if (medicoRepository.existsById(id)) {
                medicoRepository.deleteById(id);
                return "Médico eliminado";
        } else {
                return "No existe Id de Medico";
            }
        }

    public void deleteAllMedicos() {
        medicoRepository.deleteAll();
        }
    
}
