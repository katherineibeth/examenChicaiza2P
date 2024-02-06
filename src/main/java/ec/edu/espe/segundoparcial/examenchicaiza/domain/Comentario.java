package ec.edu.espe.segundoparcial.examenchicaiza.domain;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Comentario {

    private int calificacion;  
    private String comentario; 
    private String usuario;  
    private Date fechaComentario;  

    public Comentario(int calificacion, String comentario, String usuario, Date fechaComentario) {
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.usuario = usuario;
        this.fechaComentario = fechaComentario;
    }

}
