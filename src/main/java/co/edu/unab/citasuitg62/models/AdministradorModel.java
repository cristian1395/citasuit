package co.edu.unab.citasuitg62.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document("administradores")
public class AdministradorModel {
    @Id
    private String idAdministrador;
    private String idUsuario;
}
