/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Graphics.VagrantApp.Components.MicroComponents;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author julianalonso
 */
public class Button extends JButton {
    
    public Button(ImageIcon image) {
        super(image);
        this.setPreferredSize(new Dimension(64, 64));
        this.setMaximumSize(new Dimension(64, 64));
        this.setMinimumSize(new Dimension(64, 64));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setBackground(null);
    }
    
}
