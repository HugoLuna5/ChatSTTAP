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
public class ChatRoomView extends javax.swing.JPanel {

    /**
     * Creates new form ChatRoomView
     */
    public ChatRoomView() {
        initComponents();
        //containerInfo.setBackground(new java.awt.Color(0,0,0,24));
        containerInfo.setBorder(MaterialBorders.LIGHT_SHADOW_BORDER);
        usernameLbl.setOpaque(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerMessages = new javax.swing.JPanel();
        formContainer = new javax.swing.JPanel();
        fieldMessage = new HintTextField("Escribe un mensaje...");
        btnSend = new CircleButton("");
        containerInfo = new javax.swing.JPanel();
        usernameLbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        containerMessages.setBackground(new java.awt.Color(246, 246, 247));

        javax.swing.GroupLayout containerMessagesLayout = new javax.swing.GroupLayout(containerMessages);
        containerMessages.setLayout(containerMessagesLayout);
        containerMessagesLayout.setHorizontalGroup(
            containerMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        containerMessagesLayout.setVerticalGroup(
            containerMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enviar.png"))); // NOI18N

        javax.swing.GroupLayout formContainerLayout = new javax.swing.GroupLayout(formContainer);
        formContainer.setLayout(formContainerLayout);
        formContainerLayout.setHorizontalGroup(
            formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formContainerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(fieldMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        formContainerLayout.setVerticalGroup(
            formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldMessage))
                .addContainerGap())
        );

        containerInfo.setBackground(new java.awt.Color(255, 255, 255));

        usernameLbl.setFont(new java.awt.Font("Lucida Grande", 2, 18)); // NOI18N
        usernameLbl.setText("Username");

        javax.swing.GroupLayout containerInfoLayout = new javax.swing.GroupLayout(containerInfo);
        containerInfo.setLayout(containerInfoLayout);
        containerInfoLayout.setHorizontalGroup(
            containerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerInfoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(usernameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containerInfoLayout.setVerticalGroup(
            containerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usernameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerMessages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(formContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(containerInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(containerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(containerMessages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnSend;
    public javax.swing.JPanel containerInfo;
    public javax.swing.JPanel containerMessages;
    public javax.swing.JTextField fieldMessage;
    private javax.swing.JPanel formContainer;
    public javax.swing.JLabel usernameLbl;
    // End of variables declaration//GEN-END:variables
}
