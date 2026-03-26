
package com.mitienda.tienda_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;
    
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Producto> productos;
    
    public Categoria(){}
    
    public Categoria(Long id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    public Long getId(){return id;}
    public String getNombre(){return nombre;}
    public List<Producto> getProductos(){return productos;}
    
    public void setId(Long id){this.id = id;}
    public void setNombre(String nombre){this.nombre=nombre;}
    public void setProductos(List<Producto> productos){this.productos = productos;}
}
