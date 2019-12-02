/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kestadobien;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class KestadoBienDAO extends conexion.ConexionOracle implements Serializable {

   

    public int insertaEstadoBien(KestadoBien estadobien) {
        System.out.println("Entro a insertar ");
        int valor = 0;
        ResultSet rs = null;
        final String query = "INSERT INTO KESTADODELBIEN (IDESTADODELBIEN, ESTADODELBIEN, OBSERVACIONES, FECHAREGISTRO, IDESTATUS) "
                + "VALUES (?,?,?,SYSDATE,1)";
        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{
                estadobien.getIdEstadoDelBien(),
                estadobien.getEstadoDelBien(),
                estadobien.getObservaciones()
            }
            ).executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en insertaEstadoBien() " + e.getMessage());

        } finally {
            try {
                if (null != rs) {
                    valor = 1;
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en insertaEstadoBien() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        System.out.println("valor: " + valor);
        return valor;
    }

    public int actualizaEstadoBien(KestadoBien estadobien) {
        int valor = 0;
        ResultSet rs = null;
        final String query = "UPDATE KESTADODELBIEN set ESTADODELBIEN = ? , OBSERVACIONES = ? , FECHAREGISTRO = SYSDATE "
                + " where IDESTADODELBIEN = ? ";

        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{
                estadobien.getEstadoDelBien(),
                estadobien.getObservaciones(),
                estadobien.getIdEstadoDelBien()}).executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en actualizaEstadoBien() " + e.getMessage());
        } finally {
            try {
                if (null != rs) {
                    valor = 1;
                    rs.close();
                }

            } catch (SQLException e) {
                System.out.println("Error en actualizaEstadoBien() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return valor;
    }

    public int eliminaEstadoBien(KestadoBien estadobien, int opcion) {
        int valor = 0;
        ResultSet rs = null;
        final String query = "UPDATE KESTADODELBIEN set IDESTATUS = ? WHERE IDESTADODELBIEN = ? ";
        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{opcion,estadobien.getIdEstadoDelBien()}).executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en eliminaEstadoBien() " + e.getMessage());
        } finally {
            try {
                if (null != rs) {
                    valor = 1;
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en eliminaEstadoBien() " + e.getMessage());

            }
            super.cerrarConexion();
        }
        return valor;
    }

    public int getNumeroSiguiente() {
        int id=0;
        ResultSet rs = null;
        final String query = "select nvl(max(IDESTADODELBIEN),0)+ 1 from KESTADODELBIEN ";
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

    public List<KestadoBien> traeRegistros(int valor) {
        List<KestadoBien> listaKestadoBien;
        System.out.println("Entro a cargar listaKestadoBien");
        KestadoBien estadobien = null;
        ResultSet rs = null;
        String query = null;
        String continuacion = valor == 1 ? " WHERE IDESTATUS = 1" : "";
        query = "select IDESTADODELBIEN, ESTADODELBIEN, OBSERVACIONES, FECHAREGISTRO, IDESTATUS from KESTADODELBIEN "+continuacion+" ORDER BY 1";

        try {
            listaKestadoBien = new ArrayList<>();
            super.abrirConexion();
            rs = super.getPreparedStatement(query).executeQuery();

            while (rs.next()) {
                estadobien = new KestadoBien();
                estadobien.setIdEstadoDelBien(rs.getInt("IDESTADODELBIEN"));
                estadobien.setEstadoDelBien(rs.getString("ESTADODELBIEN"));
                estadobien.setObservaciones(rs.getString("OBSERVACIONES"));
                estadobien.setFechaRegistro(rs.getString("FECHAREGISTRO"));
                estadobien.setIdEstatus(rs.getInt("IDESTATUS"));
                listaKestadoBien.add(estadobien);

            }
            System.out.println("listaKestadoBien.size() = " + listaKestadoBien.size());
        } catch (SQLException e) {
            System.out.println("Error en listaKestadoBien() " + e.getMessage());
            listaKestadoBien = null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en listaKestadoBien() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return listaKestadoBien;
    }

    
}
