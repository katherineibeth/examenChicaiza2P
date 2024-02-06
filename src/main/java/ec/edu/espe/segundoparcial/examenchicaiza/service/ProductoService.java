package ec.edu.espe.segundoparcial.examenchicaiza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.segundoparcial.examenchicaiza.domain.Comentario;
import ec.edu.espe.segundoparcial.examenchicaiza.domain.Producto;
import ec.edu.espe.segundoparcial.examenchicaiza.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository; 

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }


    public List<Producto> listarProductosPorRucOrdenadosPorNombre(String rucEmpresa) {
        return productoRepository.findByRucEmpresaOrderByDescripcion(rucEmpresa);
    }

    public Optional<Producto> obtenerProductoPorCodigo(String codigo) {
        return productoRepository.findById(codigo);
    }

    public List<Comentario> obtenerComentariosDeProductoPorCodigo(String codigo) {
        Optional<Producto> productoOptional = productoRepository.findById(codigo);
        return productoOptional.map(Producto::getComentarios).orElse(null);
    }

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto agregarComentarioAProducto(String codigoProducto, Comentario comentario) {
        Optional<Producto> productoOptional = productoRepository.findById(codigoProducto);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            List<Comentario> comentarios = producto.getComentarios();
            comentarios.add(comentario);
            producto.setComentarios(comentarios);
            return productoRepository.save(producto);
        }
        return null;
    }

}
