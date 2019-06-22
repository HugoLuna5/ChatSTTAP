/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author hugoluna
 */
public class PanelRight extends JPanel {
    
    
    private URL url = getClass().getResource("/images/Ri.png");
    Image image = new ImageIcon(url).getImage();

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0,0,  245, 40, this);
        setOpaque(false);
        super.paint(g);
    }
    
}
