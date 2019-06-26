/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hugoluna
 */
public class Conexion {
      //atributos
    private final String base = "chat";
    private final String user = "hugo";
    private final String password = "hugo1199";
    private final String url = "jdbc:mysql://192.168.43.73:3306/"+base;
    private Connection con = null;
    
    
    /***
     * Obtener la conexion a la base de datos
     * @return 
     */
    public Connection getConnection(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        }catch(SQLException e){
            System.err.println(e);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
                
        return con;
        
    }
}
