/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kformaadquisicion;

/**
 *
 * @author usuario
 */
public class Kformaadquisicion {
    private int idFormaAdquisicion;
    private String formaadquisicion;
    private String fechaRegistro;
    private String observaciones;
    private int idEstatus;

    public Kformaadquisicion() {
    }

    public Kformaadquisicion(int idFormaAdquisicion, String formaadquisicion, String fechaRegistro, String observaciones, int idEstatus) {
        this.idFormaAdquisicion = idFormaAdquisicion;
        this.formaadquisicion = formaadquisicion;
        this.fechaRegistro = fechaRegistro;
        this.observaciones = observaciones;
        this.idEstatus = idEstatus;
    }

    public int getIdFormaAdquisicion() {
        return idFormaAdquisicion;
    }

    public void setIdFormaAdquisicion(int idFormaAdquisicion) {
        this.idFormaAdquisicion = idFormaAdquisicion;
    }

    public String getFormaadquisicion() {
        return formaadquisicion;
    }

    public void setFormaadquisicion(String formaadquisicion) {
        this.formaadquisicion = null != formaadquisicion ? formaadquisicion.toUpperCase() : null;
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
