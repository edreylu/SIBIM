/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import departamento.Departamento;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.PrimeFaces;
import roles.Roles;
import roles.RolesDAO;
import personal.Personal;
import utilerias.Mensaje;

@ManagedBean(name = "usuariosControl")
@SessionScoped
public class UsuariosControl implements java.io.Serializable {

    private final UsuariosDAO pdao;
    private final RolesDAO rdao;
    private Usuarios usuario;
    private Usuarios usuarioSeleccionado;
    private List<Usuarios> usuarios;
    private List<Usuarios> filteredUsuarios;
    private List<Roles> roles;
    private List<Personal> personal;
    private List<Departamento> deps;
    private List<Departamento> filteredDeps;
    private List<Departamento> filteredPersonal;
    private final Mensaje msg = new Mensaje();
    private boolean isSelectedAll;
    private String valorBuscado;

    public UsuariosControl() {
        pdao = new UsuariosDAO();
        rdao = new RolesDAO();
        usuario = new Usuarios();
    }

    public void init() {
        usuarios = pdao.traeRegistros();
        roles = rdao.traeRegistros();
        usuarioSeleccionado = null;
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;

    }

    public List<Usuarios> getFilteredUsuarios() {
        return filteredUsuarios;
    }

    public void setFilteredUsuarios(List<Usuarios> filteredUsuarios) {
        this.filteredUsuarios = filteredUsuarios;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public List<Personal> getPersonal() {
        return personal;
    }

    public void setPersonal(List<Personal> personal) {
        this.personal = personal;
    }

    public Usuarios getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuarios usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public List<Departamento> getDeps() {
        return deps;
    }

    public void setDeps(List<Departamento> deps) {
        this.deps = deps;
    }

    public List<Departamento> getFilteredDeps() {
        return filteredDeps;
    }

    public void setFilteredDeps(List<Departamento> filteredDeps) {
        this.filteredDeps = filteredDeps;
    }

    public List<Departamento> getFilteredPersonal() {
        return filteredPersonal;
    }

    public void setFilteredPersonal(List<Departamento> filteredPersonal) {
        this.filteredPersonal = filteredPersonal;
    }

    public String getValorBuscado() {
        return valorBuscado;
    }

    public void setValorBuscado(String valorBuscado) {
        this.valorBuscado = valorBuscado.toUpperCase();
    }

    public Usuarios existePersona(String clave, String pas) {
        if (!clave.equals("") && !pas.equals("")) {
            usuario = pdao.existePersona(clave, pas);
        }
        return usuario;
    }

    public List<String> existePermisoPantalla(int noPersonal) {

        List<String> pantallas = pdao.getPermisoPantalla(noPersonal);
        return pantallas;
    }

    public Long existePersonaSP(String clave) {
        long valor = 0;
        if (!clave.equals("")) {
            valor = pdao.existePersonaSP(clave);
        }
        System.out.println("clave: " + clave + " valor: " + valor);
        return valor;
    }

    public void cargarQuery(String query) {

        pdao.ejecutarQuery(query);
    }

    public void CargaVentanaInserta(String ob) {

        filteredUsuarios = null;
        usuario = new Usuarios();
        PrimeFaces.current().ajax().update(":formInsertar");
        PrimeFaces.current().executeScript("PF('dlginsertar').show();");
    }

    public void insertar() {

        usuario.setNoUsuario(pdao.getNoUsuarioSiguiente());
        System.out.println("valor de numero de usuario a insertar: " + usuario.getNoUsuario());

        int valor = pdao.insertaUsuario(usuario);
        if (valor == 1) {
            System.out.println("valor de rol a asignar: " + usuario.getNoRol());
            pdao.eliminaRolUsuario(usuario.getNoUsuario());
            pdao.asignaRolUsuario(usuario.getNoUsuario(), usuario.getNoRol());
            msg.info("Procesado..", "Registro guardado");

        } else {
            msg.warn("Error..", "No se guardo la informacion");
        }
        PrimeFaces.current().executeScript("PF('dlginsertar').hide();");
    }

    public void modificar() {
        System.out.println("valor de usuario actualizar: " + usuario.getClave() + " con numero de usuario: " + usuario.getNoUsuario());

        int valor = pdao.actualizaUsuario(usuario);
        if (valor == 1) {
            System.out.println("valor de rol a asignar: " + usuario.getNoRol());
            pdao.eliminaRolUsuario(usuario.getNoUsuario());
            pdao.asignaRolUsuario(usuario.getNoUsuario(), usuario.getNoRol());

            msg.info("Procesado..", "Registro actualizado");
        } else {
            msg.warn("Error..", "Registro no actualizado");
        }
        PrimeFaces.current().executeScript("PF('dlgmodificar').hide();");
    }

    public void modificarPasaporte() {
        int valor = pdao.actualizaPasaporte(usuario.getNoUsuario(), usuario.getPasaporte());
        if (valor == 1) {
            msg.info("Procesado..", "Password actualizado");
        } else {
            msg.warn("Error..", "Password no actualizado");
        }
        PrimeFaces.current().executeScript("PF('dlgpasaporte').hide();");
    }

    public void modificarPasaporteSP(int us, String pas) {

        int valor = pdao.actualizaPasaporte(us, pas);
        if (valor == 1) {
            msg.info("Procesado..", "Password actualizado");
        } else {
            msg.warn("Error..", "Password no actualizado");
        }
        PrimeFaces.current().executeScript("PF('dlgpasaporte').hide();");
    }

    public void eliminar() {
        System.out.println("valor de usuario eliminar: " + usuario.getNoUsuario());

        int noUsuario = usuario.getNoUsuario();
        int valor = pdao.eliminaUsuario(usuario);
        if (valor == 1) {
            boolean existe = pdao.existeRolUsuario(noUsuario);
            boolean existe2 = pdao.existeDepUsuario(noUsuario);
            if (existe) {
                pdao.eliminaRolUsuario(usuario.getNoUsuario());
            }
            if (existe2) {
                pdao.eliminaDepUsuario(usuario);
            }

            msg.info("Procesado..", "Registro inactivado");
        } else {
            msg.warn("Error..", "No se inactivo la informacion");
        }
        PrimeFaces.current().executeScript("PF('dlgeliminar').hide();");

    }

    public void asignar() {
        System.out.println("valor de usuario a asignar departamento: " + usuario.getNoUsuario());
        boolean existe = pdao.existeDepUsuario(usuario.getNoUsuario());
        if (existe) {
            pdao.eliminaDepUsuario(usuario);
        }
        int valor = pdao.asignaDepUsuario(usuario.getNoUsuario(), deps);
        if (valor == -1) {
            msg.error("Error", "No se pudo asignar los departamentos");
        } else {
            msg.info("Procesado..", valor + " Departamentos Asignados");
        }
        PrimeFaces.current().executeScript("PF('dlgasignar').hide();");
    }

    public void asignadep() {
        filteredDeps = null;
        deps = pdao.traeRegistrosdep(usuarioSeleccionado);
        PrimeFaces.current().executeScript("PF('dlgasignar').show();");
    }

    public void asignaNoPersonal(Personal per) {
        Integer noPer = per.getNoPersonalBm();
        System.out.println("usuarios.UsuariosControl.asignaNoPersonal()" + noPer);
        usuario.setNoPersonalBm(noPer);
        PrimeFaces.current().executeScript("PF('dlgasignarper').hide();");
    }

    public void asignapersonalBusqueda(String valor) {
        if (!valor.isEmpty()) {
            personal = pdao.traeRegistrosPersonalBusqueda(valor);
            PrimeFaces.current().executeScript("PF('dlgasignarper').show();");
            PrimeFaces.current().ajax().update(":formAsignarPer");
            valorBuscado = null;
        } else {
            personal = null;
            PrimeFaces.current().ajax().update(":formAsignarPer");
            valorBuscado = null;
        }

    }

    public void selectodo() {
        boolean val = isSelectedAll;
        for (int i = 0; i < deps.size(); i++) {
            Departamento dep = deps.get(i);
            dep.setDepartamentoSeleccionado(val);
            deps.set(i, dep);
        }

        PrimeFaces.current().ajax().update(":formAsignar");
    }

    public void selecUno(Departamento dep) {
        for (int i = 0; i < deps.size(); i++) {
            if (deps.get(i).getIdDepartamento() == dep.getIdDepartamento()) {
                if (dep.isDepartamentoSeleccionado()) {
                    dep.setDepartamentoSeleccionado(true);
                    deps.set(i, dep);
                } else {
                    dep.setDepartamentoSeleccionado(false);
                    deps.set(i, dep);
                }
            }
        }

        PrimeFaces.current().ajax().update(":formAsignar");
    }

    public void selecUnoEsEnlace(Departamento dep) {
        for (int i = 0; i < deps.size(); i++) {
            if (deps.get(i).getIdDepartamento() == dep.getIdDepartamento()) {
                if (dep.isDepartamentoSeleccionado()) {
                    dep.setDepartamentoSeleccionadoEnlace(true);
                    deps.set(i, dep);
                } else {
                    dep.setDepartamentoSeleccionadoEnlace(false);
                    deps.set(i, dep);
                }
            }
        }

        PrimeFaces.current().ajax().update(":formAsignar");
    }

    public void cancelarActualizar() {
        PrimeFaces.current().executeScript("PF('dlgmodificar').hide();");
    }

    public void cancelarAsignar() {
        PrimeFaces.current().executeScript("PF('dlgasignar').hide();");
    }

    public void cancelarAsignarPersonal() {
        PrimeFaces.current().executeScript("PF('dlgasignarper').hide();");
    }

    public void cancelarEliminar() {
        PrimeFaces.current().executeScript("PF('dlgeliminar').hide();");
    }

    public boolean isIsSelectedAll() {
        return isSelectedAll;
    }

    public void setIsSelectedAll(boolean isSelectedAll) {
        this.isSelectedAll = isSelectedAll;
    }

    public Usuarios getUsuario() {

        return usuario;

    }

    public void setUsuario(Usuarios usuario) {

        this.usuario = usuario;

    }

}
