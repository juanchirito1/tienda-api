
package com.mitienda.tienda_api.service;
import com.mitienda.tienda_api.model.Producto;
import com.mitienda.tienda_api.repository.ProductoRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
   private final ProductoRepository repository;
   
   public ProductoService(ProductoRepository repository){
       this.repository = repository;
   }
   public List<Producto> listar(){
       return repository.findAll();
   }
   public Producto buscarPorId(Long id){
       return repository.findById(id).orElse(null);
   }
   public Producto crear(Producto nuevo){
       return repository.save(nuevo);
   }
   public Producto actualizar(Long id, Producto actualizado){
       if(!repository.existsById(id)) return null;
       actualizado.setId(id);
       return repository.save(actualizado);
   }
   public boolean eliminar(Long id){
       if(!repository.existsById(id))return false;
       repository.deleteById(id);
       return true;
   }
}
