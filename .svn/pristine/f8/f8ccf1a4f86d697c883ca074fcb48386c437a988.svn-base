/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knivelarea;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.PrimeFaces;
import utilerias.Mensaje;

@ManagedBean(name = "knivelAreaControl")
@SessionScoped
public class KnivelAreaControl implements java.io.Serializable {

    private final KnivelAreaDAO knadao;
    private List<KnivelArea> nivelesArea;
    private KnivelArea nivelArea;
    private KnivelArea nivelAreaSeleccionado;
    private List<KnivelArea> filteredNivelArea;
    private final Mensaje msg = new Mensaje();

    public KnivelAreaControl() {
        knadao = new KnivelAreaDAO();
        nivelArea = new KnivelArea();
    }

    public void init() {
        nivelesArea = knadao.traeRegistros(2);
        nivelAreaSeleccionado = null;
    }

    public List<KnivelArea> getNivelesArea() {
        return nivelesArea;
    }

    public void setNivelesArea(List<KnivelArea> nivelesArea) {
        this.nivelesArea = nivelesArea;
    }

    public KnivelArea getNivelArea() {
        return nivelArea;
    }

    public void setNivelArea(KnivelArea nivelArea) {
        this.nivelArea = nivelArea;
    }

    public KnivelArea getNivelAreaSeleccionado() {
        return nivelAreaSeleccionado;
    }

    public void setNivelAreaSeleccionado(KnivelArea nivelAreaSeleccionado) {
        this.nivelAreaSeleccionado = nivelAreaSeleccionado;
    }

    public List<KnivelArea> getFilteredNivelArea() {
        return filteredNivelArea;
    }

    public void setFilteredNivelArea(List<KnivelArea> filteredNivelArea) {
        this.filteredNivelArea = filteredNivelArea;
    }

    public void CargaVentanaInserta(String ob) {

        filteredNivelArea = null;
        nivelArea = new KnivelArea();
        PrimeFaces.current().ajax().update(":formInsertar");
        PrimeFaces.current().executeScript("PF('dlginsertar').show();");
    }

    public void CargaVentanaModifica() {
        filteredNivelArea = null;
        PrimeFaces.current().ajax().update(":formModificar");
        PrimeFaces.current().executeScript("PF('dlgmodificar').show();");
    }

    public void insertar() {

        nivelArea.setIdNivelArea(knadao.getNumeroSiguiente());
        int valor = knadao.insertaKnivelArea(nivelArea);
        if (valor == 1) {
            msg.info("Procesado..", "Registro guardado");
        } else {
            msg.warn("Error..", "No se guardo la informacion");
        }
        PrimeFaces.current().executeScript("PF('dlginsertar').hide();");
    }

    public void modificar() {
        int valor = 0;
        
            valor = knadao.actualizaKnivelArea(nivelArea);
            if (valor == 1) {
                msg.info("Procesado..", "Registro actualizado");
            } else {
                msg.warn("Error", "No se actualizo la informacion");

            }

        PrimeFaces.current().executeScript("PF('dlgmodificar').hide();");
    }

    public void ActivarInactivar(int opcion) {

        System.out.println("valor: " + nivelArea.getIdNivelArea());
                String dato = opcion == 1 ? "activó" : "inactivó";
                int valor = knadao.eliminaKnivelArea(nivelArea,opcion);
                if (valor == 1) {
                    
                    msg.info("Procesado..", "Registro se "+dato);
                } else {
                    msg.warn("Error..", "No se "+dato+" el Registro");
                }
        PrimeFaces.current().executeScript("PF('dlgeliminar').hide();");
    }

    public void llenarlistas() {
        nivelesArea = knadao.traeRegistros(2);
    }

    public void cancelarActualizar() {
        PrimeFaces.current().executeScript("PF('dlgmodificar').hide();");
    }

    public void cancelarEliminar() {
        PrimeFaces.current().executeScript("PF('dlgeliminar').hide();");
    }


}
