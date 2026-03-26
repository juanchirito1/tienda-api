
package com.mitienda.tienda_api.controller;
import com.mitienda.tienda_api.service.ProductoService;
import com.mitienda.tienda_api.model.Producto;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
@RestController
@RequestMapping("/productos")

public class ProductoController {
   
    private final ProductoService service;
    
    public ProductoController(ProductoService service){
        this.service = service;
    }
    @GetMapping
    public List<Producto> listar(){
        return service.listar();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Long id){
        Producto p = service.buscarPorId(id);
        return p != null ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Producto> crear (@Valid @RequestBody Producto nuevo){
        return ResponseEntity.status(201).body(service.crear(nuevo));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id,@Valid @RequestBody Producto actualizado){
        Producto p = service.actualizar(id, actualizado);
        return p != null ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        return service.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
