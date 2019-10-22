/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.sql.ResultSet;

/**
 *
 * @author usuario
 */
public class ReportesDAO extends conexion.ConexionOracle implements java.io.Serializable{
    
    
    public ResultSet getConsulta(String query)
	{
		ResultSet cursor=null;
                System.out.println(query);
		try
		{
                    super.abrirConexion();
			
                        cursor = super.getPreparedStatement(query).executeQuery();
		}
		catch(Exception e)
		{System.out.println("Error en getConsulta() " + e.getMessage());}
		return cursor;
	}
}
