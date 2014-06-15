/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Interfaces;

import Dto.VagrantfileDto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author julianalonso
 */
public interface VagrantfileDaoI {
    
    public void writeVagrantfile(VagrantfileDto vagrantfileDto, File vagrantfile) throws FileNotFoundException, IOException;
    
    public VagrantfileDto readVagrantfile(VagrantfileDto vagrantfileDto, File vagrantfile);
    
}
