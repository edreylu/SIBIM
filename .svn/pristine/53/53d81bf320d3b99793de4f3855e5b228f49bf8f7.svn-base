/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parametros;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import kevento.Kevento;
import kevento.KeventoDAO;
import org.primefaces.PrimeFaces;
import personal.Personal;
import personal.PersonalDAO;
import utilerias.Mensaje;
@ManagedBean (name = "parametrosControl")
@SessionScoped
public class ParametrosControl implements java.io.Serializable {

   private final ParametrosDAO pardao;
   private final PersonalDAO pdao;
   private final KeventoDAO kedao;
   private Parametros par;
   private List<Parametros> parametros;
   private List<Personal> personal;
   private List<Kevento> eventos;
   private String valorBuscado;
   private Mensaje msg= new Mensaje();
   public ParametrosControl() {
      par = new Parametros();
      pdao = new PersonalDAO();
      pardao=new ParametrosDAO();
      kedao=new KeventoDAO();
   }
   
   public void init() {
        par = pardao.parametros();
        eventos = kedao.traeRegistros(1);
   }

    public Parametros getPar() {
        return par;
    }

    public void setPar(Parametros par) {
        this.par = par;
    }

    public Mensaje getMsg() {
        return msg;
    }

    public void setMsg(Mensaje msg) {
        this.msg = msg;
    }

    public List<Parametros> getParametros() {
        return parametros;
    }

    public void setParametros(List<Parametros> parametros) {
        this.parametros = parametros;
    }

    public List<Personal> getPersonal() {
        return personal;
    }

    public void setPersonal(List<Personal> personal) {
        this.personal = personal;
    }

    public List<Kevento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Kevento> eventos) {
        this.eventos = eventos;
    }

    public String getValorBuscado() {
        return valorBuscado;
    }

    public void setValorBuscado(String valorBuscado) {
        this.valorBuscado = valorBuscado.toUpperCase();
    }

   
  public void modificar(){
           int valor=0;
            System.out.println("valor de par: "+par.getTiempoMaximoModif());
           
             valor=pardao.actualizaParametros(par);
             if(valor==1){
            msg.info("Procesado..", "Registro actualizado");
             }else{
             msg.warn("Error", "No se actualizo la informacion");
                
             }
          PrimeFaces.current().executeScript("PF('dlgmodificar').hide();");
        }
  
  
  public void asignaNoPersonal(Personal per) {
        Integer noPer = per.getNoPersonalBm();
        System.out.println("asignaNoPersonal()" + noPer);
        par.setNoPersonalBm(noPer);
        par.setNomPersonal(per.getNombre()+" "+per.getAp1()+" "+per.getAp2());
        PrimeFaces.current().executeScript("PF('dlgasignarper').hide();");
    }

    public void asignapersonalBusqueda(String valor) {
        if (!valor.isEmpty()) {
            personal = pdao.traeRegistrosPersonalBusqueda(1,1,valor);
            PrimeFaces.current().executeScript("PF('dlgasignarper').show();");
            PrimeFaces.current().ajax().update(":formAsignarPer");
            valorBuscado = null;
        } else {
            personal = null;
            PrimeFaces.current().ajax().update(":formAsignarPer");
            valorBuscado = null;
        }

    }
        public void cancelarActualizar(){PrimeFaces.current().executeScript("PF('dlgmodificar').hide();");}
        public void cancelarEliminar(){PrimeFaces.current().executeScript("PF('dlgeliminar').hide();");}
        public void cancelarAsignarPersonal(){PrimeFaces.current().executeScript("PF('dlgasignarper').hide();");}
        
}
