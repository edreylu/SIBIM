/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevento;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.PrimeFaces;
import utilerias.Mensaje;

@ManagedBean(name = "keventoControl")
@SessionScoped
public class KeventoControl implements java.io.Serializable {

    private final KeventoDAO kedao;
    private List<Kevento> eventos;
    private Kevento evento;
    private Kevento eventoSeleccionado;
    private List<Kevento> filteredEvento;
    private final Mensaje msg = new Mensaje();

    public KeventoControl() {
        kedao = new KeventoDAO();
        evento = new Kevento();
    }

    public void init() {
        eventos = kedao.traeRegistros(2);
        eventoSeleccionado = null;
    }

    public List<Kevento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Kevento> eventos) {
        this.eventos = eventos;
    }

    public Kevento getEvento() {
        return evento;
    }

    public void setEvento(Kevento evento) {
        this.evento = evento;
    }

    public Kevento getEventoSeleccionado() {
        return eventoSeleccionado;
    }

    public void setEventoSeleccionado(Kevento eventoSeleccionado) {
        this.eventoSeleccionado = eventoSeleccionado;
    }

    public List<Kevento> getFilteredEvento() {
        return filteredEvento;
    }

    public void setFilteredEvento(List<Kevento> filteredEvento) {
        this.filteredEvento = filteredEvento;
    }


    public void CargaVentanaInserta(String ob) {

        filteredEvento = null;
        evento = new Kevento();
        PrimeFaces.current().ajax().update(":formInsertar");
        PrimeFaces.current().executeScript("PF('dlginsertar').show();");
    }

    public void CargaVentanaModifica() {
        filteredEvento = null;
        PrimeFaces.current().ajax().update(":formModificar");
        PrimeFaces.current().executeScript("PF('dlgmodificar').show();");
    }

    public void insertar() {

        evento.setIdEvento(kedao.getNumeroSiguiente());
        int valor = kedao.insertaKevento(evento);
        if (valor == 1) {
            msg.info("Procesado..", "Registro guardado");
        } else {
            msg.warn("Error..", "No se guardo la informacion");
        }
        PrimeFaces.current().executeScript("PF('dlginsertar').hide();");
    }

    public void modificar() {
        int valor = 0;
        
            valor = kedao.actualizaKevento(evento);
            if (valor == 1) {
                msg.info("Procesado..", "Registro actualizado");
            } else {
                msg.warn("Error", "No se actualizo la informacion");

            }

        PrimeFaces.current().executeScript("PF('dlgmodificar').hide();");
    }

    public void ActivarInactivar(int opcion) {

        System.out.println("valor: " + evento.getIdEvento());
                String dato = opcion == 1 ? "activó" : "inactivó";
                int valor = kedao.eliminaKevento(evento,opcion);
                if (valor == 1) {
                    
                    msg.info("Procesado..", "Registro se "+dato);
                } else {
                    msg.warn("Error..", "No se "+dato+" el Registro");
                }
        PrimeFaces.current().executeScript("PF('dlgeliminar').hide();");
    }

    public void llenarlistas() {
        eventos = kedao.traeRegistros(2);
    }

    public void cancelarActualizar() {
        PrimeFaces.current().executeScript("PF('dlgmodificar').hide();");
    }

    public void cancelarEliminar() {
        PrimeFaces.current().executeScript("PF('dlgeliminar').hide();");
    }


}
