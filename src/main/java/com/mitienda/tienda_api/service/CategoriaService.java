
package com.mitienda.tienda_api.service;

import com.mitienda.tienda_api.model.Categoria;
import com.mitienda.tienda_api.repository.CategoriaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private final CategoriaRepository repository;
    
    public CategoriaService(CategoriaRepository repository){
        this.repository=repository;
    }
    public List<Categoria> listar(){
        return repository.findAll();
    }
    public Categoria buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }
    public Categoria crear(Categoria nueva){
        return repository.save(nueva);
    }
    public Categoria actualizar(Long id, Categoria actualizada){
        if(!repository.existsById(id))return null;
        actualizada.setId(id);
        return repository.save(actualizada);
    }
    public boolean eliminar(Long id){
        if(!repository.existsById(id))return false;
        repository.deleteById(id);
        return true;
    }
}
