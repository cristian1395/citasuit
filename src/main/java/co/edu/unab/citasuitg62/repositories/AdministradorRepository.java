package co.edu.unab.citasuitg62.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.unab.citasuitg62.models.AdministradorModel;

@Repository
public interface AdministradorRepository extends MongoRepository<AdministradorModel, String>{
    
}
