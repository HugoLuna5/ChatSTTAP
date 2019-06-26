/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import utils.Constants;
import utils.ImageRounded;
import view.ItemLeftChat;

/**
 *
 * @author hugoluna
 */
public class ItemLeftChatController {
    
    private ItemLeftChat itemLeftChat;
    private String message;

    public ItemLeftChatController(ItemLeftChat itemLeftChat, String message) {
        this.itemLeftChat = itemLeftChat;
        this.message = message;
        //this.itemLeftChat.setVisible(true);
        itemLeftChat.message.setText(message);
        
        itemLeftChat.imageUser.setIcon(new ImageRounded().loadImage(new Constants().rutaImagen(), 50));
        itemLeftChat.message.setOpaque(false);
    }
    
    
    
    
}
