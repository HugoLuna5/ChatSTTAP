/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import mdlaf.utils.MaterialBorders;

/**
 *
 * @author hugoluna
 */
public class ChatViewContainerView extends javax.swing.JPanel {

    /**
     * Creates new form ChatView
     */
    public ChatViewContainerView() {
        initComponents();
        
        containerListChats.setBorder(MaterialBorders.LIGHT_SHADOW_BORDER);
        
        //searchField.set
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainContainer = new javax.swing.JPanel();
        containerListChats = new javax.swing.JPanel();
        searchField = new RoundedTextField(15, "Buscar...");
        itemListContainer = new javax.swing.JPanel();
        chatContent = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(764, 600));
        setPreferredSize(new java.awt.Dimension(764, 600));
        setSize(new java.awt.Dimension(764, 600));

        mainContainer.setPreferredSize(new java.awt.Dimension(764, 600));
        mainContainer.setSize(new java.awt.Dimension(764, 600));

        containerListChats.setBackground(new java.awt.Color(255, 255, 255));

        searchField.setBorder(null);
        searchField.setHighlighter(null);
        searchField.setSelectionColor(java.awt.Color.white);

        javax.swing.GroupLayout itemListContainerLayout = new javax.swing.GroupLayout(itemListContainer);
        itemListContainer.setLayout(itemListContainerLayout);
        itemListContainerLayout.setHorizontalGroup(
            itemListContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        itemListContainerLayout.setVerticalGroup(
            itemListContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout containerListChatsLayout = new javax.swing.GroupLayout(containerListChats);
        containerListChats.setLayout(containerListChatsLayout);
        containerListChatsLayout.setHorizontalGroup(
            containerListChatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerListChatsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(itemListContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        containerListChatsLayout.setVerticalGroup(
            containerListChatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerListChatsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(itemListContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainContainerLayout = new javax.swing.GroupLayout(mainContainer);
        mainContainer.setLayout(mainContainerLayout);
        mainContainerLayout.setHorizontalGroup(
            mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainContainerLayout.createSequentialGroup()
                .addComponent(containerListChats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chatContent, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
        );
        mainContainerLayout.setVerticalGroup(
            mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerListChats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chatContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel chatContent;
    private javax.swing.JPanel containerListChats;
    public javax.swing.JPanel itemListContainer;
    public javax.swing.JPanel mainContainer;
    public javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
