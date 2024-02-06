package ec.edu.espe.segundoparcial.examenchicaiza.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.segundoparcial.examenchicaiza.domain.Empresa;

public interface EmpresaRepository extends MongoRepository<Empresa, String>{
    Optional<Empresa> findByRuc(String ruc);
}
