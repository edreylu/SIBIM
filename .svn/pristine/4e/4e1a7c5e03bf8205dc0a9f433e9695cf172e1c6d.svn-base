/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knivelarea;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class KnivelAreaDAO extends conexion.ConexionOracle implements Serializable {

   

    public int insertaKnivelArea(KnivelArea evento) {
        System.out.println("Entro a insertar ");
        int valor = 0;
        ResultSet rs = null;
        final String query = "INSERT INTO KNIVELAREA (IDNIVELAREA, DESCRIPCIONNIVEL, ORDEN, OBSERVACIONES, IDESTATUS) "
                + "VALUES (?,?,?,?,1)";
        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{
                evento.getIdNivelArea(),
                evento.getDescripcion(),
                evento.getOrden(),
                evento.getObservaciones()
            }
            ).executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en insertaKnivelArea() " + e.getMessage());

        } finally {
            try {
                if (null != rs) {
                    valor = 1;
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en insertaKnivelArea() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        System.out.println("valor: " + valor);
        return valor;
    }

    public int actualizaKnivelArea(KnivelArea evento) {
        int valor = 0;
        ResultSet rs = null;
        final String query = "UPDATE KNIVELAREA set DESCRIPCIONNIVEL = ? , ORDEN = ?, OBSERVACIONES = ? "
                + " where IDNIVELAREA = ? ";

        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{
                evento.getDescripcion(),
                evento.getOrden(),
                evento.getObservaciones(),
                evento.getIdNivelArea()}).executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en actualizaKnivelArea() " + e.getMessage());
        } finally {
            try {
                if (null != rs) {
                    valor = 1;
                    rs.close();
                }

            } catch (SQLException e) {
                System.out.println("Error en actualizaKnivelArea() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return valor;
    }

    public int eliminaKnivelArea(KnivelArea evento, int opcion) {
        int valor = 0;
        ResultSet rs = null;
        final String query = "UPDATE KNIVELAREA set IDESTATUS = ? WHERE IDNIVELAREA = ? ";
        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{opcion,evento.getIdNivelArea()}).executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en eliminaKnivelArea() " + e.getMessage());
        } finally {
            try {
                if (null != rs) {
                    valor = 1;
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en eliminaKnivelArea() " + e.getMessage());

            }
            super.cerrarConexion();
        }
        return valor;
    }

    public int getNumeroSiguiente() {
        int id=0;
        ResultSet rs = null;
        final String query = "select nvl(max(IDNIVELAREA),0)+ 1 from KNIVELAREA ";
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

    public List<KnivelArea> traeRegistros(int valor) {
        List<KnivelArea> listaKnivelArea;
        System.out.println("Entro a cargar listaKnivelArea");
        KnivelArea nivelArea = null;
        ResultSet rs = null;
        String query = null;
        String continuacion = valor == 1 ? " WHERE IDESTATUS = 1" : "";
        query = "select IDNIVELAREA, DESCRIPCIONNIVEL, ORDEN, OBSERVACIONES, IDESTATUS from KNIVELAREA "+continuacion+" ORDER BY 1";
                
        try {
            listaKnivelArea = new ArrayList<>();
            super.abrirConexion();
            rs = super.getPreparedStatement(query).executeQuery();

            while (rs.next()) {
                nivelArea = new KnivelArea();
                nivelArea.setIdNivelArea(rs.getInt("IDNIVELAREA"));
                nivelArea.setDescripcion(rs.getString("DESCRIPCIONNIVEL"));
                nivelArea.setOrden(rs.getString("ORDEN"));
                nivelArea.setObservaciones(rs.getString("OBSERVACIONES"));
                nivelArea.setIdEstatus(rs.getInt("IDESTATUS"));
                listaKnivelArea.add(nivelArea);

            }
            System.out.println("listaKnivelArea.size() = " + listaKnivelArea.size());
        } catch (SQLException e) {
            System.out.println("Error en listaKnivelArea() " + e.getMessage());
            listaKnivelArea = null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en listaKnivelArea() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return listaKnivelArea;
    }

    
}
