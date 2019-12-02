/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevento;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class KeventoDAO extends conexion.ConexionOracle implements Serializable {

   

    public int insertaKevento(Kevento evento) {
        System.out.println("Entro a insertar ");
        int valor = 0;
        ResultSet rs = null;
        final String query = "INSERT INTO KEVENTO (IDEVENTO, EVENTO, OBSERVACIONES, IDESTATUS) "
                + "VALUES (?,?,?,1)";
        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{
                evento.getIdEvento(),
                evento.getEvento(),
                evento.getObservaciones()
            }
            ).executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en insertaKevento() " + e.getMessage());

        } finally {
            try {
                if (null != rs) {
                    valor = 1;
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en insertaKevento() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        System.out.println("valor: " + valor);
        return valor;
    }

    public int actualizaKevento(Kevento evento) {
        int valor = 0;
        ResultSet rs = null;
        final String query = "UPDATE KEVENTO set EVENTO = ? , OBSERVACIONES = ? "
                + " where IDEVENTO = ? ";

        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{
                evento.getEvento(),
                evento.getObservaciones(),
                evento.getIdEvento()}).executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en actualizaKevento() " + e.getMessage());
        } finally {
            try {
                if (null != rs) {
                    valor = 1;
                    rs.close();
                }

            } catch (SQLException e) {
                System.out.println("Error en actualizaKevento() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return valor;
    }

    public int eliminaKevento(Kevento evento, int opcion) {
        int valor = 0;
        ResultSet rs = null;
        final String query = "UPDATE KEVENTO set IDESTATUS = ? WHERE IDEVENTO = ? ";
        try {
            super.abrirConexion();
            rs = super.getPreparedStatement(query, new Object[]{opcion,evento.getIdEvento()}).executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en eliminaKevento() " + e.getMessage());
        } finally {
            try {
                if (null != rs) {
                    valor = 1;
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en eliminaKevento() " + e.getMessage());

            }
            super.cerrarConexion();
        }
        return valor;
    }

    public int getNumeroSiguiente() {
        int id=0;
        ResultSet rs = null;
        final String query = "select nvl(max(IDEVENTO),0)+ 1 from KEVENTO ";
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
    
    public int asignaKevento(int rol,List<Kevento> keventos) {
        System.out.println("Entro a asignaKevento ");
        System.out.println("no_rol: " + rol);
        ResultSet rs = null;
        int valor=0;
        String query = "";
        try {
            super.abrirConexion();
            for (Kevento x : keventos) {
                if(x.isEventoSeleccionado()){
                    query = "INSERT INTO rol_kevento (no_rol, idevento) "
                            + "VALUES ("+rol+","+x.getIdEvento()+")";
                    super.getPreparedStatement(query).executeQuery();
                    query="";
                    valor=valor+1;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en asignaKevento() " + e.getMessage());
            valor=-1;
        } finally {
            try {
                if (null != rs) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en asignaKevento() " + e.getMessage());
                valor=-1;
            }
            super.cerrarConexion();
        }
        return valor;
    }

    public List<Kevento> traeRegistros(int valor) {
        List<Kevento> listaKevento;
        System.out.println("Entro a cargar listaKevento");
        Kevento evento = null;
        ResultSet rs = null;
        String query = null;
        String continuacion = valor == 1 ? " WHERE IDESTATUS = 1" : "";
        query = "select IDEVENTO, EVENTO, OBSERVACIONES, IDESTATUS from KEVENTO "+continuacion+" ORDER BY 1";
                
        try {
            listaKevento = new ArrayList<>();
            super.abrirConexion();
            rs = super.getPreparedStatement(query).executeQuery();

            while (rs.next()) {
                evento = new Kevento();
                evento.setIdEvento(rs.getInt("IDEVENTO"));
                evento.setEvento(rs.getString("EVENTO"));
                evento.setObservaciones(rs.getString("OBSERVACIONES"));
                evento.setIdEstatus(rs.getInt("IDESTATUS"));
                listaKevento.add(evento);

            }
            System.out.println("listaKevento.size() = " + listaKevento.size());
        } catch (SQLException e) {
            System.out.println("Error en listaKevento() " + e.getMessage());
            listaKevento = null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en listaKevento() " + e.getMessage());
            }
            super.cerrarConexion();
        }
        return listaKevento;
    }

    
}
