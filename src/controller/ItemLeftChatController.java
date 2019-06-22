/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
        
        itemLeftChat.imageUser.setIcon(new ImageRounded().loadImage("/Users/hugoluna/Desktop/user.png", 50));
        itemLeftChat.message.setOpaque(false);
    }
    
    
    
    
}
