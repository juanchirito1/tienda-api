package com.mitienda.tienda_api.service;

import com.mitienda.tienda_api.model.Categoria;
import com.mitienda.tienda_api.model.Producto;
import com.mitienda.tienda_api.repository.CategoriaRepository;
import com.mitienda.tienda_api.repository.ProductoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    private final ProductoRepository repository;
    private final CategoriaRepository categoriaRepository;

    public ProductoService(ProductoRepository repository, CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Producto> listar() {
        return repository.findAll();
    }

    public Producto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Producto crear(Producto nuevo) {
        if (nuevo.getCategoria() != null && nuevo.getCategoria().getId() != null) {
            Categoria categoria = categoriaRepository.findById(nuevo.getCategoria().getId())
                    .orElse(null);
            nuevo.setCategoria(categoria);
        }
        return repository.save(nuevo);
    }

    public Producto actualizar(Long id, Producto actualizado) {
        if (!repository.existsById(id)) {
            return null;
        }
        if (actualizado.getCategoria() != null && actualizado.getCategoria().getId() != null) {
            Categoria categoria = categoriaRepository.findById(actualizado.getCategoria().getId())
                    .orElse(null);
            actualizado.setCategoria(categoria);
        }
        actualizado.setId(id);
        return repository.save(actualizado);
    }

    public boolean eliminar(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
