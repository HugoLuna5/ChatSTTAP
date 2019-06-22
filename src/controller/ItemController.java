/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.ItemChatContact;
import utils.ImageRounded;
import view.ItemList;

/**
 *
 * @author hugoluna
 */
public class ItemController {
    private ItemList itemList;
    private ItemChatContact itemChatContact;

    public ItemController(ItemList itemList, ItemChatContact itemChatContact) {
        this.itemList = itemList;
        this.itemChatContact = itemChatContact;
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

   
    
    
    
}
