/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics.VagrantApp;

import Utils.SelectUtils;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author julianalonso
 */
public class SelectWorkbenchDialog extends JDialog {

    private Container cp;
    private JTextField path;
    private JButton fileChooser;
    private JButton okButton;
    private File workbench;
    
    public SelectWorkbenchDialog() {
        super((JFrame) null, "Selecciona carpeta de trabajo", false);

        //INITS AND CONFIGS
        this.initComponents();
        this.configComponents();
        this.configDialog();
        
        cp = getContentPane();
        cp.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        
        JPanel center = new JPanel(new FlowLayout());
        center.add(path);
        center.add(fileChooser);
        
        this.add(center);
        this.add(this.okButton);
    }

    public String getPath() {
        return this.path.getText();
    }
    
    public File getWorkbench() {
        return this.workbench;
    }

    private ActionListener getSelectAction() {
        return (ActionEvent e) -> {
            this.workbench = SelectUtils.selectDirectory(); 
            if (workbench != null)
                this.path.setText(workbench.getAbsolutePath());
        };
    }
    
    private ActionListener getcloseAction() {
        return (ActionEvent e) -> {
            
            if (this.workbench == null)
                JOptionPane.showMessageDialog(this, "Selecciona un directorio.", "Error", JOptionPane.ERROR_MESSAGE);
            else
                this.dispose();
            
        };
    }
    
    private void initComponents() {
        this.path = new JTextField();
        this.fileChooser = new JButton("Buscar");
        this.okButton = new JButton("Continuar");
    }

    private void configComponents() {
        //PATH TEXT CONFIG
        this.path.setPreferredSize(new Dimension(250, 25));

        //FILE CHOOSER CONFIG
        this.fileChooser.addActionListener(this.getSelectAction());
        
        //OK BUTTON
        this.okButton.addActionListener(this.getcloseAction());
    }
    
    private void configDialog() {
        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Selecciona carpeta de trabajo");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 100);
    }

}
