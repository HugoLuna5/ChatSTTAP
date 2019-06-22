/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import controller.HomeController;
import controller.LoginController;
import mdlaf.*;
import mdlaf.animation.*;
import javax.swing.*;
import java.awt.*;
import java.util.prefs.Preferences;
import model.User;
import view.HomeView;
import view.LoginView;

/**
 *
 * @author hugoluna
 */
public class Chat {


    public Chat() {
        initMaterial();
        launchScreen();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        new Chat();

    }

    public void initMaterial() {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public void launchScreen() {
        if (getSessionID()) {

            new HomeController(new HomeView(), new User().getData(getEmail()));

        } else {

            new LoginController(new LoginView());
        }
    }

    public boolean getSessionID() {
        Preferences prefs = Preferences.userNodeForPackage(controller.LoginController.class);
        final String PREF_NAME = "email";
        String defaultValue = "default";

        String id = prefs.get(PREF_NAME, defaultValue);

        boolean val = false;
        if (!id.equals("default")) {
            val = true;
        }

        return val;

    }

    public String getEmail() {
        Preferences prefs = Preferences.userNodeForPackage(controller.LoginController.class);
        final String PREF_NAME = "email";
        String defaultValue = "default";

        return prefs.get(PREF_NAME, defaultValue);
    }

}
