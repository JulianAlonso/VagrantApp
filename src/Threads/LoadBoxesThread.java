/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Threads;

import Entity.Box;
import Exceptions.BoxNotFoundException;
import Exceptions.ListPanelNullException;
import Exceptions.WorkbenchNotFoundException;
import Factory.PanelFactory;
import Graphics.VagrantApp.Components.ListPanel;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julianalonso
 */
public class LoadBoxesThread extends Thread {
    
    private File workbench;
    private ListPanel listPanel;
    
    public LoadBoxesThread(File workbench, ListPanel listPanel) throws WorkbenchNotFoundException, ListPanelNullException {
        
        if (workbench == null) {
            throw new WorkbenchNotFoundException();
        }
        
        if (listPanel == null) {
            throw new ListPanelNullException();
        }
        
        this.listPanel = listPanel;
        this.workbench = workbench;
    }
    
    @Override
    public void run() {
        
        try {
            lookForBoxes(this.workbench);
        } catch (BoxNotFoundException ex) {
            Logger.getLogger(LoadBoxesThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void lookForBoxes(File dir) throws BoxNotFoundException {
        File[] list = dir.listFiles();
        for (File file: list) {
            if (file.isDirectory() && !file.isHidden()) {
                lookForBoxes(file);
            }
            if (file.getName().equals("Vagrantfile") && file.isFile()) {
                Box newBox = new Box(dir.getName(), dir, file);
                this.listPanel.add(PanelFactory.getNewBoxPanel(newBox));
                this.listPanel.refresh();
            }
        }
    }
    
}
