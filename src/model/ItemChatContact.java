/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hugoluna
 */
public class ItemChatContact {
    
    private String imageUrl;
    private String name;
    private String id;
    private String lastMessage;

    public ItemChatContact() {
    }

    public ItemChatContact(String imageUrl, String name, String id, String lastMessage) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.id = id;
        this.lastMessage = lastMessage;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
    
    
    
    
}
