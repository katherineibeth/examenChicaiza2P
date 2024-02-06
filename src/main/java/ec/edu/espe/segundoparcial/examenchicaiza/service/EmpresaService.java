package ec.edu.espe.segundoparcial.examenchicaiza.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.segundoparcial.examenchicaiza.domain.Empresa;
import ec.edu.espe.segundoparcial.examenchicaiza.repository.EmpresaRepository;

@Service
public class EmpresaService {
    
    private final EmpresaRepository empresaRepository; 

    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    public Optional<Empresa> obtenerEmpresaPorRuc(String ruc) {
        return empresaRepository.findByRuc(ruc);
    }

    public Empresa crearEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }
}
