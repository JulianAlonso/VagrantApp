/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author julianalonso
 */
public class OutputMap {
    
    Map<String, Object> output = new HashMap();
    
    public OutputMap() {
        
    }
    
    public void put(String key, List<String> list) {
        output.put(key, list);
    }
    
    public List<String> get(String key) {
        return (List<String>)output.get(key);
    }
    
}
