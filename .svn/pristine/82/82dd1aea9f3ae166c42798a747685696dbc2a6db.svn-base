/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitacora;

import acceso.AccesoControl;
import departamento.Departamento;
import departamento.DepartamentoDAO;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import mobiliario.Mobiliario;
import mobiliario.MobiliarioDAO;
import org.primefaces.PrimeFaces;
import org.primefaces.model.StreamedContent;
import personal.Personal;
import personal.PersonalDAO;
import reportes.ReportesControl;
import utilerias.Mensaje;
import utilerias.Procedimiento;

@ManagedBean(name = "bitacoraControl")
@SessionScoped
public class BitacoraControl implements java.io.Serializable {
    @ManagedProperty(value = "#{accesoC}")
    private AccesoControl accesoC;
    private final BitacoraDAO bitdao;
    private final PersonalDAO pdao;
    private final MobiliarioDAO modao;
    private final DepartamentoDAO depdao;
    private List<Bitacora> bitacoras;
    private Bitacora bitacora;
    private Bitacora bitacoraSeleccionada;
    private OperacionesMobiliario operacionesMobiliario;
    private List<Bitacora> filteredBitacora;
    private List<Mobiliario> mobiliarios;
    private List<Mobiliario> filteredMobiliario;
    private List<Mobiliario> mobiliariosSeleccionados;
    private List<Personal> personal;
    private List<Departamento> departamentos;
    private String valorBuscado;
    private Date fecha;
    private int opcionSelect;
    public StreamedContent file;
    private Procedimiento pro= new Procedimiento();
    private final Mensaje msg = new Mensaje();

    public BitacoraControl() {
        bitdao = new BitacoraDAO();
        pdao = new PersonalDAO();
        modao = new MobiliarioDAO();
        depdao = new DepartamentoDAO();
        bitacora = new Bitacora();
        operacionesMobiliario= new OperacionesMobiliario();
    }

    public void init() {
        opcionSelect=0;
        mobiliarios = null;
    }

    public List<Bitacora> getBitacoras() {
        return bitacoras;
    }

    public void setBitacoras(List<Bitacora> bitacoras) {
        this.bitacoras = bitacoras;
    }

    public Bitacora getBitacora() {
        return bitacora;
    }

    public void setBitacora(Bitacora bitacora) {
        this.bitacora = bitacora;
    }

    public Bitacora getBitacoraSeleccionada() {
        return bitacoraSeleccionada;
    }

    public void setBitacoraSeleccionada(Bitacora bitacoraSeleccionada) {
        this.bitacoraSeleccionada = bitacoraSeleccionada;
    }

    public OperacionesMobiliario getOperacionesMobiliario() {
        return operacionesMobiliario;
    }

    public void setOperacionesMobiliario(OperacionesMobiliario operacionesMobiliario) {
        this.operacionesMobiliario = operacionesMobiliario;
    }

    public List<Mobiliario> getMobiliariosSeleccionados() {
        return mobiliariosSeleccionados;
    }

    public void setMobiliariosSeleccionados(List<Mobiliario> mobiliariosSeleccionados) {
        this.mobiliariosSeleccionados = mobiliariosSeleccionados;
    }

    public List<Bitacora> getFilteredBitacora() {
        return filteredBitacora;
    }

    public void setFilteredBitacora(List<Bitacora> filteredBitacora) {
        this.filteredBitacora = filteredBitacora;
    }

    public List<Personal> getPersonal() {
        return personal;
    }

