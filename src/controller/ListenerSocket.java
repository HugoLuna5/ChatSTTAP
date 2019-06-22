/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChatMessage;
import service.ClientService;

/**
 *
 * @author hugoluna
 */
public class ListenerSocket implements Runnable {

        private Socket socket;
        private ChatMessage message;
        private ClientService service;
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
                        //disconnected();
                        socket.close();
                    } else if (action.equals(ChatMessage.Action.SEND_ONE)) {
                        System.out.println("::: " + message.getText() + " :::");
                        //receive(message);
                    } else if (action.equals(ChatMessage.Action.USERS_ONLINE)) {
                        //refreshOnlines(message);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(ListenerSocket.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListenerSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

