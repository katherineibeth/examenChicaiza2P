package ec.edu.espe.segundoparcial.examenchicaiza.cotroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.segundoparcial.examenchicaiza.domain.Empresa;
import ec.edu.espe.segundoparcial.examenchicaiza.service.EmpresaService;

@RestController
@RequestMapping("/api/v1/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/{ruc}")
    public ResponseEntity<Optional<Empresa>> obtenerEmpresaPorRuc(@PathVariable String ruc) {
        Optional<Empresa> empresa = empresaService.obtenerEmpresaPorRuc(ruc);
        return ResponseEntity.ok(empresa);
    }

    @PostMapping("/crear")
    public ResponseEntity<Empresa> crearEmpresa(@RequestBody Empresa empresa) {
        Empresa nuevaEmpresa = empresaService.crearEmpresa(empresa);
        return ResponseEntity.ok(nuevaEmpresa);
    }

}
