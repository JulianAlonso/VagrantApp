/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Res;

import Entity.Box;
import Exceptions.BoxNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author julianalonso
 */
public final class Boxes {
    
    private static Map<String, Box> Boxes = new HashMap();
    
    public static synchronized void addBox(Box box) {
        Boxes.put(box.getName(), box);
    }
    
    public static synchronized Box getBox(String nombre) throws BoxNotFoundException {
        Box box = Boxes.get(nombre);
        if (box == null) {
            throw new BoxNotFoundException();
        }
        return box;
    }
    
    public static synchronized void removeBox(String name) {
        Boxes.remove(name);
    }
    
}
