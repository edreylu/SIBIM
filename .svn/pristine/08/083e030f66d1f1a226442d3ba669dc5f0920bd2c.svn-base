/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parametros;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 *
 */
public class ParametrosDAO extends conexion.ConexionOracle implements java.io.Serializable {

    
    public int actualizaParametros(Parametros par) {
        int valor=0;
        ResultSet rs = null;
        
        final String query = "UPDATE PARAMETROS set TIEMPOMAXIMOMODIF =? , MOSTRARINACTIVOS = ?,  "+
                             " NOPERSONALBM = ?,\n" +
                                    "FUNCION = ?,\n" +
                                    "IDEVENTO = ?,\n" +
                                    "NUMDEPENDENCIA =?,\n" +
                                    "DEPENDENCIA = ?";

        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{
                par.getTiempoMaximoModif(),
                par.getMostrarInactivos(),
                par.getNoPersonalBm(),
                par.getFuncion(),
                par.getIdEvento(),
                par.getNumDependencia(),
                par.getDependencia()}).executeQuery();
            
            
        } catch (SQLException e) {
            System.out.println("Error en actualizaParametros() " + e.getMessage());
        } finally {
            try {
                if (null != rs) {
                    valor=1;
                    rs.close();
                }
                super.cerrarConexion();
            } catch (SQLException e) {
                System.out.println("Error en actualizaParametros() " + e.getMessage());
            }
        }
        return valor;
    }


    public Parametros parametros() {
        Parametros parametros = null;
        ResultSet rs = null;
        final String query = "select PA.IDPARAMETRO,\n" +
                                    "PA.TIEMPOMAXIMOMODIF,\n" +
                                    "PA.MOSTRARINACTIVOS,\n" +
                                    "PA.LOGO,\n" +
                                    "PA.NOPERSONALBM, "+
                                    " (select PE.NOMBRE||' '||PE.AP1||' '||PE.AP2 from PERSONAL PE where PE.NOPERSONALBM = PA.NOPERSONALBM) NOMPERSONAL,\n" +
                                    "PA.FUNCION,\n" +
                                    "PA.IDEVENTO,\n" +
                                    "PA.NUMDEPENDENCIA,\n" +
                                    "PA.DEPENDENCIA "+ 
                                    " from PARAMETROS PA ";
        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query).executeQuery();
            StreamedContent myImage;
            if (rs.next()) {
                parametros = new Parametros();
                parametros.setIdParametro(rs.getInt(1));
                parametros.setTiempoMaximoModif(rs.getInt(2));
                parametros.setMostrarInactivos(rs.getString(3));
                parametros.setImagen(rs.getBlob(4));
                parametros.setNoPersonalBm(rs.getInt(5));
                parametros.setNomPersonal(rs.getString(6));
                parametros.setFuncion(rs.getString(7));
                parametros.setIdEvento(rs.getInt(8));
                parametros.setNumDependencia(rs.getInt(9));
                parametros.setDependencia(rs.getString(10));
            }
        } catch (SQLException e) {
            System.out.println("Error en parametros() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en parametros() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return parametros;
    }

    public List<Parametros> traeRegistrosParametros() {
        List<Parametros> listaParametros;
        System.out.println("Entro a cargar la lista de registros listaParametros");
        Parametros par = null;
        ResultSet rs = null;
        String query = null;
        query = "select TIEMPOMAXIMOMODIF,MOSTRARINACTIVOS,LOGO from PARAMETROS ";
        try {
            listaParametros = new java.util.ArrayList<>();
            super.abrirConexion();
            rs = super.getPreparedStatement(query).executeQuery();
            StreamedContent myImage;
            while (rs.next()) {
                par = new Parametros();
                par.setTiempoMaximoModif(rs.getInt(1));
                par.setMostrarInactivos(rs.getString(2));
                InputStream inputStream = rs.getBlob(3).getBinaryStream();
                myImage = new DefaultStreamedContent(inputStream, "image/png");
                par.setFile(myImage);
                listaParametros.add(par);

            }
            System.out.println("listaParametros.size() = " + listaParametros.size());
        } catch (SQLException e) {
            System.out.println("Error en listaParametros() " + e.getMessage());
            listaParametros = null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en listaParametros() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return listaParametros;
    }
    
    
}
