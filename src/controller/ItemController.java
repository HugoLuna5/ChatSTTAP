/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.Socket;
import model.ChatMessage;
import model.ItemChatContact;
import model.Room;
import model.User;
import service.ClientService;
import utils.Constants;
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
    private boolean status;

    public ItemController(ItemList itemList, ItemChatContact itemChatContact, ChatViewContainerView chatView, Socket socket, ChatMessage message, ClientService service, User us, boolean status) {
        this.itemList = itemList;
        this.itemChatContact = itemChatContact;
        this.chatView = chatView;
        this.socket = socket;
        this.message = message;
        this.service = service;
        this.us = us;
        this.status = status;
        loadDataItem();
        events();
    }

    public void loadDataItem() {

        itemList.imgItem.setIcon(new ImageRounded().loadImage(itemChatContact.getImageUrl(), 50));
        itemList.usernameLabel.setText(itemChatContact.getName());
        itemList.contentLabel.setText(itemChatContact.getEmail());

        if (status) {
            itemList.status.setIcon(new ImageRounded().loadImage(new Constants().rutaImagenStatusOnline(), 25));

        } else {
            itemList.status.setIcon(new ImageRounded().loadImage(new Constants().rutaImagenStatusOffline(), 25));
        }

    }

    public void events() {

        itemList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                action();

            }

            @Override
            public void mousePressed(MouseEvent e) {
                action();
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

    public void action() {
        chatRoomView = new ChatRoomView();

        /**
         * Verificar si existe la sala de chat
         */
        if (!new Room().verifyExistRoom(us.getId(), itemChatContact.getId())) {

            new Room().createRoom(us.getId(), itemChatContact.getId());

        }

        User user = new User();
        user.setEmail(itemChatContact.getEmail());
        user.setName(itemChatContact.getName());
        user.setId(itemChatContact.getId());
        user.setPhone(itemChatContact.getPhone());
        loadMessageView(user, new Room().getRoom(us.getId(), itemChatContact.getId()));
    }

    public void loadMessageView(User user, Room room) {
        chatView.chatContent.removeAll();
        chatView.chatContent.repaint();
        chatView.chatContent.add(chatRoomView);
        new ChatRoomController(chatRoomView, user, socket, message, service, us, room);
        chatView.chatContent.revalidate();
    }

}
