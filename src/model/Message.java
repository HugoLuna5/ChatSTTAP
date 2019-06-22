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

/**
 *
 * @author hugoluna
 */
public class Message {

    private int id_message;
    private int id_usuario;
    private int id_room;
    private String message;
    private String time;

    public Message() {
    }

    public Message(int id_message, int id_usuario, int id_room, String message, String time) {
        this.id_message = id_message;
        this.id_usuario = id_usuario;
        this.id_room = id_room;
        this.message = message;
        this.time = time;
    }

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    
    /**
     * Create a message a save in DB
     * @param message
     * @return 
     */
    public boolean createMessage(Message message) {
        boolean aux = false;

        String query = "INSERT INTO menssage (id_user, id_room, message) VALUES(?,?,?)";

        try {
            Connection conexion = new Conexion().getConnection();
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, message.getId_usuario());
            ps.setInt(2, message.getId_room());
            ps.setString(3, message.getMessage());

            int res = ps.executeUpdate();

            if (res == 1) {
                aux = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aux;
    }
    
    
    /**
     * Get all messages of chatRoom user
     * @param id_room
     * @return 
     */
    public ArrayList<Message> getAllMessagesRoom(int id_room){
        ArrayList<Message> messageList = new ArrayList<Message>();
        
        String query = "SELECT * FROM message WHERE id_room = ?";
        
        try {
            Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareCall(query);
            ps.setInt(1, id_room);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Message ms = new Message();
                ms.setId_message(rs.getInt("id"));
                ms.setId_usuario(rs.getInt("id_user"));
                ms.setId_room(rs.getInt("id_room"));
                ms.setMessage(rs.getString("message"));
                ms.setTime(rs.getString("time"));
                messageList.add(ms);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return messageList;
    }
    

}
