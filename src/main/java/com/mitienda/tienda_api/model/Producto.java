
package com.mitienda.tienda_api.model;


public class Producto {
    private Long id;
    private String nombre;
    private double precio;
    private String categoria;
    
    public Producto(Long id, String nombre, double precio, String categoria){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }
    public Long getId(){return id;}
    public String getNombre(){return nombre;}
    public double getPrecio(){return precio;}
    public String getCategoria(){return categoria;}
    
    public Producto(){}
    
    public void setId(Long id){this.id=id;}
    public void setNombre(String nombre){this.nombre=nombre;}
    public void setPrecio(double precio){this.precio=precio;}
    public void setCategoria(String categoria){this.categoria=categoria;}
    
}
