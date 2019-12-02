/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kproveedor;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Proveedor implements Serializable{
    
    private int idProveedor;
    private String nombre;
    private String rfc;
    private String direccion;
    private String ciudad;
    private String telefono;
    private String observaciones;
    private int idEstatus;
    
    public Proveedor(){
        
    }

    public Proveedor(Proveedor proveedor) {
        this.idProveedor = proveedor.idProveedor;
        this.nombre = proveedor.nombre;
        this.rfc = proveedor.rfc;
        this.direccion = proveedor.direccion;
        this.ciudad = proveedor.ciudad;
        this.telefono = proveedor.telefono;
        this.observaciones = proveedor.observaciones;
        this.idEstatus = proveedor.idEstatus;
    }
    
    

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

   
    
}
