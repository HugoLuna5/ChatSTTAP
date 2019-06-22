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
    private int id;
    private String email;
    private String phone;

    public ItemChatContact() {
    }

    public ItemChatContact(String imageUrl, String name, int id, String email, String phone) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.id = id;
        this.phone = email;
        this.phone = phone;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   
    
    
    
    
}
