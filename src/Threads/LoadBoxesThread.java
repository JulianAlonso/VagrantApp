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
import Graphics.VagrantApp.Components.BoxPanel;
import Graphics.VagrantApp.Components.ListPanel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julianalonso
 */
public class LoadBoxesThread extends Thread {

    private File workbench;
    private ListPanel listPanel;
    private List<BoxPanel> boxPanels;
    private List<Box> boxes;
    private int cont = 0;

    public LoadBoxesThread(File workbench, ListPanel listPanel) throws WorkbenchNotFoundException, ListPanelNullException {

        if (workbench == null) {
            throw new WorkbenchNotFoundException();
        }

        if (listPanel == null) {
            throw new ListPanelNullException();
        }

        this.listPanel = listPanel;
        this.workbench = workbench;
        this.boxes = new ArrayList();
    }

    @Override
    public void run() {

        try {
            //this.listPanel.removeAllItems();
            this.boxPanels = this.listPanel.getAll();
            lookForBoxes(this.workbench);
            this.boxPanels = this.listPanel.getAll();
            //System.out.println("CONT: " + cont);
            //System.out.println("boxPanels: " + this.boxPanels.size());
            //System.out.println("newbox size: " + this.boxes.size());
            
            if (cont != this.boxPanels.size()) {
                System.out.println("tamaños distintos");
                this.eraseDeletedPanels();
            }
            
        } catch (BoxNotFoundException ex) {
            Logger.getLogger(LoadBoxesThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private synchronized void lookForBoxes(File dir) throws BoxNotFoundException {
        File[] list = dir.listFiles();
        for (File file : list) {
            if (file.isDirectory() && !file.isHidden()) {
                lookForBoxes(file);
            }
            if (file.getName().equals("Vagrantfile") && file.isFile()) {
                Box newBox = new Box(dir.getName(), dir, file);
                this.boxes.add(newBox);
                if (!this.checkEquals(newBox)) {
                    this.listPanel.addItem(PanelFactory.getNewBoxPanel(newBox));
                    this.listPanel.refresh();
                    this.listPanel.repaint();
                }
                cont ++;
            }
            
        }
    }
    
    private synchronized void eraseDeletedPanels() {
        for(BoxPanel boxPanel: this.boxPanels) {
            boolean save = true;
            for(Box box: this.boxes) {
                if(boxPanel.getBox().getPath().getName().equals(box.getPath().getName())) {
                    save = false;
                }
            }
            if(!save) {
                System.out.println("BORRARIA");
            }
        }
    }

    private synchronized boolean checkEquals(Box box) throws BoxNotFoundException {
        
        for(BoxPanel boxPanel: this.boxPanels) {
            if(boxPanel.getBox().getPath().getName().equals(box.getPath().getName())) {
                return true;
            } 
        }
        return false;
    }

}
