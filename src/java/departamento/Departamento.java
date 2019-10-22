/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departamento;

/**
 *
 * @author usuario
 */
public class Departamento {
 private int idDepartamento;
 private String nomDepto;
 private int noPersonalbm;
 private String domicilio;
 private String claveCt;
 private int idUr;
 private int idNivelArea;
 private String observaciones;
 private int noBloque;
 private String fechaAlta;
 private int noUsuarioAlta;
 private String fechaBaja;
 private int noUsuarioBaja;
 private String fechaUltimaModif;
 private int noUsuarioUltimaModif;
 private int idEstatus;
 private boolean departamentoSeleccionado;
 private boolean departamentoSeleccionadoEnlace;
    public Departamento() {
    }
    public Departamento(int idDepartamento, String nomDepto, int noPersonalbm, String domicilio, String claveCt, int idUr, int idNivelArea, String observaciones, int noBloque, String fechaAlta, int noUsuarioAlta, String fechaBaja, int noUsuarioBaja, String fechaUltimaModif, int noUsuarioUltimaModif, int idEstatus) {
        this.idDepartamento = idDepartamento;
        this.nomDepto = nomDepto;
        this.noPersonalbm = noPersonalbm;
        this.domicilio = domicilio;
        this.claveCt = claveCt;
        this.idUr = idUr;
        this.idNivelArea = idNivelArea;
        this.observaciones = observaciones;
        this.noBloque = noBloque;
        this.fechaAlta = fechaAlta;
        this.noUsuarioAlta = noUsuarioAlta;
        this.fechaBaja = fechaBaja;
        this.noUsuarioBaja = noUsuarioBaja;
        this.fechaUltimaModif = fechaUltimaModif;
        this.noUsuarioUltimaModif = noUsuarioUltimaModif;
        this.idEstatus = idEstatus;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNomDepto() {
        return nomDepto;
    }

    public void setNomDepto(String nomDepto) {
        this.nomDepto = nomDepto;
    }

    public int getNoPersonalbm() {
        return noPersonalbm;
    }

    public void setNoPersonalbm(int noPersonalbm) {
        this.noPersonalbm = noPersonalbm;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getClaveCt() {
        return claveCt;
    }

    public void setClaveCt(String claveCt) {
        this.claveCt = claveCt;
    }

    public int getIdUr() {
        return idUr;
    }

    public void setIdUr(int idUr) {
        this.idUr = idUr;
    }

    public int getIdNivelArea() {
        return idNivelArea;
    }

    public void setIdNivelArea(int idNivelArea) {
        this.idNivelArea = idNivelArea;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getNoBloque() {
        return noBloque;
    }

    public void setNoBloque(int noBloque) {
        this.noBloque = noBloque;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getNoUsuarioAlta() {
        return noUsuarioAlta;
    }

    public void setNoUsuarioAlta(int noUsuarioAlta) {
        this.noUsuarioAlta = noUsuarioAlta;
    }

    public String getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public int getNoUsuarioBaja() {
        return noUsuarioBaja;
    }

    public void setNoUsuarioBaja(int noUsuarioBaja) {
        this.noUsuarioBaja = noUsuarioBaja;
    }

    public String getFechaUltimaModif() {
        return fechaUltimaModif;
    }

    public void setFechaUltimaModif(String fechaUltimaModif) {
        this.fechaUltimaModif = fechaUltimaModif;
    }

    public int getNoUsuarioUltimaModif() {
        return noUsuarioUltimaModif;
    }

    public void setNoUsuarioUltimaModif(int noUsuarioUltimaModif) {
        this.noUsuarioUltimaModif = noUsuarioUltimaModif;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public boolean isDepartamentoSeleccionado() {
        return departamentoSeleccionado;
    }

    public void setDepartamentoSeleccionado(boolean departamentoSeleccionado) {
        this.departamentoSeleccionado = departamentoSeleccionado;
    }

    public boolean isDepartamentoSeleccionadoEnlace() {
        return departamentoSeleccionadoEnlace;
    }

    public void setDepartamentoSeleccionadoEnlace(boolean departamentoSeleccionadoEnlace) {
        this.departamentoSeleccionadoEnlace = departamentoSeleccionadoEnlace;
    }
    
 
}
