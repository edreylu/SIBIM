/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kestadobien;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.PrimeFaces;
import utilerias.Mensaje;

@ManagedBean(name = "kestadoBienControl")
@SessionScoped
public class KestadoBienControl implements java.io.Serializable {

    private final KestadoBienDAO kebdao;
    private List<KestadoBien> estadosbien;
    private KestadoBien estadobien;
    private KestadoBien estadoBienSeleccionado;
    private List<KestadoBien> filteredEstadoBien;
    private final Mensaje msg = new Mensaje();

    public KestadoBienControl() {
        kebdao = new KestadoBienDAO();
        estadobien = new KestadoBien();
    }

    public void init() {
        estadosbien = kebdao.traeRegistros(2);
        estadoBienSeleccionado = null;
    }

    public List<KestadoBien> getEstadosbien() {
        return estadosbien;
    }

    public void setEstadosbien(List<KestadoBien> estadosbien) {
        this.estadosbien = estadosbien;
    }

    public KestadoBien getEstadobien() {
        return estadobien;
    }

    public void setEstadobien(KestadoBien estadobien) {
        this.estadobien = estadobien;
    }

    public KestadoBien getEstadoBienSeleccionado() {
        return estadoBienSeleccionado;
    }

    public void setEstadoBienSeleccionado(KestadoBien estadoBienSeleccionado) {
        this.estadoBienSeleccionado = estadoBienSeleccionado;
    }

    public List<KestadoBien> getFilteredEstadoBien() {
        return filteredEstadoBien;
    }

    public void setFilteredEstadoBien(List<KestadoBien> filteredEstadoBien) {
        this.filteredEstadoBien = filteredEstadoBien;
    }

    

    public void CargaVentanaInserta(String ob) {

        filteredEstadoBien = null;
        estadobien = new KestadoBien();
        PrimeFaces.current().ajax().update(":formInsertar");
        PrimeFaces.current().executeScript("PF('dlginsertar').show();");
    }

    public void CargaVentanaModifica() {
        filteredEstadoBien = null;
        PrimeFaces.current().ajax().update(":formModificar");
        PrimeFaces.current().executeScript("PF('dlgmodificar').show();");
    }

    public void insertar() {

        estadobien.setIdEstadoDelBien(kebdao.getNumeroSiguiente());
        int valor = kebdao.insertaEstadoBien(estadobien);
        if (valor == 1) {
            msg.info("Procesado..", "Registro guardado");
        } else {
            msg.warn("Error..", "No se guardo la informacion");
        }
        PrimeFaces.current().executeScript("PF('dlginsertar').hide();");
    }

    public void modificar() {
        int valor = 0;
        
            valor = kebdao.actualizaEstadoBien(estadobien);
            if (valor == 1) {
                msg.info("Procesado..", "Registro actualizado");
            } else {
                msg.warn("Error", "No se actualizo la informacion");

            }

        PrimeFaces.current().executeScript("PF('dlgmodificar').hide();");
    }

    public void ActivarInactivar(int opcion) {

        System.out.println("valor: " + estadobien.getIdEstadoDelBien());
                String dato = opcion == 1 ? "activó" : "inactivó";
                int valor = kebdao.eliminaEstadoBien(estadobien,opcion);
                if (valor == 1) {
                    
                    msg.info("Procesado..", "Registro se "+dato);
                } else {
                    msg.warn("Error..", "No se "+dato+" el Registro");
                }
        PrimeFaces.current().executeScript("PF('dlgeliminar').hide();");
    }

    public void llenarlistas() {
        estadosbien = kebdao.traeRegistros(2);
    }

    public void cancelarActualizar() {
        PrimeFaces.current().executeScript("PF('dlgmodificar').hide();");
    }

    public void cancelarEliminar() {
        PrimeFaces.current().executeScript("PF('dlgeliminar').hide();");
    }


}