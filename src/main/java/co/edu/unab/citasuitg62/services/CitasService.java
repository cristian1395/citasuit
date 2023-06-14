package co.edu.unab.citasuitg62.services;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.citasuitg62.models.CitasModel;
import co.edu.unab.citasuitg62.repositories.CitasRepository;

@Service
public class CitasService {
    @Autowired
    CitasRepository citasRepository;

    public List<CitasModel> getAllCitas(){
        List<CitasModel> citalist = citasRepository.findAll();
        citalist.sort(Comparator.comparing(CitasModel::getHora));
        return citalist;
        }

    public Optional<CitasModel> getCitasById(String id){
        return citasRepository.findById(id);
        }

    public CitasModel saveCita(CitasModel cita) {
            return citasRepository.save(cita);
        }

    public String deleteCitaById(String id) {
        if (citasRepository.existsById(id)) {
                citasRepository.deleteById(id);
                return "Cita eliminada";
        } else {
                return "no existe Id de Cita";
            }
        }

    public void deleteAllCitas() {
        citasRepository.deleteAll();
        }
    
}
