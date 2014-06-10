/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import Res.Status;
import java.io.File;

/**
 *
 * @author julianalonso
 */
public class Box {
    
    private String name;
    private File path;
    private File vagrantfile;
    private Status status;
    
    public Box() {
        this.status = Status.STOPED;
    }
    
    public Box(String name, File path, File vagrantfile) {
        this.name = name;
        this.path = path;
        this.vagrantfile = vagrantfile;
        this.status = Status.STOPED;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPath(File path) {
        this.path = path;
    }
    
    public void setVagrantfile(File vagrantfile) {
        this.vagrantfile = vagrantfile;
    }
    
    public String getName() {
        return this.name;
    }
    
    public File getPath() {
        return this.path;
    }
    
    public File getVagrantfile() {
        return this.vagrantfile;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
}
