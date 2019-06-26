/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.User;
import utils.Security;
import utils.Toaster;
import view.LoginView;
import view.RegisterView;

/**
 *
 * @author hugoluna
 */
public class RegisterController {
    
    private RegisterView registerView;
    private Toaster toaster;
    
    public RegisterController(RegisterView registerView) {
        this.registerView = registerView;
        this.registerView.setVisible(true);
        events();
    }
    
    public void events() {
        
        registerView.actionLogin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registerView.setVisible(false);
                new LoginController(new LoginView());
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
        
        registerView.btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                registerProcess();
                
            }
        });
        
    }
    
    public void registerProcess() {
        String name = registerView.fieldName.getText().toString();
        String email = registerView.fieldEmail.getText().toString();
        String phone = registerView.fieldPhone.getText().toString();
        String password = registerView.passField.getText().toString();
        
        if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !password.isEmpty()) {
            toaster = new Toaster(registerView.mainContainer);
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPhone(phone);
            user.setPassword(password);
            registerView.btnRegister.setEnabled(false);
            if (new User().registerUser(user)) {
                toaster.success("¡Genial!", "Te has registrado correctamente, Debes iniciar sesion");
                
                
                
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            this.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        
                        registerView.setVisible(false);
                        new LoginController(new LoginView());
                        // your code here

                    }
                }.start();
                
            }
            
        } else {
            toaster.info("¡Ups!.", "Debes llenar los campos para registrarte");
            registerView.btnRegister.setEnabled(true);
        }
        
    }
    
}
