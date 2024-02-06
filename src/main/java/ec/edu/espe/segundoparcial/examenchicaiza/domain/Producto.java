package ec.edu.espe.segundoparcial.examenchicaiza.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "productos")
public class Producto {

    @Id
    private String codigo;  

    @Field("ruc_empresa")
    private String rucEmpresa;

    private String descripcion;
    private double precio;

    private List<Comentario> comentarios;

    @Version
    private Long version;

    public Producto(String codigo, String rucEmpresa, String descripcion, double precio, List<Comentario> comentarios) {
        this.codigo = codigo;
        this.rucEmpresa = rucEmpresa;
        this.descripcion = descripcion;
        this.precio = precio;
        this.comentarios = comentarios;
    }

  

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Producto other = (Producto) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", rucEmpresa=" + rucEmpresa + ", descripcion=" + descripcion
                + ", precio=" + precio + ", comentarios=" + comentarios + "]";
    }

}
