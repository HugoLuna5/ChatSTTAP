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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hugoluna
 */
public class Room {

    private int id;
    private int id_user_one;
    private int id_user_two;
    private String time;

    public Room() {
    }

    public Room(int id, int id_user_one, int id_user_two, String time) {
        this.id = id;
        this.id_user_one = id_user_one;
        this.id_user_two = id_user_two;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user_one() {
        return id_user_one;
    }

    public void setId_user_one(int id_user_one) {
        this.id_user_one = id_user_one;
    }

    public int getId_user_two() {
        return id_user_two;
    }

    public void setId_user_two(int id_user_two) {
        this.id_user_two = id_user_two;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean verifyExistRoom(int user_one, int user_two) {
        boolean aux = false;

        String queryVerify = "SELECT * FROM room id_user_one = ? AND id_user_two = ? OR  id_user_one = ? AND id_user_two = ?";

        try {
            Connection conexion = new Conexion().getConnection();
            PreparedStatement ps = conexion.prepareStatement(queryVerify);
            ps.setInt(1, user_one);
            ps.setInt(2, user_two);
            ps.setInt(3, user_two);
            ps.setInt(4, user_one);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                aux = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aux;
    }
    
    
    public Room getRoom(int user_one, int user_two){
        Room room = new Room();
         String queryVerify = "SELECT * FROM room id_user_one = ? AND id_user_two = ? OR  id_user_one = ? AND id_user_two = ?";

        try {
            Connection conexion = new Conexion().getConnection();
            PreparedStatement ps = conexion.prepareStatement(queryVerify);
            ps.setInt(1, user_one);
            ps.setInt(2, user_two);
            ps.setInt(3, user_two);
            ps.setInt(4, user_one);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                room.setId(rs.getInt("id"));
                room.setId_user_one(rs.getInt("id_user_one"));
                room.setId_user_two(rs.getInt("id_user_two"));
                room.setTime(rs.getString("time"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return room;
        
    }
    

    public boolean createRoom(int user_one, int user_two) {
        boolean aux = false;

        String query = "INSERT INTO room (id_user_one, id_user_two) VALUES(?, ?)";

        try {
            Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, user_one);
            ps.setInt(2, user_two);

            int res = ps.executeUpdate();

            if (res == 1) {
                aux = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aux;
    }

}
