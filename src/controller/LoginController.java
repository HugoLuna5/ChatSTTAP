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
import java.util.prefs.Preferences;
import model.User;
import utils.Toaster;
import view.HomeView;
import view.LoginView;
import view.RegisterView;

/**
 *
 * @author hugoluna
 */
public class LoginController {

    private LoginView loginView;
    private Toaster toaster;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.loginView.setVisible(true);
        events();
    }

    public void events() {
        loginView.actionRegister.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invisibleView();
                new RegisterController(new RegisterView());
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

        loginView.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processLogin();

            }
        });

    }

    public void processLogin() {
        toaster = new Toaster(loginView.mainContainer);
        String email = loginView.fieldEmail.getText().toString();
        String password = loginView.passField.getText().toString();

        if (!email.isEmpty() && !password.isEmpty()) {

            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            loginView.btnLogin.setEnabled(false);
            if (new User().loginUser(user)) {
                toaster.success("¡Genial!", "Has ingresado correctamente");
                savePreferences(String.valueOf(user.getEmail()));

                invisibleView();

                new HomeController(new HomeView(), user);

            } else {
                toaster.error("¡Ups ocurrio un error!", "Es posible que los datos no existan en nuestros registros");
                loginView.btnLogin.setEnabled(true);
            }
        } else {
            loginView.btnLogin.setEnabled(true);
            toaster.info("¡Ups!.", "Debes llenar los campos para ingresar");
        }

    }

    public void invisibleView() {
        loginView.setVisible(false);
    }

    /**
     * *
     * Guardar los datos de los alumnos en las preferencias
     *
     * @param id
     */
    public void savePreferences(String email) {

        Preferences prefs = Preferences.userNodeForPackage(controller.LoginController.class);
        final String PREF_NAME = "email";

        prefs.put(PREF_NAME, email);

    }

}
