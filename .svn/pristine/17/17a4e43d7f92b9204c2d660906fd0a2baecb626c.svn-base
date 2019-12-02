/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kformaadquisicion;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class KformaadquisicionDAO extends conexion.ConexionOracle implements Serializable {

   

    public int insertaKformaadquisicion(Kformaadquisicion formaadquisicion) {
        System.out.println("Entro a insertar ");
        int valor = 0;
        ResultSet rs = null;
        final String query = "INSERT INTO KFORMAADQUISICION (IDFORMAADQUISICION, FORMAADQUISICION, OBSERVACIONES, FECHAREGISTRO, IDESTATUS) "
                + "VALUES (?,?,?,SYSDATE,1)";
        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{
                formaadquisicion.getIdFormaAdquisicion(),
                formaadquisicion.getFormaadquisicion(),
                formaadquisicion.getObservaciones()
            }
            ).executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en insertaKformaadquisicion() " + e.getMessage());

        } finally {
            try {
                if (null != rs) {
                    valor = 1;
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en insertaKformaadquisicion() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        System.out.println("valor: " + valor);
        return valor;
    }

    public int actualizaKformaadquisicion(Kformaadquisicion formaadquisicion) {
        int valor = 0;
        ResultSet rs = null;
        final String query = "UPDATE KFORMAADQUISICION set FORMAADQUISICION = ? , OBSERVACIONES = ? , FECHAREGISTRO = SYSDATE "
                + " where IDFORMAADQUISICION = ? ";

        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{
                formaadquisicion.getFormaadquisicion(),
                formaadquisicion.getObservaciones(),
                formaadquisicion.getIdFormaAdquisicion()}).executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en actualizaKformaadquisicion() " + e.getMessage());
        } finally {
            try {
                if (null != rs) {
                    valor = 1;
                    rs.close();
                }

            } catch (SQLException e) {
                System.out.println("Error en actualizaKformaadquisicion() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return valor;
    }

    public int eliminaKformaadquisicion(Kformaadquisicion formaadquisicion, int opcion) {
        int valor = 0;
        ResultSet rs = null;
        final String query = "UPDATE KFORMAADQUISICION set IDESTATUS = ? WHERE IDFORMAADQUISICION = ? ";
        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{opcion,formaadquisicion.getIdFormaAdquisicion()}).executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en eliminaKformaadquisicion() " + e.getMessage());
        } finally {
            try {
                if (null != rs) {
                    valor = 1;
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en eliminaKformaadquisicion() " + e.getMessage());

            }
            super.cerrarConexion();
        }
        return valor;
    }

    public int getNumeroSiguiente() {
        int id=0;
        ResultSet rs = null;
        final String query = "select nvl(max(IDFORMAADQUISICION),0)+ 1 from KFORMAADQUISICION ";
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

    public List<Kformaadquisicion> traeRegistros(int valor) {
        List<Kformaadquisicion> listaKformaadquisicion;
        System.out.println("Entro a cargar listaKformaadquisicion");
        Kformaadquisicion formaadquisicion = null;
        ResultSet rs = null;
        String query = null;
        String continuacion = valor == 1 ? " WHERE IDESTATUS = 1" : "";
        query = "select IDFORMAADQUISICION, FORMAADQUISICION, OBSERVACIONES, FECHAREGISTRO, IDESTATUS from KFORMAADQUISICION "+continuacion+" ORDER BY 1";
                
        try {
            listaKformaadquisicion = new ArrayList<>();
            super.abrirConexion();
            rs = super.getPreparedStatement(query).executeQuery();

            while (rs.next()) {
                formaadquisicion = new Kformaadquisicion();
                formaadquisicion.setIdFormaAdquisicion(rs.getInt("IDFORMAADQUISICION"));
                formaadquisicion.setFormaadquisicion(rs.getString("FORMAADQUISICION"));
                formaadquisicion.setObservaciones(rs.getString("OBSERVACIONES"));
                formaadquisicion.setFechaRegistro(rs.getString("FECHAREGISTRO"));
                formaadquisicion.setIdEstatus(rs.getInt("IDESTATUS"));
                listaKformaadquisicion.add(formaadquisicion);

            }
            System.out.println("listaKformaadquisicion.size() = " + listaKformaadquisicion.size());
        } catch (SQLException e) {
            System.out.println("Error en listaKformaadquisicion() " + e.getMessage());
            listaKformaadquisicion = null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en listaKformaadquisicion() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return listaKformaadquisicion;
    }

    
}
