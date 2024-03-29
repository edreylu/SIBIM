/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 */
public class UrDAO extends conexion.ConexionOracle implements java.io.Serializable {

    public int insertaUr(Ur ur) {
        System.out.println("Entro a insertar ");
        int valor=0;
        ResultSet rs = null;
        final String query = "INSERT INTO UR (IDUR, \n" +
                                "       CLAVEUR, \n" +
                                "       UR, \n" +
                                "       NOPERSONALBM, \n" +
                                "       FECHAALTA, \n" +
                                "       NOUSUARIOALTA, \n" +
                                "       FECHAMODIF, \n" +
                                "       NOUSUARIOMODIF, \n" +
                                "       FECHABAJA, \n" +
                                "       NOUSUARIOBAJA, \n" +
                                "       IDESTATUS) "
                + "VALUES (?,?,?,?,SYSDATE,?,null,null,null,null,1)";
        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{
                ur.getIdUr(),
                ur.getClaveUr(),
                ur.getUr(),
                ur.getNoPersonalBm(),
                ur.getNoUsuarioAlta()
                }
            ).executeQuery();
            
            
        } catch (SQLException e) {
            System.out.println("Error en insertaUr() " + e.getMessage());
            
        } finally {
            try {
                if (null != rs) {
                    valor=1;
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en insertaUr() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        System.out.println("valor: " + valor);
        return valor;
    }
    
    public int actualizaUr(Ur ur) {
        int valor=0;
        ResultSet rs = null;
        
        final String query = "UPDATE UR set CLAVEUR = ?, \n" +
                            "       UR = ?, \n" +
                            "       NOPERSONALBM = ?, \n" +
                            "       FECHAMODIF = SYSDATE, \n" +
                            "       NOUSUARIOMODIF = ? \n" +
                            "       where IDUR = ? ";

        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{
                ur.getClaveUr(),
                ur.getUr(),
                ur.getNoPersonalBm(),
                ur.getNoUsuarioModif(),
                ur.getIdUr()
            }).executeQuery();
            
            
        } catch (SQLException e) {
            System.out.println("Error en actualizaUr() " + e.getMessage());
        } finally {
            try {
                if (null != rs) {
                    valor=1;
                    rs.close();
                }
                super.cerrarConexion();
            } catch (SQLException e) {
                System.out.println("Error en actualizaUr() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return valor;
    }

    public int eliminaUr(Ur ur, int opcion) {
        int valor=0;
        ResultSet rs = null;
        final String query = "UPDATE UR set IDESTATUS = ?, FECHABAJA = SYSDATE, NOUSUARIOBAJA = ? WHERE IDUR = ? ";
        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{opcion,ur.getNoUsuarioBaja(),ur.getIdUr()}).executeQuery();
            
        } catch (SQLException e) {
            System.out.println("Error en eliminaUr() " + e.getMessage());
        } finally {
            try {
                if (null != rs) {
                    valor=1;
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en eliminaUr() " + e.getMessage());
                
            }
            super.cerrarConexion();
        }
        return valor;
    }

    public int getNoUrSiguiente() {
        int noSiguiente = 0;
        ResultSet rs = null;
        final String query = "select nvl(max(IDUR),0)+ 1 from UR ";
        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query).executeQuery();
            if (rs.next()) {
                noSiguiente = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error en getNoUrSiguiente() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en getNoUrSiguiente() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return noSiguiente;
    }

    
    public List<Ur> traeRegistros() {
        List<Ur> listaUr;
        System.out.println("Entro a cargar la lista de registros listaUrC");
        Ur ur = null;
        ResultSet rs = null;
        String query = null;
        query = "select UR.IDUR, \n" +
                "       UR.CLAVEUR, \n" +
                "       UR.UR, \n" +
                "       UR.NOPERSONALBM, \n"
                + "     (select PE.NOMBRE||' '||PE.AP1||' '||PE.AP2 from PERSONAL PE where PE.NOPERSONALBM = UR.NOPERSONALBM) RESPONSABLE," +
                "       UR.IDESTATUS \n" +
                "       from UR UR";

        try {
            listaUr = new java.util.ArrayList<>();
            super.abrirConexion();
            rs = super.getPreparedStatement(query).executeQuery();

            while (rs.next()) {
                ur = new Ur();
                ur.setIdUr(rs.getInt(1));
                ur.setClaveUr(rs.getString(2));
                ur.setUr(rs.getString(3));
                ur.setNoPersonalBm(rs.getInt(4)==0?null:rs.getInt(4));
                ur.setNomPersonal(rs.getString(5)==null?"NO TIENE RESPONSABLE":rs.getString(5));
                ur.setIdEstatus(rs.getInt(6));
                listaUr.add(ur);

            }
            System.out.println("listaUr.size() = " + listaUr.size());
        } catch (SQLException e) {
            System.out.println("Error en listaUr() " + e.getMessage());
            listaUr = null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en listaUr() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return listaUr;
    }
    
}
