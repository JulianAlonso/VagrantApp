/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import Entity.Box;
import Entity.Destiny;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julianalonso
 */
public class ArgsUtils {
    
    public static List<String> getArgs(Destiny destiny) {
        List<String> args = new ArrayList();
        args.add(destiny.getPath().getAbsolutePath());
        args.add(destiny.getName());
        return args;
    }
    
    public static List<String> getArgs(Box box) {
        List<String> args = new ArrayList();
        args.add(box.getPath().getAbsolutePath());
        return args;
    }
    
    public static List<String> getArgs(Box box, List<String> args) {
        List<String> list = new ArrayList();
        list.add(box.getPath().toString());
        list.addAll(args);
        return list;
    }
    
}
