/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import Graphics.VagrantApp.Components.BoxPanel;
import Graphics.VagrantApp.Components.ListPanel;

/**
 *
 * @author julianalonso
 */
public class BoxPanelController {
    
    private ListPanel listPanel;
    private MainController mainController;
    
    public BoxPanelController(ListPanel listPanel, MainController mainController) {
        this.listPanel = listPanel;
        this.mainController = mainController;
    }
    
    public void onClick(BoxPanel boxPanel) {
        this.mainController.unselectActualPanel();
        this.mainController.setSelectedPanel(boxPanel);
    }
    
    
    
}
