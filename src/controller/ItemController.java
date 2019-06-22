/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.Socket;
import model.ChatMessage;
import model.ItemChatContact;
import model.Room;
import model.User;
import service.ClientService;
import utils.ImageRounded;
import view.ChatRoomView;
import view.ChatViewContainerView;
import view.ItemList;

/**
 *
 * @author hugoluna
 */
public class ItemController {
    private ItemList itemList;
    private ItemChatContact itemChatContact;
    private ChatRoomView chatRoomView;
    private ChatViewContainerView chatView;
    
    
    private Socket socket;
    private ChatMessage message;
    private ClientService service;
    private User us;
    

    public ItemController(ItemList itemList, ItemChatContact itemChatContact,ChatViewContainerView chatView, Socket socket, ChatMessage message, ClientService service, User us) {
        this.itemList = itemList;
        this.itemChatContact = itemChatContact;
        this.chatView = chatView;
        this.socket = socket;
        this.message = message;
        this.service = service;
        this.us = us;
        loadDataItem();
        events();
    }
    
    public void loadDataItem(){
        
        itemList.imgItem.setIcon(new ImageRounded().loadImage(itemChatContact.getImageUrl(), 50));
        itemList.usernameLabel.setText(itemChatContact.getName());
        itemList.contentLabel.setText(itemChatContact.getLastMessage());
        
        
    }
    
    
    public void events(){
        
        itemList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                System.out.println("Click en "+itemChatContact.getName());
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
    }

    public void actionClick(String email, String name, int id, String phone) {
        chatRoomView = new ChatRoomView();

        /**
         * Verificar si existe la sala de chat
         */
        if (!new Room().verifyExistRoom(us.getId(), id)) {

            new Room().createRoom(us.getId(), id);

        }

        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setId(id);
        user.setPhone(phone);
        loadMessageView(user, new Room().getRoom(us.getId(), id));
    }
    
    
     public void loadMessageView(User user, Room room) {
        chatView.chatContent.removeAll();
        chatView.chatContent.repaint();
        chatView.chatContent.add(chatRoomView);
        new ChatRoomController(chatRoomView, user, socket, message, service, us, room);
        chatView.chatContent.revalidate();
    }
    
    
    
}
