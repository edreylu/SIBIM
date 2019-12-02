/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kestadobien;

/**
 *
 * @author usuario
 */
public class KestadoBien {
    private int idEstadoDelBien;
    private String estadoDelBien;
    private String fechaRegistro;
    private String observaciones;
    private int idEstatus;

    public KestadoBien() {
    }

    public KestadoBien(int idEstadoDelBien, String estadoDelBien, String fechaRegistro, String observaciones, int idEstatus) {
        this.idEstadoDelBien = idEstadoDelBien;
        this.estadoDelBien = estadoDelBien;
        this.fechaRegistro = fechaRegistro;
        this.observaciones = observaciones;
        this.idEstatus = idEstatus;
    }

    public int getIdEstadoDelBien() {
        return idEstadoDelBien;
    }

    public void setIdEstadoDelBien(int idEstadoDelBien) {
        this.idEstadoDelBien = idEstadoDelBien;
    }

    public String getEstadoDelBien() {
        return estadoDelBien;
    }

    public void setEstadoDelBien(String estadoDelBien) {
        this.estadoDelBien = null != estadoDelBien ? estadoDelBien.toUpperCase() : null;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = null != observaciones ? observaciones.toUpperCase() : null;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }
    
    
}
