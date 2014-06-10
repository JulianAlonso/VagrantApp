/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Graphics.VagrantApp.Components;

import Entity.ListView;
import Graphics.VagrantApp.Components.MicroComponents.Button;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author julianalonso
 */
public class ButtonsPanel extends JPanel {
    
    private ListView<Button> buttonList = new ListView(ListView.HORIZONTAL);
    
    public ButtonsPanel() {
        super();
        this.configComponents();
        this.add(buttonList);
    }
    
    public void addButton(Button button) {
        this.buttonList.addItem(button);
    }
    
    public void remove(Button button) {
        this.buttonList.remove(button);
    }
    
    public void refresh() {
        buttonList.refresh();
        this.repaint();
    }
    
    public Button getButton(String name) {
        for (Button button: buttonList.getItems()) {
            if (button.getName().equals(name))
                return button;
        }
        return null;
    }
    
    private void configComponents() {
        this.setBackground(Color.WHITE);
    }
    
}
