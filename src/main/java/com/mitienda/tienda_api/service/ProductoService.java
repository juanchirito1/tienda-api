
package com.mitienda.tienda_api.service;
import com.mitienda.tienda_api.model.Producto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    private final List<Producto> productos = new ArrayList<>(Arrays.asList(
            new Producto(1L, "Laptop", 2500.0, "Electronica"),
            new Producto(2L, "Mouse", 80.0, "Electronica"),
            new Producto(3L, "Escritorio", 450.0, "Muebles")
    ));
    
    public List<Producto> listar(){
        return productos;
    }
    
    public Producto buscarPorId(Long id){
        return productos.stream()
                .filter(p->p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public Producto crear(Producto nuevo){
        productos.add(nuevo);
        return nuevo;
    }
    
    public Producto actualizar(Long id, Producto actualizado){
        for(int i =0; i <productos.size(); i++ ){
            if(productos.get(i).getId().equals(id)){
                productos.set(i, actualizado);
                return actualizado;
            }
        }
        return null;
    }
    
    public boolean eliminar(Long id){
        return productos.removeIf(p->p.getId().equals(id));
    }
}
