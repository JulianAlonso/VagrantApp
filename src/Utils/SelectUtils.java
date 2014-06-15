/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author julianalonso
 */
public class SelectUtils {
    
    public static File selectDirectory() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(null);
        
        if(returnVal == JFileChooser.APPROVE_OPTION)
            return chooser.getSelectedFile();
        else
            return null;
    }
    
    public static File selectFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = chooser.showOpenDialog(null);
        
        if(returnVal == JFileChooser.APPROVE_OPTION)
            return chooser.getSelectedFile();
        else
            return null;
    }
}
