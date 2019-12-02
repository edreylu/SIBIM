/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package korigenrecurso;

/**
 *
 * @author usuario
 */
public class KorigenRecurso {
    private int idOrigenRecurso;
    private String descripcion;
    private String fechaRegistro;
    private String observaciones;
    private int idEstatus;

    public KorigenRecurso() {
    }

    public KorigenRecurso(int idOrigenRecurso, String descripcion, String fechaRegistro, String observaciones, int idEstatus) {
        this.idOrigenRecurso = idOrigenRecurso;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.observaciones = observaciones;
        this.idEstatus = idEstatus;
    }

    public int getIdOrigenRecurso() {
        return idOrigenRecurso;
    }

    public void setIdOrigenRecurso(int idOrigenRecurso) {
        this.idOrigenRecurso = idOrigenRecurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = null != descripcion ? descripcion.toUpperCase() : null;
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
