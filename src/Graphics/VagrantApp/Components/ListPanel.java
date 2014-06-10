/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Graphics.VagrantApp.Components;

import Entity.ListView;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author julianalonso
 */
public class ListPanel extends JPanel {
    
    private ListView<BoxPanel> listView = new ListView(ListView.VERTICAL);
    
    public ListPanel() {
        super();
        this.configComponents();
        this.add(this.listView);
    }
    
    public void add(BoxPanel box) {
        this.listView.add(box);
        this.listView.repaint();    
    }
    
    public void remove(BoxPanel box) {
        this.listView.remove(box);
    }
    
    public void refresh() {
        this.listView.refresh();
        this.listView.repaint();    
        this.repaint();
    }
    
    private void configComponents() {
        this.listView.setPreferredSize(new Dimension(300, 500));
        this.setBackground(Color.WHITE);
    }
     
}
