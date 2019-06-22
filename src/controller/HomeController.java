/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import model.ChatMessage;
import model.Room;
import model.User;
import service.ClientService;
import utils.ImageRounded;
import utils.Toaster;
import view.ChatRoomView;
import view.ChatViewContainerView;
import view.HomeView;
import view.LoginView;

/**
 *
 * @author hugoluna
 */
public class HomeController {

    private final HomeView homeView;
    private User user;
    private ChatViewContainerView chatViewContainerView;
    private ChatViewContainerController chatViewContainerController;

    private Socket socket;
    private ChatMessage message;
    private ClientService service;
    private Toaster toaster;

    public HomeController(HomeView homeView, User user) {
        this.homeView = homeView;
        this.user = user;
        this.homeView.setVisible(true);
        toaster = new Toaster(homeView.containerMain);
        this.homeView.containerMain.setLayout(new BorderLayout());
        chatViewContainerView = new ChatViewContainerView();
        init();

        events();
        homeView.btnChat.doClick();

    }

    public void init() {

        homeView.lblImage.setIcon(new ImageRounded().loadImage("/Users/hugoluna/Desktop/user.png", 85));
        homeView.setResizable(false);

        String name = user.getEmail().toString();

        if (!name.isEmpty()) {
            this.message = new ChatMessage();
            this.message.setAction(ChatMessage.Action.CONNECT);
            this.message.setName(name);

            this.service = new ClientService();
            this.socket = this.service.connect();

            new Thread(new ListenerSocket(this.socket)).start();

            this.service.send(message);
        }

    }

    public void events() {

        homeView.btnChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //loadDefaults();

            }
        });

        homeView.btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                homeView.setVisible(false);
                deletePreferences();

                ChatMessage message = new ChatMessage();
                message.setName(message.getName());
                message.setAction(ChatMessage.Action.DISCONNECT);
                service.send(message);
                disconnected();

                new LoginController(new LoginView());

            }
        });

    }

    public void deletePreferences() {

        Preferences prefs = Preferences.userNodeForPackage(controller.LoginController.class);
        final String PREF_NAME = "email";
        prefs.put(PREF_NAME, "default");

    }

    private class ListenerSocket implements Runnable {

        private ObjectInputStream input;

        public ListenerSocket(Socket socket) {
            try {
                this.input = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(ListenerSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void run() {
            ChatMessage message = null;
            try {
                while ((message = (ChatMessage) input.readObject()) != null) {
                    ChatMessage.Action action = message.getAction();

                    if (action.equals(ChatMessage.Action.CONNECT)) {
                        //connected(message);
                    } else if (action.equals(ChatMessage.Action.DISCONNECT)) {
                        disconnected();
                        socket.close();
                    } else if (action.equals(ChatMessage.Action.SEND_ONE)) {
                        String emailUs = message.getName();

                        User reciveData = new User().getData(emailUs);

                        if (!message.getText().equals(" hasta luego!")) {
                            System.out.println("::: " + message.getText() + " :::");
                            toaster.success("¡Recibiste un mensaje!", "Tienes un nuevo mensaje de " + reciveData.getName());
                            receive(message);
                        } else {
                            toaster.error("¡Notificación!", "El usuario " + reciveData.getName() + " ya no se encuentra en linea");

                        }

                    } else if (action.equals(ChatMessage.Action.USERS_ONLINE)) {
                        refreshOnlines(message);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(ListenerSocket.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListenerSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void connected(ChatMessage message) {
        if (message.getText().equals("NO")) {
            //this.txtName.setText("");
            JOptionPane.showMessageDialog(homeView.containerMain, "Conexion no realizada!\nIntente nuevamente.");
            return;
        }

        this.message = message;
        JOptionPane.showMessageDialog(homeView.containerMain, "Conectado!");
    }

    private void disconnected() {

        //this.btnConnectar.setEnabled(true);
        //this.txtName.setEditable(true);
        //this.btnSair.setEnabled(false);
        //this.txtAreaSend.setEnabled(false);
        //this.txtAreaReceive.setEnabled(false);
        //this.btnEnviar.setEnabled(false);
        //this.btnLimpar.setEnabled(false);
        //this.txtAreaReceive.setText("");
        //this.txtAreaSend.setText("");
        JOptionPane.showMessageDialog(homeView.containerMain, "Ha cerrado la sesion!");
    }

    /**
     * Recive messages from other user online
     *
     * @param message
     */
    private void receive(ChatMessage message) {

        //ver si existe una sala de chat abierta
        ChatViewContainerView chatView = chatViewContainerController.chatView;
        
        User us2 = new User().getData(message.getName());
        if (!new Room().verifyExistRoom(user.getId(), us2.getId())) {

            new Room().createRoom(user.getId(), us2.getId());

        }
        
        loadMessageView(user, new Room().getRoom(user.getId(), us2.getId()), chatView);


    }
    
     public void loadMessageView(User us2, Room room, ChatViewContainerView chatView) {
        chatView.chatContent.removeAll();
        chatView.chatContent.repaint();
        
        ChatRoomView chatRoomView;       
        chatRoomView = new ChatRoomView();
        chatView.chatContent.add(chatRoomView);
        new ChatRoomController(chatRoomView, us2, socket, message, service, user, room);
        chatView.chatContent.revalidate();
    }
    
    
    
    

    private void refreshOnlines(ChatMessage message) {
        System.out.println(message.getSetOnlines().toString());

        Set<String> names = message.getSetOnlines();

        names.remove(message.getName());

        String[] array = (String[]) names.toArray(new String[names.size()]);

        loadDefaults(array);

    }

    public void loadDefaults(String[] array) {
        homeView.containerMain.add(chatViewContainerView);
        ArrayList<User> userList = new ArrayList<User>();
        for (int i = 0; i < array.length; i++) {
            User user = new User().getData(array[i]);
            userList.add(user);

        }

        chatViewContainerController = new ChatViewContainerController(chatViewContainerView, userList, socket, message, service, user);
        homeView.containerMain.revalidate();
    }

}
