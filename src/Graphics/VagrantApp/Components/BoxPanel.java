/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Graphics.VagrantApp.Components;

import Entity.Box;
import Exceptions.BoxNotFoundException;
import Res.Images.Images;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author julianalonso
 */
public class BoxPanel extends JPanel {
    
    private final Dimension DIMENSION = new Dimension(300, 100);
    
    private Box box;
    private JLabel machineName;
    private JLabel boxName;
    private JLabel image;
    
    public BoxPanel(Box box) throws BoxNotFoundException {
        super(new GridBagLayout());
        
        if (box == null) 
            throw new BoxNotFoundException();
        
        this.box = box;
        
        this.initComponents();
        this.configComponents();
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 3;
        c.ipadx = 1;
        c.ipady = 1;
        this.add(this.image, c);
        
        c.gridx = 4;
        c.gridy = 1;
        c.gridwidth = 7;
        c.gridheight = 1;
        c.ipadx = 1;
        c.ipady = 1;
        this.add(this.boxName, c);
        
        c.gridx = 4;
        c.gridy = 3;
        c.gridwidth = 7;
        c.gridheight = 1;
        c.ipadx = 1;
        c.ipady = 1;
        this.add(this.machineName, c);
    }
    
    public Box getBox() {
        return this.box;
    }
    
    public void setImage(ImageIcon imageIcon) {
        this.image = new JLabel(imageIcon);
        this.repaint();
    }
    
    private void initComponents() {
        this.image = new JLabel(Images.BOX);
        this.boxName = new JLabel(box.getName());
        this.machineName = new JLabel("Machine name");
    }
    
    private void configComponents() {
        this.setBackground(Color.WHITE);
        this.setSize(DIMENSION);
        this.setMaximumSize(DIMENSION);
    }
    
}
