package co.edu.unab.citasuitg62.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.citasuitg62.models.AdministradorModel;
import co.edu.unab.citasuitg62.repositories.AdministradorRepository;

@Service
public class AdministradorService {
    @Autowired
    AdministradorRepository administradorRepository;

    public List<AdministradorModel> getAllAdministradores(){
        List<AdministradorModel> administradores = administradorRepository.findAll();
        administradores.sort(Comparator.comparing(AdministradorModel::getIdAdministrador));
        return administradores;
        }

    public Optional<AdministradorModel> getAdministradorById(String id){
        return administradorRepository.findById(id);
        }

    public AdministradorModel saveAdministrador(AdministradorModel administrador) {
            return administradorRepository.save(administrador);
        }

    public String deleteAdministradorById(String id) {
        if (administradorRepository.existsById(id)) {
                administradorRepository.deleteById(id);
                return "Administrador eliminado";
        } else {
                return "No existe Id de Administrador";
            }
        }

    public void deleteAllAdministradores() {
        administradorRepository.deleteAll();
        }
    
}
