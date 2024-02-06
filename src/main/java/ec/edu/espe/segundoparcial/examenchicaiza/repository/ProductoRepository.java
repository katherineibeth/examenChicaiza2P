package ec.edu.espe.segundoparcial.examenchicaiza.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.segundoparcial.examenchicaiza.domain.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String>{
    List<Producto> findByRucEmpresaOrderByDescripcion(String rucEmpresa);
}
