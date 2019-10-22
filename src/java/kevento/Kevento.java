/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevento;

/**
 *
 * @author usuario
 */
public class Kevento {
    private int idEvento;
    private String evento;
    private String observaciones;
    private int idEstatus;
    private boolean eventoSeleccionado;

    public Kevento() {
    }

    public Kevento(int idEvento, String evento, String observaciones, int idEstatus) {
        this.idEvento = idEvento;
        this.evento = evento;
        this.observaciones = observaciones;
        this.idEstatus = idEstatus;
    }
    
    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
    
    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
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

    public boolean isEventoSeleccionado() {
        return eventoSeleccionado;
    }

    public void setEventoSeleccionado(boolean eventoSeleccionado) {
        this.eventoSeleccionado = eventoSeleccionado;
    }
    
    
}
