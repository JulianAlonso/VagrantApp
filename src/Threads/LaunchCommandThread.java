/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Threads;

import Entity.Command;
import Entity.OutputMap;
import Exceptions.ListPanelNullException;
import Exceptions.ScriptNotFoundException;
import Graphics.VagrantApp.Components.BoxPanel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vagrantapp.VagrantApp;

/**
 *
 * @author julianalonso
 */
public class LaunchCommandThread extends Thread {
    
    private Command command;
    private BoxPanel boxPanel;
    
    public LaunchCommandThread(Command command, BoxPanel boxPanel) {
        this.command = command;
        this.boxPanel = boxPanel;
    }
    
    @Override
    public void run() {
        //this.boxPanel.setImage(Images.LOADING);
        
        try {
            
            OutputMap outputMap = command.execute();
            
            if (outputMap.get("error").isEmpty()) {
                
                //this.boxPanel.setImage(Images.PLAY);
                JOptionPane.showMessageDialog(boxPanel, command.getMessage(), "Enhorabuena!", JOptionPane.PLAIN_MESSAGE);
                
            } else {
                
                //this.boxPanel.setImage(Images.BOX);
                
            }
            
            System.out.println("OK: " + outputMap.get("out"));
            System.out.println("ERROR: " + outputMap.get("error"));
            
            VagrantApp.startLoadBoxesThread();
            
            this.join();
        } catch (IOException | ScriptNotFoundException | InterruptedException | ListPanelNullException ex) {
            Logger.getLogger(LaunchCommandThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
