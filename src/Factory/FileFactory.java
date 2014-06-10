/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Factory;

import java.io.File;

/**
 *
 * @author julianalonso
 */
public final class FileFactory {
    
    public static File getNewFile(String path) {
        return new File(path);
    }
    
}
