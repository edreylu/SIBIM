/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package korigenrecurso;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class KorigenRecursoDAO extends conexion.ConexionOracle implements Serializable {

   

    public int insertaOrigenRecurso(KorigenRecurso origenrecurso) {
        System.out.println("Entro a insertar ");
        int valor = 0;
        ResultSet rs = null;
        final String query = "INSERT INTO KORIGENRECURSO (IDORIGENRECURSO, DESCRIPCION, OBSERVACIONES, FECHAREGISTRO, IDESTATUS) "
                + "VALUES (?,?,?,SYSDATE,1)";
        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{
                origenrecurso.getIdOrigenRecurso(),
                origenrecurso.getDescripcion(),
                origenrecurso.getObservaciones()
            }
            ).executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en insertaOrigenRecurso() " + e.getMessage());

        } finally {
            try {
                if (null != rs) {
                    valor = 1;
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en insertaOrigenRecurso() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        System.out.println("valor: " + valor);
        return valor;
    }

    public int actualizaOrigenRecurso(KorigenRecurso origenrecurso) {
        int valor = 0;
        ResultSet rs = null;
        final String query = "UPDATE KORIGENRECURSO set DESCRIPCION = ? , OBSERVACIONES = ? , FECHAREGISTRO = SYSDATE "
                + " where IDORIGENRECURSO = ? ";

        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{
                origenrecurso.getDescripcion(),
                origenrecurso.getObservaciones(),
                origenrecurso.getIdOrigenRecurso()}).executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en actualizaOrigenRecurso() " + e.getMessage());
        } finally {
            try {
                if (null != rs) {
                    valor = 1;
                    rs.close();
                }

            } catch (SQLException e) {
                System.out.println("Error en actualizaOrigenRecurso() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return valor;
    }

    public int eliminaOrigenRecurso(KorigenRecurso origenrecurso, int opcion) {
        int valor = 0;
        ResultSet rs = null;
        final String query = "UPDATE KORIGENRECURSO set IDESTATUS = ? WHERE IDORIGENRECURSO = ? ";
        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{opcion,origenrecurso.getIdOrigenRecurso()}).executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en eliminaOrigenRecurso() " + e.getMessage());
        } finally {
            try {
                if (null != rs) {
                    valor = 1;
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en eliminaOrigenRecurso() " + e.getMessage());

            }
            super.cerrarConexion();
        }
        return valor;
    }

    public int getNumeroSiguiente() {
        int id=0;
        ResultSet rs = null;
        final String query = "select nvl(max(IDORIGENRECURSO),0)+ 1 from KORIGENRECURSO ";
        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query).executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error en getNumeroSiguiente() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en getNumeroSiguiente() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return id;
    }

    public List<KorigenRecurso> traeRegistros(int valor) {
        List<KorigenRecurso> listaKorigenRecurso;
        System.out.println("Entro a cargar listaKorigenRecurso");
        KorigenRecurso origenrecurso = null;
        ResultSet rs = null;
        String query = null;
        String continuacion = valor == 1 ? " WHERE IDESTATUS = 1" : "";
        query = "select IDORIGENRECURSO, DESCRIPCION, OBSERVACIONES, FECHAREGISTRO, IDESTATUS from KORIGENRECURSO "+continuacion+" ORDER BY 1";
                
        try {
            listaKorigenRecurso = new ArrayList<>();
            super.abrirConexion();
            rs = super.getPreparedStatement(query).executeQuery();

            while (rs.next()) {
                origenrecurso = new KorigenRecurso();
                origenrecurso.setIdOrigenRecurso(rs.getInt("IDORIGENRECURSO"));
                origenrecurso.setDescripcion(rs.getString("DESCRIPCION"));
                origenrecurso.setObservaciones(rs.getString("OBSERVACIONES"));
                origenrecurso.setFechaRegistro(rs.getString("FECHAREGISTRO"));
                origenrecurso.setIdEstatus(rs.getInt("IDESTATUS"));
                listaKorigenRecurso.add(origenrecurso);

            }
            System.out.println("listaKorigenRecurso.size() = " + listaKorigenRecurso.size());
        } catch (SQLException e) {
            System.out.println("Error en listaKorigenRecurso() " + e.getMessage());
            listaKorigenRecurso = null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en listaKorigenRecurso() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return listaKorigenRecurso;
    }

    
}
