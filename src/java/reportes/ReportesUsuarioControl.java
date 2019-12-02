/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import acceso.AccesoControl;
import departamento.Departamento;
import departamento.DepartamentoDAO;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.PrimeFaces;
import org.primefaces.model.StreamedContent;
import utilerias.Mensaje;

/**
 *
 * @author usuario
 */
@ManagedBean(name = "reportesUsuarioControl")
@SessionScoped
public class ReportesUsuarioControl implements Serializable {

    @ManagedProperty(value = "#{accesoC}")
    private AccesoControl accesoC;
    private ReportesControl reportesControl;
    private final ReportesDAO rdao;
    private final DepartamentoDAO depdao;
    private List<Reporte> reportes;
    private Reporte reporte;
    private Reporte reporteSeleccionado;
    private List<Reporte> filteredReporte;
    private List<Departamento> departamentos;
    private Date fecha;
    private int tipoReporte;
    public StreamedContent file;
    public String fechaReporte;
    private int dep;
    private final Mensaje msg = new Mensaje();

    public ReportesUsuarioControl() {
        rdao = new ReportesDAO();
        depdao = new DepartamentoDAO();
        reportesControl = new ReportesControl();
        reporte = new Reporte();
    }

    public void init(int noUsuario) {
        reportes = rdao.traeRegistrosConsulta(noUsuario);
        reporteSeleccionado = null;
    }

    public List<Reporte> getReportes() {
        return reportes;
    }

    public void setReportes(List<Reporte> reportes) {
        this.reportes = reportes;
    }

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public Reporte getReporteSeleccionado() {
        return reporteSeleccionado;
    }

    public void setReporteSeleccionado(Reporte reporteSeleccionado) {
        this.reporteSeleccionado = reporteSeleccionado;
    }

    public List<Reporte> getFilteredReporte() {
        return filteredReporte;
    }

    public void setFilteredReporte(List<Reporte> filteredReporte) {
        this.filteredReporte = filteredReporte;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(int tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public String getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(String fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public int getDep() {
        return dep;
    }

    public void setDep(int dep) {
        this.dep = dep;
    }
    
    public void CargaVentanaJasper() {
        departamentos = depdao.traeRegistrosDepartamentoMobiliario(accesoC.getNoUsuario());
        PrimeFaces.current().ajax().update(":formParametros2");
        PrimeFaces.current().executeScript("PF('dlgparametros2').show();");
    }

    public void generar(int val) throws ParseException, FileNotFoundException{
    System.out.println("reportes.ReportesControl.generar()"+val);
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    if(fecha==null){Date fechaActual = new Date(); fecha=fechaActual;}
    fechaReporte = format.format(fecha);
    if(val==1){
    file =reportesControl.generaExcelSibim(reporte,fechaReporte,accesoC.getClave());
    }
    else if(val==2){
    file = reportesControl.generaReporteJasper(dep,fechaReporte);
    }
    fechaReporte=null;
    fecha=null;
    dep=0;
    }
    
    public String formatoFecha(String fecha) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
        Date date = formatter.parse(fecha);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String resultado = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
        return resultado;
    }

    public AccesoControl getAccesoC() {
        return accesoC;
    }

    public void setAccesoC(AccesoControl accesoC) {
        this.accesoC = accesoC;
    }
    
    
    
}
