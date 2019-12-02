package kproveedor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.PrimeFaces;
import utilerias.Mensaje;

/**
 *
 * @author usuario
 */
@ManagedBean (name = "proveedoresControl")
@SessionScoped
public class ProveedoresControl implements Serializable{
    
     private Proveedor proveedor;
    private List<Proveedor> listProveedor;
    private final ProveedorDAO proveedorDAO;
    private List<Proveedor> listProveedorFiltrado;
    private Proveedor proveedorSeleccionado;
    private Proveedor proveedorEditar;
    private final Mensaje msg = new Mensaje();

    public ProveedoresControl() {
        proveedorDAO = new ProveedorDAO();
        proveedor = new Proveedor();
    }
    
    
    
    public void init() {
        listProveedor = proveedorDAO.traeRegistrosProveedor(2);
        proveedorSeleccionado = null;
        
        
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getListProveedor() {
        return listProveedor;
    }

    public void setListProveedor(List<Proveedor> listProveedor) {
        this.listProveedor = listProveedor;
    }

    public List<Proveedor> getListProveedorFiltrado() {
        return listProveedorFiltrado;
    }

    public void setListProveedorFiltrado(List<Proveedor> listProveedorFiltrado) {
        this.listProveedorFiltrado = listProveedorFiltrado;
    }

    public Proveedor getProveedorSeleccionado() {
        return proveedorSeleccionado;
    }

    public void setProveedorSeleccionado(Proveedor proveedorSeleccionado) {
        this.proveedorSeleccionado = proveedorSeleccionado;
    }

    public Proveedor getProveedorEditar() {
        return proveedorEditar;
    }

    public void setProveedorEditar(Proveedor proveedorEditar) {
        this.proveedorEditar = proveedorEditar;
    }
    
        
    public void cargaVentanaInserta(String ob) {

        listProveedorFiltrado = null;
        proveedor = new Proveedor();
        PrimeFaces.current().ajax().update(":formInsertar");
        PrimeFaces.current().executeScript("PF('dlginsertar').show();");
    }
    
    public void insertar() {
        proveedor.setIdProveedor(proveedorDAO.getNumeroSiguiente());
        System.out.println("id " + proveedor.getIdProveedor());
        int valor = proveedorDAO.insertaProveedor(proveedor);
        if (valor > 0) {
            System.out.println("Se inserto una persona");
            msg.info("Procesado..", "Registro guardado");
            PrimeFaces.current().executeScript("PF('dlginsertar').hide();");

        } else{
            msg.error("Error..", "No se guardo la informacion");
        }
       
    }
    
    public void preparaEdicion(){
        proveedorEditar = new Proveedor(proveedorSeleccionado);
    }
    
    public void editar() {

        int valor = proveedorDAO.actualizaProveedor(proveedorEditar);
        if (valor == 1) {
            System.out.println("Se edito a la persona");
            msg.info("Procesado..", "Registro editado");
            PrimeFaces.current().executeScript("PF('dlgmodificar').hide();");

        } else{
            msg.error("Error..", "No se pudo editar el registro");
        }
       
    }
    
    public void ActivarInactivar(int opcion) {

        System.out.println("valor: " + proveedor.getIdProveedor());
                String dato = opcion == 1 ? "activó" : "inactivó";
                int valor = proveedorDAO.eliminaProveedor(proveedor,opcion);
                if (valor == 1) {
                    
                    msg.info("Procesado..", "Registro se "+dato);
                } else {
                    msg.warn("Error..", "No se "+dato+" el Registro");
                }
        PrimeFaces.current().executeScript("PF('dlgeliminar').hide();");
    }
    
    public void cancelarEliminar() {
        PrimeFaces.current().executeScript("PF('dlgeliminar').hide();");
    }
    
}
