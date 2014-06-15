/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Graphics.VagrantApp.Components.MicroComponents;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author julianalonso
 */
public class FileBoxPanel extends JPanel {
    
    private JLabel boxLabel;
    private JTextField boxName;
    
    public FileBoxPanel() {
        super(new FlowLayout());
        
        this.initComponents();
        this.configComponents();
        
        //adding the components
        this.add(this.boxLabel);
        this.add(this.boxName);
    }
    
    public String getBoxName() {
        return this.boxName.getText();
    }    
    
    private void initComponents() {
        this.boxLabel = new JLabel("BOX: ");
        this.boxName = new JTextField();
    }
    
    private void configComponents() {
        this.boxName.setPreferredSize(new Dimension(200, 25));
    }
}
