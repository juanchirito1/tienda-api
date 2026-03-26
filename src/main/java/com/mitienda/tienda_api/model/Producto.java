
package com.mitienda.tienda_api.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message="El nombre no puede estar vacío")
    @Size(min=2, max=100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;
    
    @Positive(message = "El precio debe ser mayor a 0")
    private double precio;
    
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    
    public Producto(Long id, String nombre, double precio, Categoria categoria){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }
    public Long getId(){return id;}
    public String getNombre(){return nombre;}
    public double getPrecio(){return precio;}
    public Categoria getCategoria(){return categoria;}
    
    public Producto(){}
    
    public void setId(Long id){this.id=id;}
    public void setNombre(String nombre){this.nombre=nombre;}
    public void setPrecio(double precio){this.precio=precio;}
    public void setCategoria(Categoria categoria){this.categoria=categoria;}
    
}
