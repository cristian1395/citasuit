package co.edu.unab.citasuitg62.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.unab.citasuitg62.models.Usuario1Model;

@Repository
public interface Usuario1Repository extends MongoRepository<Usuario1Model, String> {

}
