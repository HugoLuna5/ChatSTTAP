/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.ChatMessage;
import model.ItemChatContact;
import model.Room;
import model.User;
import service.ClientService;
import utils.Constants;
import view.ChatRoomView;
import view.ChatViewContainerView;
import view.ItemList;

/**
 *
 * @author hugoluna
 */
public class ChatViewContainerController {

    public ChatViewContainerView chatView;
    private ArrayList<User> userList;
    private ArrayList<ItemController> listC;
    private Socket socket;
    private ChatMessage message;
    private ClientService service;
    private User us;

    public ChatViewContainerController(ChatViewContainerView chatView, ArrayList<User> userList, Socket socket, ChatMessage message, ClientService service, User us) {
        this.chatView = chatView;
        this.userList = userList;
        this.socket = socket;
        this.message = message;
        this.service = service;
        this.us = us;
        this.chatView.setVisible(true);
        listC = new ArrayList<ItemController>();
        chatView.itemListContainer.setLayout(new BorderLayout());
        loadItems();

    }

    public void loadItems() {

        JPanel panel = new JPanel();
        panel.setSize(509, 507);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        chatView.chatContent.removeAll();
        chatView.chatContent.repaint();

        System.out.println(userList.size());
        ArrayList<User> listAllUser = new User().getAllUsers();

        for (User user : listAllUser) {

            if (us.getId() != user.getId()) {
                ItemList item = new ItemList();
            ItemChatContact itemData = new ItemChatContact();
            String name = user.getName();
            String email = user.getEmail();
            int id = user.getId();
            String phone = user.getPhone();

            itemData.setId(id);
            itemData.setImageUrl(new Constants().rutaImagen());
            itemData.setEmail(email);
            itemData.setName(name);
            panel.add(item);

            for (int i = 0; i < userList.size(); i++) {

                if (!user.getEmail().equals(userList.get(i).getEmail())) {

                    new ItemController(item, itemData, chatView, socket, message, service, us, false);

                } else if(user.getEmail().equals(userList.get(i).getEmail())) {

                    new ItemController(item, itemData, chatView, socket, message, service, us, true);
                }

            }
            }

            System.out.println("Lista usuario");
        }

        panel.revalidate();
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scrollPane.setBounds(0, 0, 509, 507);

        chatView.itemListContainer.add(scrollPane);
        chatView.itemListContainer.revalidate();

    }

}
