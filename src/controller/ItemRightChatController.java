/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.border.EmptyBorder;
import utils.Constants;
import utils.ImageRounded;
import view.ItemRightChat;

/**
 *
 * @author hugoluna
 */
public class ItemRightChatController {
    
    private ItemRightChat itemRightChat;
    private String message;

    public ItemRightChatController(ItemRightChat itemRightChat, String message) {
        this.itemRightChat = itemRightChat;
        this.message = message;
        itemRightChat.message.setText(message);
        //this.itemRightChat.setVisible(true);
        itemRightChat.imageUser.setIcon(new ImageRounded().loadImage(new Constants().rutaImagen(), 50));
        itemRightChat.message.setOpaque(false);
        //itemRightChat.setBorder(new EmptyBorder(0,0,0,30));
    }
    
    
    
}
