/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author usuario
 */
public class Usuarios implements Serializable {

    private int noUsuario;
    private String clave;
    private String pasaporte;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String telefono;
    private int idestatus;
    private Date fechaAuditoria;
     private int noRol;
     private String descripcionRol;
     private int noDepartamento;
     private String telefono2;
     private Integer noPersonalBm;
    public Usuarios() {
    }

    public Usuarios(int noUsuario, String clave, String pasaporte, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String telefono, int idestatus, Date fechaAuditoria, int noRol, String descripcionRol, int noDepartamento, String telefono2, Integer noPersonalBm) {
        this.noUsuario = noUsuario;
        this.clave = clave;
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.telefono = telefono;
        this.idestatus = idestatus;
        this.fechaAuditoria = fechaAuditoria;
        this.noRol = noRol;
        this.descripcionRol = descripcionRol;
        this.noDepartamento = noDepartamento;
        this.telefono2 = telefono2;
        this.noPersonalBm = noPersonalBm;
    }

    public int getNoUsuario() {
        return noUsuario;
    }

    public void setNoUsuario(int noUsuario) {
        this.noUsuario = noUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave.toUpperCase();
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte.toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno.toUpperCase();
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno.toUpperCase();
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdestatus() {
        return idestatus;
    }

    public void setIdestatus(int idestatus) {
        this.idestatus = idestatus;
    }

    public Date getFechaAuditoria() {
        return fechaAuditoria;
    }

    public void setFechaAuditoria(Date fechaAuditoria) {
        this.fechaAuditoria = fechaAuditoria;
    }


    public int getNoRol() {
        return noRol;
    }

    public void setNoRol(int noRol) {
        this.noRol = noRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol.toUpperCase();
    }

    public int getNoDepartamento() {
        return noDepartamento;
    }

    public void setNoDepartamento(int noDepartamento) {
        this.noDepartamento = noDepartamento;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public Integer getNoPersonalBm() {
        return noPersonalBm;
    }

    public void setNoPersonalBm(Integer noPersonalBm) {
        this.noPersonalBm = noPersonalBm;
    }
}