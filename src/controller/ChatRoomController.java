/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.ChatMessage;
import model.ItemChatContact;
import model.Message;
import model.Room;
import model.User;
import service.ClientService;
import view.ChatRoomView;
import view.ItemLeftChat;
import view.ItemList;
import view.ItemRightChat;

/**
 *
 * @author hugoluna
 */
public class ChatRoomController {
    
    private ChatRoomView chatViewRoom;
    private User user;
    private User us_sesion;
    private Socket socket;
    private ChatMessage message;
    private ClientService service;
    private JScrollPane scrollPane;
    private Room room;
    
    public ChatRoomController(ChatRoomView chatViewRoom, User user, Socket socket, ChatMessage message, ClientService service, User us_sesion, Room room) {
        this.chatViewRoom = chatViewRoom;
        this.user = user;
        this.socket = socket;
        this.message = message;
        this.service = service;
        this.us_sesion = us_sesion;
        this.room = room;
        
        this.chatViewRoom.setVisible(true);
        //chatViewRoom.containerMessages
        loadInfoBanner();
        loadItems();
        
    }
    
    /**
     * Load data user chatRoom
     */
    public void loadInfoBanner() {
        chatViewRoom.usernameLbl.setText(user.getName() + "\n" + user.getEmail());
        
        chatViewRoom.btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }
    
    
    
    /**
     * Load messages from database
     */
    public void loadItems() {
        
        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setSize(new Dimension(509, 507));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        
        ArrayList<Message> messageList = new Message().getAllMessagesRoom(room.getId());
        for (int i = 0; i < messageList.size(); i++) {
            
            
            
            
            if (us_sesion.getId() ==  messageList.get(i).getId_usuario()) {
                ItemRightChat itemRight = new ItemRightChat();
                panel.add(itemRight);
                 new ItemRightChatController(itemRight, messageList.get(i).getMessage());
            }else{
                ItemLeftChat itemLeft = new ItemLeftChat();
                 panel.add(itemLeft);
                 new ItemLeftChatController(itemLeft, messageList.get(i).getMessage());
            }
            
           
        }
        panel.revalidate();
        scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scrollPane.setBounds(0, 0, 490, 507);
        
        chatViewRoom.containerMessages.add(scrollPane);
        chatViewRoom.containerMessages.revalidate();
        
    }
    
    
    
    /**
     * Action for save send message to other user
     */
    public void sendMessage() {
        
        String text = chatViewRoom.fieldMessage.getText();
        String name = this.message.getName();
        System.out.println("Mensaje enviado");
        
        this.message = new ChatMessage();
        
        this.message.setNameReserved(user.getEmail());
        this.message.setAction(ChatMessage.Action.SEND_ONE);
        
        if (!text.isEmpty()) {
            this.message.setName(name);
            this.message.setText(text);
            
            JPanel panel = new JPanel();
            panel.setBackground(new java.awt.Color(255, 255, 255));
            panel.setSize(new Dimension(509, 507));
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            
            ItemRightChat itemRight = new ItemRightChat();
            
            panel.add(itemRight);
            
            new ItemRightChatController(itemRight, text);
            
            this.service.send(this.message);
            
            Message message = new Message();
            message.setId_room(room.getId());
            message.setId_usuario(us_sesion.getId());
            message.setMessage(text);
            
            saveMessageInDB(message);
        }
        
        chatViewRoom.fieldMessage.setText("");
        
    }
    
    
    /**
     * Save message in DB 
     * @param message 
     */
    public void saveMessageInDB(Message message) {
        if (new Message().createMessage(message)) {
            
        }
        
    }
    
}
