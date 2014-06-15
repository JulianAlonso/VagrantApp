/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entity.Destiny;
import Factory.CommandFactory;
import Graphics.VagrantApp.Components.ButtonsPanel;
import Graphics.VagrantApp.Dialogs.SelectBoxDialog;
import Graphics.VagrantApp.Dialogs.SelectDestinyDialog;
import Res.ButtonName;
import Res.Orders;
import Res.Status;
import Utils.ArgsUtils;
import java.util.ArrayList;

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
        if (this.mainController.getSelectedPanel().getBox().getStatus() == Status.PAUSED)
            CommandFactory.createAndExecuteCommand(this.mainController.getSelectedPanel(), Orders.RESUME, new ArrayList());
        else
            CommandFactory.createAndExecuteCommand(this.mainController.getSelectedPanel(), Orders.UP, new ArrayList());
        this.mainController.changeActualStatus(Status.RUNNING);
    }

    public void pause() {
        this.mainController.changeActualStatus(Status.PAUSED);
        CommandFactory.createAndExecuteCommand(this.mainController.getSelectedPanel(), Orders.SUSPEND, new ArrayList());
    }

    public void stop() {
        this.mainController.changeActualStatus(Status.STOPED);
        CommandFactory.createAndExecuteCommand(this.mainController.getSelectedPanel(), Orders.DESTROY, new ArrayList());
    }
    
    public void packageV() {
        SelectDestinyDialog dialog = new SelectDestinyDialog(true);
        dialog.setVisible(true);
        Destiny destiny = dialog.getDestiny();
        CommandFactory.createAndExecuteCommand(this.mainController.getSelectedPanel(), Orders.PACKAGE, ArgsUtils.getArgs(destiny));
    }
    
    public void newMachine() {
        SelectDestinyDialog dialog = new SelectDestinyDialog(false);
        dialog.setVisible(true);
        Destiny destiny = dialog.getDestiny();
        CommandFactory.createAndExecuteCommand(null, Orders.NEW_MACHINE, ArgsUtils.getArgs(destiny));
    }
    
    public void configButtons(Status status) {
        this.enableButtons(status);
        this.disableButtons(status);
    }
    
    public void boxAdd() {
        SelectBoxDialog dialog = new SelectBoxDialog();
        dialog.setVisible(true);
        Destiny destiny = dialog.getDestiny();
        CommandFactory.createAndExecuteCommand(null, Orders.BOX_ADD, ArgsUtils.getArgs(destiny));
    }
    
    public void deleteMachine() {
        CommandFactory.createAndExecuteCommand(this.mainController.getSelectedPanel(), Orders.DELETE_MACHINE, new ArrayList());
    }
    
    public void reload() {
        CommandFactory.createAndExecuteCommand(this.mainController.getSelectedPanel(), Orders.RELOAD, new ArrayList());
    }
     
    private void enableButtons(Status status) {
        switch(status) {
            case RUNNING:
                buttonsPanel.getButton(ButtonName.STOP).setEnabled(true);
                buttonsPanel.getButton(ButtonName.PAUSE).setEnabled(true);
                buttonsPanel.getButton(ButtonName.RELOAD).setEnabled(true);
                buttonsPanel.getButton(ButtonName.PACKAGE).setEnabled(true);
                break;
            case PAUSED:
            case STOPED:
                buttonsPanel.getButton(ButtonName.PLAY).setEnabled(true);
                buttonsPanel.getButton(ButtonName.PACKAGE).setEnabled(true);
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
                buttonsPanel.getButton(ButtonName.RELOAD).setEnabled(false);
                break;
            case NOT_SELECTED:
                buttonsPanel.getButton(ButtonName.PLAY).setEnabled(false);
                buttonsPanel.getButton(ButtonName.STOP).setEnabled(false);
                buttonsPanel.getButton(ButtonName.PAUSE).setEnabled(false);
                buttonsPanel.getButton(ButtonName.RELOAD).setEnabled(false);
                buttonsPanel.getButton(ButtonName.PACKAGE).setEnabled(false);
                break;
        }
    }

}
