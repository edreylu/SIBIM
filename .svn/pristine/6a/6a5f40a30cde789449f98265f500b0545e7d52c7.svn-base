/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.PrimeFaces;
import org.primefaces.model.StreamedContent;
import reportes.ReportesControl;
import utilerias.Mensaje;

/**
 *
 * @author usuario
 */
@ManagedBean (name = "personalControl")
@SessionScoped
public class PersonalControl implements Serializable{
    
    private Personal personal;
    private List<Personal> listPersonal;
    private final PersonalDAO personalDAO;
    private List<Personal> listPersonalFiltrado;
    private Personal personalSeleccionado;
    private Personal personalEditar;
    private ReportesControl rc;
    private StreamedContent file;
    private final Mensaje msg = new Mensaje();

    public PersonalControl() {
        personalDAO = new PersonalDAO();
        rc=new ReportesControl();
        personal = new Personal();
    }
    
    public void init() {
        listPersonal = personalDAO.traeRegistrosPersonal();
        personalSeleccionado = null;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public List<Personal> getListPersonal() {
        return listPersonal;
    }

    public void setListPersonal(List<Personal> listPersonal) {
        this.listPersonal = listPersonal;
    }

    public List<Personal> getListPersonalFiltrado() {
        return listPersonalFiltrado;
    }

    public void setListPersonalFiltrado(List<Personal> listPersonalFiltrado) {
        this.listPersonalFiltrado = listPersonalFiltrado;
    }

    public Personal getPersonalSeleccionado() {
        return personalSeleccionado;
    }

    public void setPersonalSeleccionado(Personal personalSeleccionado) {
        this.personalSeleccionado = personalSeleccionado;
    }

    public Personal getPersonalEditar() {
        return personalEditar;
    }

    public void setPersonalEditar(Personal personalEditar) {
        this.personalEditar = personalEditar;
    }

    public ReportesControl getRc() {
        return rc;
    }

    public void setRc(ReportesControl rc) {
        this.rc = rc;
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }
    
    public void cargaVentanaInserta(String ob) {

        listPersonalFiltrado = null;
        personal = new Personal();
        PrimeFaces.current().ajax().update(":formInsertar");
        PrimeFaces.current().executeScript("PF('dlginsertar').show();");
    }
    
    public void insertar() {

        int valor = personalDAO.insertaPersona(personal);
        if (valor > 0) {
            System.out.println("Se inserto una persona");
            msg.info("Procesado..", "Registro guardado");
            PrimeFaces.current().executeScript("PF('dlginsertar').hide();");

        } else if(valor == -1){
            msg.warn("", "El RFC ó CURP ya existe");
        } else{
            msg.error("Error..", "No se guardo la informacion");
        }
       
    }
    
    public void preparaEdicion(){
        personalEditar = new Personal(personalSeleccionado);
    }
    
    public void editar() {

        int valor = personalDAO.actualizaPersona(personalEditar);
        if (valor == 1) {
            System.out.println("Se edito a la persona");
            msg.info("Procesado..", "Registro editado");
            PrimeFaces.current().executeScript("PF('dlgmodificar').hide();");

        } else{
            msg.error("Error..", "No se pudo editar el registro");
        }
       
    }
    
    public void ActivarInactivar(int opcion){
        
       System.out.println("valor: " + personal.getNoPersonalBm());
                String dato = opcion == 1 ? "activó" : "inactivó";
                int valor = personalDAO.eliminaPersonal(personal,opcion);
                if (valor == 1) {
                    msg.info("Procesado..", "Registro se "+dato);
                } else {
                    msg.warn("Error..", "No se "+dato+" el Registro");
                }
        PrimeFaces.current().executeScript("PF('dlgeliminar').hide();");
        }
    
    public void reporte(){
        String consulta = "select nopersonalbm, nopersonal, rfc, curp, ap1, ap2, nombre, idestatus, funcion from personal",
                tituloReporte = "REPORTE PERSONAL",
                nombreReporte = "REPORTE_PERSONAL",
                noUsuario = "";

     file=rc.generaExcelReporte(consulta, tituloReporte, nombreReporte,noUsuario);
        }
    
    public void cancelarEliminar(){PrimeFaces.current().executeScript("PF('dlgeliminar').hide();");}
    
    
}
