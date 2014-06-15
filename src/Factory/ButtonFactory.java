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
    public static final int NEW_MACHINE = 3;
    public static final int PACKAGE = 4;
    public static final int BOX_ADD = 5;
    public static final int DELETE_MACHINE = 6;
    public static final int RELOAD = 7;

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
                button = new Button(Images.NEW_MACHINE);
                button.addMouseListener(newMachine());
                button.setName(ButtonName.NEW_MACHINE);
                break;
            case 4:
                button = new Button(Images.PACKAGE);
                button.addMouseListener(packageV());
                button.setName(ButtonName.PACKAGE);
                button.setEnabled(false);
                break;
            case 5:
                button = new Button(Images.BOX_ADD);
                button.addMouseListener(boxAdd());
                button.setName(ButtonName.BOX_ADD);
                break;
            case 6:
                button = new Button(Images.DELETE_MACHINE);
                button.addMouseListener(deleteMachine());
                button.setName(ButtonName.DELETE_MACHINE);
                break;
            case 7:
                button = new Button(Images.RELOAD);
                button.addMouseListener(reload());
                button.setName(ButtonName.RELOAD);
                button.setEnabled(false);
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
    
    public static MouseListener newMachine() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ButtonFactory.buttonsController.newMachine();
            }
        };
    }
    
    public static MouseListener packageV() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ButtonFactory.buttonsController.packageV();
            }
        };
    }
    
    public static MouseListener boxAdd() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ButtonFactory.buttonsController.boxAdd();
            }
        };
    }
    
    public static MouseListener deleteMachine() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ButtonFactory.buttonsController.deleteMachine();
            }
        };
    }
    
    public static MouseListener reload() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ButtonFactory.buttonsController.reload();
            }
        };
    }
}