    public void setPersonal(List<Personal> personal) {
        this.personal = personal;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public List<Mobiliario> getMobiliarios() {
        return mobiliarios;
    }

    public void setMobiliarios(List<Mobiliario> mobiliarios) {
        this.mobiliarios = mobiliarios;
    }

    public List<Mobiliario> getFilteredMobiliario() {
        return filteredMobiliario;
    }

    public void setFilteredMobiliario(List<Mobiliario> filteredMobiliario) {
        this.filteredMobiliario = filteredMobiliario;
    }

    public Procedimiento getPro() {
        return pro;
    }

    public void setPro(Procedimiento pro) {
        this.pro = pro;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }
    
    public String getValorBuscado() {
        return valorBuscado;
    }

    public void setValorBuscado(String valorBuscado) {
        this.valorBuscado = valorBuscado.toUpperCase();
    }

    public int getOpcionSelect() {
        return opcionSelect;
    }

    public void setOpcionSelect(int opcionSelect) {
        this.opcionSelect = opcionSelect;
    }

    public void valueChange(ValueChangeEvent event)throws AbortProcessingException {
	int noEvento=(int) event.getNewValue();
        System.out.println("valueChange : "+noEvento);
	mobiliarios=null;
        opcionSelect=noEvento;
        operacionesMobiliario=new OperacionesMobiliario();
        if(opcionSelect==4||opcionSelect==5)
        {departamentos=depdao.traeRegistrosDepartamentoMobiliario(accesoC.getNoUsuario());}
	}
    
    public void CargaBusqueda(String ob) throws SQLException {
        if(operacionesMobiliario!=null){
            operacionesMobiliario.setNumeroCarga(bitdao.getSeqNumCarga());
            operacionesMobiliario.setNoUsuarioOperacion(accesoC.getNoUsuario());
            if(opcionSelect==3 || opcionSelect==4){
            if(operacionesMobiliario.getNoPersonalBm()!=null){
             bitdao.consultaMobiliario(operacionesMobiliario,opcionSelect);
             mobiliarios = bitdao.traeRegistrosTempMobiliario(operacionesMobiliario.getNumeroCarga());
             if(mobiliarios.isEmpty()){msg.info("Información:", "No se encontro registros del personal");}
             }else{msg.warn("Atención:", "Ingresar Personal");}
            }
            if(opcionSelect==5){
             operacionesMobiliario.setNoPersonalBm(0);
             bitdao.consultaMobiliario(operacionesMobiliario,opcionSelect);
             mobiliarios = bitdao.traeRegistrosTempMobiliario(operacionesMobiliario.getNumeroCarga());
             if(mobiliarios.isEmpty()){msg.info("Información:", "No se encontro registros del departamento");}
             }
        }else{
        msg.warn("Atención:", "Ingresar Datos");
        }
    }
    
    public void CargaVentanaOperacion(String ob) {
        PrimeFaces.current().ajax().update(":formMobiliario");
        PrimeFaces.current().executeScript("PF('dlgmobiliario').show();");
    }


    public void ejecutarOperacion() throws SQLException {
        if(!mobiliariosSeleccionados.isEmpty()){
        int valor = bitdao.asignaMobUsuario(mobiliariosSeleccionados);
        if (valor >= 1) {
            pro = bitdao.modificaMobiliario(operacionesMobiliario,opcionSelect);
            if(pro.getError()!=-1){
                if(opcionSelect==4){
                msg.info("Procesado:", "Se asigno "+valor+" Objeto(s) a ["+operacionesMobiliario.getNomPersonalBm()+
                        "] en el departamento ["+mobiliariosSeleccionados.get(0).getDepartamento()+"]");
                }else{
                msg.info("Procesado:", "Se dio de baja "+valor+" Objeto(s) a ["+operacionesMobiliario.getNomPersonalBm()+"]");
                }
            } else {
                msg.warn("Error:", "No se ejecuto la operacion: "+pro.getMensaje());
            }
        } else {
            msg.warn("Error:", "No se guardo la informacion");
        }}
        else{msg.warn("Alerta:", "No hay mobiliario seleccionado.");}
        PrimeFaces.current().executeScript("PF('dlgmobiliario').hide();");
        init();
    }

     public void asignaNoPersonal(Personal per) {
        Integer noPer = per.getNoPersonalBm();
        System.out.println("asignaNoPersonal()" + noPer);
        operacionesMobiliario.setNoPersonalBm(noPer);
        operacionesMobiliario.setNomPersonalBm(per.getNombre()+" "+per.getAp1()+" "+per.getAp2());
        PrimeFaces.current().executeScript("PF('dlgasignarper').hide();");
    }

   public void asignapersonalBusqueda(String valor) {
        if (!valor.isEmpty()) {
            personal = pdao.traeRegistrosPersonalBusqueda(opcionSelect,accesoC.getNoUsuario(),valor);
            PrimeFaces.current().executeScript("PF('dlgasignarper').show();");
            PrimeFaces.current().ajax().update(":formAsignarPer");
            valorBuscado = null;
        } else {
            personal = null;
            PrimeFaces.current().ajax().update(":formAsignarPer");
            valorBuscado = null;
        }

    }
    
    public void generarReporte() throws ParseException, FileNotFoundException{
    ReportesControl rc = new ReportesControl();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    if(fecha==null){Date fechaActual = new Date(); fecha=fechaActual;}
    String fechaReporte = format.format(fecha);
    file=rc.generaReporteJasper(operacionesMobiliario.getIdDepartamento(),fechaReporte);
    fecha=null;
    }
    

    public void cancelarActualizar() {
        PrimeFaces.current().executeScript("PF('dlgmodificar').hide();");
    }

    public void cancelarEliminar() {
        PrimeFaces.current().executeScript("PF('dlgeliminar').hide();");
    }
    
    public void cancelarAsignarPersonal() {
        PrimeFaces.current().executeScript("PF('dlgasignarper').hide();");
    }
    public void cancelarAsignarEnlace() {
        PrimeFaces.current().executeScript("PF('dlgasignarenla').hide();");
    }
    public AccesoControl getAccesoC() {
        return accesoC;
    }

    public void setAccesoC(AccesoControl accesoC) {
        this.accesoC = accesoC;
    }


}
