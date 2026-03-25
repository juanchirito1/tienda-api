
package com.mitienda.tienda_api.controller;

import com.mitienda.tienda_api.model.Producto;
import java.util.ArrayList;
import java.util.Arrays;
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
   
    private final List<Producto> productos = new ArrayList<>(Arrays.asList(
    new Producto(1L, "Laptop",     2500.0, "Electronica"),
    new Producto(2L, "Mouse",        80.0, "Electronica"),
    new Producto(3L, "Escritorio",  450.0, "Muebles")
));
    
    @GetMapping
    public List<Producto>listar(){
        return productos;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Long id) {
    return productos.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto nuevo){
        productos.add(nuevo);
        return ResponseEntity.status(201).body(nuevo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto actualizado){
        for(int i = 0; i<productos.size(); i++){
            if(productos.get(i).getId().equals(id)){
                productos.set(i, actualizado);
                return ResponseEntity.ok(actualizado);
            }
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> eliminar(@PathVariable Long id){
        boolean eliminado = productos.removeIf(p->p.getId().equals(id));
        if(eliminado){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
