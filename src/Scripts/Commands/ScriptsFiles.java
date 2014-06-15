/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Scripts.Commands;

import java.io.File;

/**
 *
 * @author julianalonso
 */
public final class ScriptsFiles {
    
    public static final File UP = new File(ScriptsFiles.class.getResource("./Up").getPath());
    public static final File SUSPEND = new File(ScriptsFiles.class.getResource("./Suspend").getPath());
    public static final File DESTROY = new File(ScriptsFiles.class.getResource("./Destroy").getPath());
    public static final File RELOAD = new File(ScriptsFiles.class.getResource("./Reload").getPath());
    public static final File RESUME = new File(ScriptsFiles.class.getResource("./Resume").getPath());
    public static final File PACKAGE = new File(ScriptsFiles.class.getResource("./Package").getPath());
    public static final File NEW_MACHINE = new File(ScriptsFiles.class.getResource("./NewMachine").getPath());
    public static final File BOX_ADD = new File(ScriptsFiles.class.getResource("./BoxAdd").getPath());
    public static final File DELETE_MACHINE = new File(ScriptsFiles.class.getResource("./DeleteMachine").getPath());
    
}