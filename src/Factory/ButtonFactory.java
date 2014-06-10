/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Controllers.ButtonsController;
import Graphics.VagrantApp.Components.MicroComponents.Button;
import Res.ButtonName;
import Res.Images.Images;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author julianalonso
 */
public final class ButtonFactory {

    private static ButtonsController buttonsController;
    
    public static final int PLAY = 0;
    public static final int PAUSE = 1;
    public static final int STOP = 2;
    public static final int BOX_ADD = 3;

    public static Button getButton(int type) {
        Button button = null;
        switch (type) {
            case 0:
                button = new Button(Images.PLAY);
                button.addMouseListener(play());
                button.setName(ButtonName.PLAY);
                button.setEnabled(false);
                break;
            case 1:
                button = new Button(Images.PAUSE);
                button.addMouseListener(pause());
                button.setName(ButtonName.PAUSE);
                button.setEnabled(false);
                break;
            case 2:
                button = new Button(Images.STOP);
                button.addMouseListener(stop());
                button.setName(ButtonName.STOP);
                button.setEnabled(false);
                break;
            case 3:
                button = new Button(Images.ADD_BOX);
                button.addMouseListener(addBox());
                button.setName(ButtonName.BOX_ADD);
                break;
        }
        return button;
    }
    
    public static void setButtonsController(ButtonsController buttonsController) {
        ButtonFactory.buttonsController = buttonsController;
    }
    
    public static MouseListener play() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ButtonFactory.buttonsController.play();
            }
        };
    }
    
    public static MouseListener pause() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ButtonFactory.buttonsController.pause();
            }
        };
    }
    
    public static MouseListener stop() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ButtonFactory.buttonsController.stop();
            }
        };
    }
    
    public static MouseListener addBox() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ButtonFactory.buttonsController.addBox();
            }
        };
    }
    
}
