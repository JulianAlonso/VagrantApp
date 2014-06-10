/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exceptions;

/**
 *
 * @author julianalonso
 */
public class WorkbenchNotFoundException extends Exception {
    
    public WorkbenchNotFoundException() {
        super("Carpeta de trabajo no encontrada.");
    }
    
}
