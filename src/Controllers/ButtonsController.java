/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Graphics.VagrantApp.Components.ButtonsPanel;
import Res.ButtonName;
import Res.Status;

/**
 *
 * @author julianalonso
 */
public class ButtonsController {

    private ButtonsPanel buttonsPanel;
    private MainController mainController;

    public ButtonsController(ButtonsPanel buttonsPanel, MainController mainController) {
        this.buttonsPanel = buttonsPanel;
        this.mainController = mainController;
    }

    public void play() {
        System.out.println("play()");
    }

    public void pause() {
        System.out.println("pause()");
    }

    public void stop() {
        System.out.println("stop()");
    }

    public void addBox() {
        System.out.println("addBox()");
    }
    
    public void configButtons(Status status) {
        this.enableButtons(status);
        this.disableButtons(status);
    }
    
    private void enableButtons(Status status) {
        switch(status) {
            case RUNNING:
                buttonsPanel.getButton(ButtonName.STOP).setEnabled(true);
                buttonsPanel.getButton(ButtonName.PAUSE).setEnabled(true);
                break;
            case PAUSED:
            case STOPED:
                buttonsPanel.getButton(ButtonName.PLAY).setEnabled(true);
                break;
        }
    }
    
    private void disableButtons(Status status) {
        switch (status) {
            case RUNNING:
                buttonsPanel.getButton(ButtonName.PLAY).setEnabled(false);
                break;
            case PAUSED:
            case STOPED:
                buttonsPanel.getButton(ButtonName.STOP).setEnabled(false);
                buttonsPanel.getButton(ButtonName.PAUSE).setEnabled(false);
                break;
            case NOT_SELECTED:
                buttonsPanel.getButton(ButtonName.PLAY).setEnabled(false);
                buttonsPanel.getButton(ButtonName.STOP).setEnabled(false);
                buttonsPanel.getButton(ButtonName.PAUSE).setEnabled(false);
                break;
        }
    }

}
