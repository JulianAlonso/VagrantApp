/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics.VagrantApp.Components;

import Controllers.FileController;
import DAO.Interfaces.VagrantfileDaoI;
import Dto.VagrantfileDto;
import Graphics.VagrantApp.Components.MicroComponents.FileBoxPanel;
import Graphics.VagrantApp.Components.MicroComponents.FileNetworkPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author julianalonso
 */
public class FilePanel extends JPanel {

    private FileController fileController;
    private FileBoxPanel fileBoxPanel;
    private FileNetworkPanel fileNetworkPanel;
    private JButton button;

    public FilePanel() {
        super(new GridLayout(3, 1));

        this.initComponents();
        this.configComponents();

        this.add(this.fileBoxPanel);
        this.add(this.fileNetworkPanel);
        this.add(this.button);
    }
    
    public void setFileController(FileController fileController) {
        this.fileController = fileController;
    }
    
    private void initComponents() {
        this.fileBoxPanel = new FileBoxPanel();
        this.fileNetworkPanel = new FileNetworkPanel();
        this.button = new JButton("Guardar");
    }

    private void configComponents() {
        this.button.addActionListener(this.getGuardarAction());
    }

    private ActionListener getGuardarAction() {
        return (ActionEvent e) -> {
            VagrantfileDto vagrantfileDto = new VagrantfileDto();
            vagrantfileDto.setNetWorkDto(this.fileNetworkPanel.getNetworkDto());
            vagrantfileDto.setBoxName(this.fileBoxPanel.getBoxName());
            
            try {
                fileController.guardar(vagrantfileDto);
            } catch (IOException ex) {
                Logger.getLogger(FilePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
    }

}
