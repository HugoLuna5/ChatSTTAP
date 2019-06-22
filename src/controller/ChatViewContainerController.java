/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import view.ChatRoomView;
import view.ChatViewContainerView;
import view.ItemList;

/**
 *
 * @author hugoluna
 */
public class ChatViewContainerController {

    private ChatViewContainerView chatView;
    private ChatRoomView chatRoomView;
    private ArrayList<User> userList;
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

        loadItems();

    }

    public void loadItems() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        chatView.chatContent.removeAll();
        chatView.chatContent.repaint();

        for (int i = 0; i < userList.size(); i++) {
            ItemList item = new ItemList();
            ItemChatContact itemData = new ItemChatContact();
            String name = userList.get(i).getName();
            String email = userList.get(i).getEmail();
            int id = userList.get(i).getId();
            String phone = userList.get(i).getPhone();

            itemData.setId(String.valueOf(id));
            itemData.setImageUrl("/Users/hugoluna/Desktop/user.png");
            itemData.setLastMessage(email);
            itemData.setName(name);

            panel.add(item);

            item.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

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

            new ItemController(item, itemData);

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

    public void loadMessageView(User user, Room room) {
        chatView.chatContent.removeAll();
        chatView.chatContent.repaint();
        chatView.chatContent.add(chatRoomView);
        new ChatRoomController(chatRoomView, user, socket, message, service, us, room);
        chatView.chatContent.revalidate();
    }

}
