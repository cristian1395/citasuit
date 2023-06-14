package co.edu.unab.citasuitg62.models;

import java.time.LocalDate;

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
@Document("usuarios")

public class Usuario1Model {
    @Id
    private String idUsuario;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private int numeroDocumento;
    private LocalDate fechaNacimiento;
    private String estado;
    private String genero;
    private int edad;
    private String correo;
    private String contraseña;
    private String tipoUsuario;

}
