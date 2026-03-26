
package com.mitienda.tienda_api.controller;

import com.mitienda.tienda_api.model.Categoria;
import com.mitienda.tienda_api.service.CategoriaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService service;
    
    public CategoriaController(CategoriaService service){
        this.service=service;
    }  
    @GetMapping
    public List<Categoria> listar(){
        return service.listar();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id){
        Categoria c = service.buscarPorId(id);
        return c != null ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Categoria> crear(@Valid @RequestBody Categoria nueva){
        return ResponseEntity.status(201).body(service.crear(nueva));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Long id, @Valid @RequestBody Categoria actualizada){
        Categoria c = service.actualizar(id, actualizada);
        return c != null ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        return service.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
