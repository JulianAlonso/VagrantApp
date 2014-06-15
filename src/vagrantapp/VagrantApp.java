/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vagrantapp;

import Exceptions.ListPanelNullException;
import Exceptions.WorkbenchNotFoundException;
import Graphics.VagrantApp.MainFrame;
import Graphics.VagrantApp.Dialogs.SelectWorkbenchDialog;
import Threads.LoadBoxesThread;
import java.awt.Dimension;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author julianalonso
 */
public class VagrantApp {

    private static SelectWorkbenchDialog selectWorkbenchDialog;
    private static MainFrame mainFrame;
    private static LoadBoxesThread loadBoxesThread;
    private static File workbench;
    
    /**
     * @param args the command line arguments
     * @throws Exceptions.ListPanelNullException
     */
    public static void main(String[] args) throws ListPanelNullException {
        VagrantApp.initComponents();
        VagrantApp.configComponents();
        
        selectWorkbenchDialog.setVisible(true);
        VagrantApp.workbench = selectWorkbenchDialog.getWorkbench();
        
        mainFrame.setVisible(true);
        
        startLoadBoxesThread();
    }
    
    private static void initComponents() {
        VagrantApp.selectWorkbenchDialog = new SelectWorkbenchDialog();
        VagrantApp.mainFrame = new MainFrame();
    }
    
    private static void configComponents() {
        VagrantApp.mainFrame.setSize(new Dimension(1200, 900));
        VagrantApp.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void startLoadBoxesThread() throws ListPanelNullException {
        try {
            loadBoxesThread = new LoadBoxesThread(workbench, mainFrame.getListPanel());
            loadBoxesThread.start();
        } catch (WorkbenchNotFoundException ex) {
            Logger.getLogger(VagrantApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}