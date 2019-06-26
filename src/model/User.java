/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Security;

/**
 *
 * @author hugoluna
 */
public class User {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User() {
    }

    public User(int id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean loginUser(User user) {

        String query = "SELECT * FROM user where email = ? AND password = ?";
        boolean checkUser = false;

        try {
            Connection conexion = new Conexion().getConnection();
            PreparedStatement sentencia = conexion.prepareStatement(query);
            sentencia.setString(1, user.getEmail());
            sentencia.setString(2, Security.cifrar(user.getPassword()));
            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                checkUser = true;
            }
        } catch (SQLException e) {

        }

        return checkUser;

    }

    public boolean registerUser(User user) {

        boolean aux = false;
        String consulta = "INSERT INTO user (name , email, phone, password )  "
                + "VALUES (?, ? ,? ,? )";

        try {
            Connection conexion = (Connection) new Conexion().getConnection();

            PreparedStatement sentencia = conexion.prepareStatement(consulta);

            sentencia.setString(1, user.getName());
            sentencia.setString(2, user.getEmail());
            sentencia.setString(3, user.getPhone());
            sentencia.setString(4, Security.cifrar(user.getPassword()));
            int insert = sentencia.executeUpdate();

            if (insert == 1) {
                aux = true;
            }

        } catch (SQLException e) {
            System.err.println(e);

        }

        return aux;

    }

    public User getData(String email) {
        User user = new User();

        String query = "SELECT * FROM user where email = ?";
        boolean checkUser = false;

        try {
            Connection conexion = new Conexion().getConnection();
            PreparedStatement sentencia = conexion.prepareStatement(query);
            sentencia.setString(1, email);
            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {

        }

        return user;

    }

    
    
    public ArrayList<User> getAllUsers(){
        ArrayList<User> listUser = new ArrayList<User>();
        String query = "SELECT * FROM user ";
        
        
        try {
            Connection conexion = new Conexion().getConnection();
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                User user = new User().getData(rs.getString("email"));
                listUser.add(user);
                
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        return listUser;
    }
    
   
    
    
}
