/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.VagrantfileDao;
import Dto.VagrantfileDto;
import Graphics.VagrantApp.Components.FilePanel;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author julianalonso
 */
public class FileController {

    private MainController mainController;
    private VagrantfileDao vagrantfileDao;
    private FilePanel filePanel;
    
    public FileController(FilePanel filePanel, MainController mainController){
        this.mainController = mainController;
        this.filePanel = new FilePanel();
        this.vagrantfileDao = new VagrantfileDao();
    }
    
    public void guardar(VagrantfileDto vagrantfileDto) throws IOException {
        File vagrantfile = this.mainController.getSelectedPanel().getBox().getVagrantfile();
        
        vagrantfileDao.writeVagrantfile(vagrantfileDto, vagrantfile);
        System.out.println("VUELVO");
    }

}
