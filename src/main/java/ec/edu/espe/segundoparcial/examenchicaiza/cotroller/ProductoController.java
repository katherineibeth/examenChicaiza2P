package ec.edu.espe.segundoparcial.examenchicaiza.cotroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.segundoparcial.examenchicaiza.domain.Comentario;
import ec.edu.espe.segundoparcial.examenchicaiza.domain.Producto;
import ec.edu.espe.segundoparcial.examenchicaiza.service.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/listar/{rucEmpresa}")
    public ResponseEntity<List<Producto>> listarProductosPorRucOrdenadosPorNombre(@PathVariable String rucEmpresa) {
        List<Producto> productos = productoService.listarProductosPorRucOrdenadosPorNombre(rucEmpresa);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Optional<Producto>> obtenerProductoPorCodigo(@PathVariable String codigo) {
        Optional<Producto> producto = productoService.obtenerProductoPorCodigo(codigo);
        return ResponseEntity.ok(producto);
    }

    @GetMapping("/comentarios/{codigo}")
    public ResponseEntity<List<Comentario>> obtenerComentariosDeProductoPorCodigo(@PathVariable String codigo) {
        List<Comentario> comentarios = productoService.obtenerComentariosDeProductoPorCodigo(codigo);
        return ResponseEntity.ok(comentarios);
    }

    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.crearProducto(producto);
        return ResponseEntity.ok(nuevoProducto);
    }

    @PostMapping("/agregar-comentario/{codigoProducto}")
    public ResponseEntity<Producto> agregarComentarioAProducto(@PathVariable String codigoProducto, @RequestBody Comentario comentario) {
        Producto productoConComentario = productoService.agregarComentarioAProducto(codigoProducto, comentario);
        return ResponseEntity.ok(productoConComentario);
    }
}
