/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

/**
 *
 * @author usuario
 */
public class Reporte {
    private int idReporte;
    private String reporte;
    private String query;
    private int idEstaus;
    private boolean reporteSeleccionado;

    public Reporte() {
    }

    public Reporte(int idReporte, String reporte, String query, int idEstaus, boolean reporteSeleccionado) {
        this.idReporte = idReporte;
        this.reporte = reporte;
        this.query = query;
        this.idEstaus = idEstaus;
        this.reporteSeleccionado = reporteSeleccionado;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getIdEstaus() {
        return idEstaus;
    }

    public void setIdEstaus(int idEstaus) {
        this.idEstaus = idEstaus;
    }

    public boolean isReporteSeleccionado() {
        return reporteSeleccionado;
    }

    public void setReporteSeleccionado(boolean reporteSeleccionado) {
        this.reporteSeleccionado = reporteSeleccionado;
    }
    
    
}
