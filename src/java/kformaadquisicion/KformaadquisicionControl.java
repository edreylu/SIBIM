/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kformaadquisicion;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.PrimeFaces;
import utilerias.Mensaje;

@ManagedBean(name = "kformaAdquisicionControl")
@SessionScoped
public class KformaadquisicionControl implements java.io.Serializable {

    private final KformaadquisicionDAO kfadao;
    private List<Kformaadquisicion> formasadquisicion;
    private Kformaadquisicion formaadquisicion;
    private Kformaadquisicion formaAdquisicionSeleccionado;
    private List<Kformaadquisicion> filteredFormaAdquisicion;
    private final Mensaje msg = new Mensaje();

    public KformaadquisicionControl() {
        kfadao = new KformaadquisicionDAO();
        formaadquisicion = new Kformaadquisicion();
    }

    public void init() {
        formasadquisicion = kfadao.traeRegistros(2);
        formaAdquisicionSeleccionado = null;
    }

    public List<Kformaadquisicion> getFormasadquisicion() {
        return formasadquisicion;
    }

    public void setFormasadquisicion(List<Kformaadquisicion> formasadquisicion) {
        this.formasadquisicion = formasadquisicion;
    }

    public Kformaadquisicion getFormaadquisicion() {
        return formaadquisicion;
    }

    public void setFormaadquisicion(Kformaadquisicion formaadquisicion) {
        this.formaadquisicion = formaadquisicion;
    }

    public Kformaadquisicion getFormaAdquisicionSeleccionado() {
        return formaAdquisicionSeleccionado;
    }

    public void setFormaAdquisicionSeleccionado(Kformaadquisicion formaAdquisicionSeleccionado) {
        this.formaAdquisicionSeleccionado = formaAdquisicionSeleccionado;
    }

    public List<Kformaadquisicion> getFilteredFormaAdquisicion() {
        return filteredFormaAdquisicion;
    }

    public void setFilteredFormaAdquisicion(List<Kformaadquisicion> filteredFormaAdquisicion) {
        this.filteredFormaAdquisicion = filteredFormaAdquisicion;
    }

    public void CargaVentanaInserta(String ob) {

        filteredFormaAdquisicion = null;
        formaadquisicion = new Kformaadquisicion();
        PrimeFaces.current().ajax().update(":formInsertar");
        PrimeFaces.current().executeScript("PF('dlginsertar').show();");
    }

    public void CargaVentanaModifica() {
        filteredFormaAdquisicion = null;
        PrimeFaces.current().ajax().update(":formModificar");
        PrimeFaces.current().executeScript("PF('dlgmodificar').show();");
    }

    public void insertar() {

        formaadquisicion.setIdFormaAdquisicion(kfadao.getNumeroSiguiente());
        int valor = kfadao.insertaKformaadquisicion(formaadquisicion);
        if (valor == 1) {
            msg.info("Procesado..", "Registro guardado");
        } else {
            msg.warn("Error..", "No se guardo la informacion");
        }
        PrimeFaces.current().executeScript("PF('dlginsertar').hide();");
    }

    public void modificar() {
        int valor = 0;
        
            valor = kfadao.actualizaKformaadquisicion(formaadquisicion);
            if (valor == 1) {
                msg.info("Procesado..", "Registro actualizado");
            } else {
                msg.warn("Error", "No se actualizo la informacion");

            }

        PrimeFaces.current().executeScript("PF('dlgmodificar').hide();");
    }

    public void ActivarInactivar(int opcion) {

        System.out.println("valor: " + formaadquisicion.getIdFormaAdquisicion());
                String dato = opcion == 1 ? "activó" : "inactivó";
                int valor = kfadao.eliminaKformaadquisicion(formaadquisicion,opcion);
                if (valor == 1) {
                    
                    msg.info("Procesado..", "Registro se "+dato);
                } else {
                    msg.warn("Error..", "No se "+dato+" el Registro");
                }
        PrimeFaces.current().executeScript("PF('dlgeliminar').hide();");
    }

    public void cancelarActualizar() {
        PrimeFaces.current().executeScript("PF('dlgmodificar').hide();");
    }

    public void cancelarEliminar() {
        PrimeFaces.current().executeScript("PF('dlgeliminar').hide();");
    }


}