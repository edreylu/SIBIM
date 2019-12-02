/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kproveedor;
/**
 *
 * @author usuario
 */
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProveedorDAO extends conexion.ConexionOracle implements Serializable {

    public int insertaProveedor(Proveedor proveedor) {

        ResultSet rs = null;
        int existe = 0;
        int id = 0;
        int regreso = 0;


        final String query = "insert into kproveedor (IDPROVEEDOR, \n"
                + "                             NOMBRE, \n"
                + "                                RFC, \n"
                + "                          DIRECCION, \n"
                + "                             CIUDAD, \n"
                + "                           TELEFONO, \n"
                + "                      OBSERVACIONES, \n"
                + "                           IDESTATUS) \n"
                + "                            values (?,?,?,?,?,?,?,1)";

        final String queryActualizaFolio = "update FOLIO set FOLIO = ? where TABLA = 'KPROVEEDOR'";

        try {
      
            super.abrirConexion();


            regreso = super.getPreparedStatement(query, new Object[]{proveedor.getIdProveedor(),
                proveedor.getNombre(),
                proveedor.getRfc(),
                proveedor.getDireccion(),
                proveedor.getCiudad(),
                proveedor.getTelefono(),
                proveedor.getObservaciones()
            }).executeUpdate();



        } catch (SQLException e) {
            System.out.println("Error al insertar proveedor: " + e.getMessage());
            regreso = 0;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error..." + e.getMessage());
            }
            super.cerrarConexion();
        }

        return regreso;
    }

    public List<Proveedor> traeRegistrosProveedor(int valor) {
        List<Proveedor> listaProveedor;
        System.out.println("Entro a cargar la lista de registros proveedor");
        Proveedor proveedor = null;
        ResultSet rs = null;
        String query = null;
        String continuacion = valor == 1 ? " WHERE IDESTATUS = 1" : "";
        query = "SELECT IDPROVEEDOR,\n"
                + "  NOMBRE,\n"
                + "  RFC,\n"
                + "  DIRECCION,\n"
                + "  CIUDAD,\n"
                + "  TELEFONO,\n"
                + "  OBSERVACIONES,\n"
                + "  IDESTATUS\n"
                + "FROM KPROVEEDOR "+continuacion+" ORDER BY 1 ";

        try {
            listaProveedor = new ArrayList<>();
            super.abrirConexion();
            rs = super.getPreparedStatement(query).executeQuery();

            while (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("IDPROVEEDOR"));
                proveedor.setNombre(rs.getString("NOMBRE"));
                proveedor.setRfc(rs.getString("RFC"));
                proveedor.setDireccion(rs.getString("DIRECCION"));
                proveedor.setCiudad(rs.getString("CIUDAD"));
                proveedor.setTelefono(rs.getString("TELEFONO"));
                proveedor.setObservaciones(rs.getString("OBSERVACIONES"));
                proveedor.setIdEstatus(rs.getInt("IDESTATUS"));

                listaProveedor.add(proveedor);

            }
            System.out.println("listaProveedor.size() = " + listaProveedor.size());
        } catch (SQLException e) {
            System.out.println("Error en listaProveedor() " + e.getMessage());
            listaProveedor = null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en listaProveedor() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return listaProveedor;
    }

    public List<Proveedor> traeRegistrosProveedorBusqueda(String valor) {
        List<Proveedor> listaProveedor;
        System.out.println("Entro a cargar la lista de registros proveedor busqueda");
        Proveedor proveedor = null;
        ResultSet rs = null;
        String query = null;
        query = "SELECT IDPROVEEDOR,\n"
                + "  NOMBRE,\n"
                + "  RFC,\n"
                + "  DIRECCION,\n"
                + "  CIUDAD,\n"
                + "  TELEFONO,\n"
                + "  OBSERVACIONES,\n"
                + "  IDESTATUS\n"
                + "FROM KPROVEEDOR WHERE NOMBRE LIKE '%?%' OR RFC LIKE '%?%'";

        System.out.println(query);
        try {
            listaProveedor = new ArrayList<>();
            super.abrirConexion();
            rs = super.getPreparedStatement(query).executeQuery();

            while (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("IDPROVEEDOR"));
                proveedor.setNombre(rs.getString("NOMBRE"));
                proveedor.setRfc(rs.getString("rfc"));
                proveedor.setDireccion(rs.getString("DIRECCION"));
                proveedor.setCiudad(rs.getString("CIUDAD"));
                proveedor.setTelefono(rs.getString("TELEFONO"));
                proveedor.setObservaciones(rs.getString("OBSERVACIONES"));
                proveedor.setIdEstatus(rs.getInt("IDESTATUS"));
                listaProveedor.add(proveedor);
            }
            System.out.println("listaProveedorBusqueda.size() = " + listaProveedor.size());
        } catch (SQLException e) {
            System.out.println("Error en listaProveedorBusqueda() " + e.getMessage());
            listaProveedor = null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en listaProveedorBusqueda() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return listaProveedor;
    }

    public int actualizaProveedor(Proveedor proveedor) {

        int valor = 0;
        final String query = "update kproveedor set nombre = ?, \n"
                + "                         rfc = ?, \n"
                + "                   direccion = ?, \n"
                + "                      ciudad = ?,\n"
                + "                    telefono = ?,\n"
                + "               observaciones = ? \n"
                + "               where idProveedor = ?";

        try {
            super.abrirConexion();
            valor = super.getPreparedStatement(query, new Object[]{proveedor.getNombre(),
                proveedor.getRfc(),
                proveedor.getDireccion(),
                proveedor.getCiudad(),
                proveedor.getTelefono(),
                proveedor.getObservaciones(),
                proveedor.getIdProveedor()}).executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar proveedor() " + e.getMessage());
        } finally {

            super.cerrarConexion();
        }
        return valor;
    }
    
    public int eliminaProveedor(Proveedor proveedor, int opcion) {
        int valor = 0;
        ResultSet rs = null;
        final String query = "UPDATE kproveedor set IDESTATUS = ? WHERE idProveedor = ? ";
        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{opcion,proveedor.getIdProveedor()}).executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en eliminaProveedor() " + e.getMessage());
        } finally {
            try {
                if (null != rs) {
                    valor = 1;
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en eliminaProveedor() " + e.getMessage());

            }
            super.cerrarConexion();
        }
        return valor;
    }
    
    public int getNumeroSiguiente() {
        int id = 0;
        ResultSet rs = null;
        final String query = "select nvl(max(IDPROVEEDOR),0)+ 1 from KPROVEEDOR ";
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

}