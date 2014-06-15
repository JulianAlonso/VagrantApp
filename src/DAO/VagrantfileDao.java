/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dto.VagrantfileDto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julianalonso
 */
public class VagrantfileDao {

    private boolean firstTime = true;
    private boolean fistTimeBox = true;

    public VagrantfileDao() {
        super();
    }

    public void writeVagrantfile(VagrantfileDto vagrantfileDto, File vagrantfile) {
        BufferedReader bf = null;
        try {
            List<String> lines = new ArrayList();
            bf = new BufferedReader(new FileReader(vagrantfile));
            String line;
            while ((line = bf.readLine()) != null) {
                if (line.contains("config.vm.network") && this.firstTime) {
                    line = vagrantfileDto.getNetworkConfig();
                    this.firstTime = false;
                } else if (line.contains("config.vm.box") && this.fistTimeBox) {
                    line = vagrantfileDto.getBoxConfig();
                    System.out.println("LINE BOX: " + line);
                }
                
                lines.add(line);
            }   bf.close();
            
            this.writeLines(lines, vagrantfile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VagrantfileDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VagrantfileDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bf.close();
                return;
            } catch (IOException ex) {
                Logger.getLogger(VagrantfileDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public VagrantfileDto readVagrantfile(VagrantfileDto vagrantfileDto, File vagrantfile) {
        return null;
    }

    private void writeLines(List<String> lines, File file) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            for (String l : lines) {
                bw.newLine();
                bw.write(l);
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(VagrantfileDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
                return;
            } catch (IOException ex) {
                Logger.getLogger(VagrantfileDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
