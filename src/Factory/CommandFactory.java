/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Factory;

import Entity.Command;
import Entity.OutputMap;
import Graphics.VagrantApp.Components.BoxPanel;
import Res.Orders;
import Scripts.Commands.ScriptsFiles;
import Threads.LaunchCommandThread;
import Utils.ArgsUtils;
import java.util.List;

/**
 *
 * @author julianalonso
 */
public class CommandFactory {
    
    public static OutputMap createAndExecuteCommand(BoxPanel boxPanel, Orders order, List<String> args) {
        
        Command command = new Command();
        
        switch (order) {
            case UP:
                command.setScript(ScriptsFiles.UP);
                command.setMessage("Maquina encendida!");
                break;
            case DESTROY:
                command.setScript(ScriptsFiles.DESTROY);
                command.setMessage("Maquina apagada!");
                break;
            case SUSPEND:
                command.setScript(ScriptsFiles.SUSPEND);
                command.setMessage("Maquina suspendida!");
                break;
            case RESUME:
                command.setScript(ScriptsFiles.RESUME);
                command.setMessage("Maquina reanudada!");
                break;
            case PACKAGE:
                command.setScript(ScriptsFiles.PACKAGE);
                command.setMessage("Maquina empaquetada!");
                break;
            case NEW_MACHINE:
                command.setScript(ScriptsFiles.NEW_MACHINE);
                command.setMessage("Maquina Creada!");
                break;
            case BOX_ADD:
                command.setScript(ScriptsFiles.BOX_ADD);
                command.setMessage("Maquina importada!");
                break;
            case DELETE_MACHINE:
                command.setScript(ScriptsFiles.DELETE_MACHINE);
                command.setMessage("Maquina borrada");
                break;
            case RELOAD:
                command.setScript(ScriptsFiles.RELOAD);
                command.setMessage("Reload exitoso");
                break;
        }
        
        if (boxPanel != null)
            command.setArgs(ArgsUtils.getArgs(boxPanel.getBox(), args));
        else
            command.setArgs(args);
        LaunchCommandThread launch = new LaunchCommandThread(command, boxPanel);
        launch.start();
        
        return null;
    }
    
   
    
}
