/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import Graphics.VagrantApp.Components.BoxPanel;
import Graphics.VagrantApp.Components.ButtonsPanel;
import Graphics.VagrantApp.Components.FilePanel;
import Graphics.VagrantApp.Components.ListPanel;
import Res.Status;
import java.awt.Color;

/**
 *
 * @author julianalonso
 */
public class MainController {
    
    private ButtonsController buttonsController;
    private BoxPanelController boxPanelController;
    private FileController fileController; 
    private BoxPanel selectedPanel;
    
    public MainController(ButtonsPanel buttonsPanel, ListPanel listPanel, FilePanel filePanel) {
        
        this.buttonsController = new ButtonsController(buttonsPanel, this);
        this.boxPanelController = new BoxPanelController(listPanel, this);
        this.fileController = new FileController(filePanel, this);
        
    }

    public FileController getFileController() {
        return fileController;
    }
    
    public ButtonsController getButtonsController() {
        return this.buttonsController;
    }
    
    public BoxPanelController getBoxPanelController() {
        return this.boxPanelController;
    }
    
    public BoxPanel getSelectedPanel() {
        return this.selectedPanel;
    }
    
    public void changeActualStatus(Status status) {
        this.selectedPanel.getBox().setStatus(status);
        this.configButtons();
    }
    
    public void configButtons() {
        if (this.selectedPanel != null)
            this.buttonsController.configButtons(this.selectedPanel.getBox().getStatus());
        else
            this.buttonsController.configButtons(Status.NOT_SELECTED);
    }
    
    public void setSelectedPanel(BoxPanel selectedPanel) {
        selectedPanel.setBackground(Color.GRAY);
        this.selectedPanel = selectedPanel;
        
        this.configButtons();
    }
    
    public void unselectActualPanel() {
        if (this.selectedPanel != null) {
            this.selectedPanel.setBackground(Color.WHITE);
        }
        this.selectedPanel = null;
        this.configButtons();
    }
    
}
