/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Factory;

import Controllers.BoxPanelController;
import Entity.Box;
import Exceptions.BoxNotFoundException;
import Graphics.VagrantApp.Components.BoxPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author julianalonso
 */
public final class PanelFactory {
    
    private static BoxPanelController boxPanelController;
    
    public static BoxPanel getNewBoxPanel(Box box) throws BoxNotFoundException {
        BoxPanel boxPanel = new BoxPanel(box);
        
        boxPanel.addMouseListener(onClick());
        
        return boxPanel;
    }
    
    public static void setBoxPanelController(BoxPanelController boxPanelController) {
        PanelFactory.boxPanelController = boxPanelController;
    }
    
    public static MouseListener onClick() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                boxPanelController.onClick((BoxPanel)me.getSource());
            }
        };
    }
    
}
