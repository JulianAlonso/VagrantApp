/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Exceptions.ScriptNotFoundException;
import Interfaces.CommandInterface;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julianalonso
 */
public class Command implements CommandInterface{

    private OutputMap output;
    private File script;
    private List<String> args;
    private String message;
    
    public Command() {
        output = new OutputMap();
    }

    @Override
    public void setArgs(List<String> args) {
        this.args = args;
    }

    @Override
    public void setScript(File script) {
        this.script = script;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    @Override
    public OutputMap execute() throws IOException, ScriptNotFoundException {
        
        if (script == null || !script.exists()) {
            throw new ScriptNotFoundException();
        }
        
        List<String> list = new ArrayList();
        list.add("/bin/sh");
        list.add(script.getAbsolutePath());
        list.addAll(args);
        
        ProcessBuilder pb = new ProcessBuilder(list);
        Process p = pb.start();
        
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));

        String out;
        List<String> outOk = new ArrayList();
        List<String> outErr = new ArrayList();
        while ((out = input.readLine()) != null) {
            outOk.add(out);
        }
        while ((out = error.readLine()) != null) {
            outErr.add(out);
        }
        
        output.put("out", outOk);
        output.put("error", outErr);
        
        return output;
    }

}
