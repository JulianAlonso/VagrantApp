/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Entity.OutputMap;
import Exceptions.ScriptNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author julianalonso
 */
public interface CommandInterface {
    
    public void setArgs(List<String> args);
    
    public void setScript(File script);
    
    public OutputMap ejecutar() throws IOException, ScriptNotFoundException;
    
}
