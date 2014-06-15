/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Graphics.VagrantApp.Components;

import Entity.ListView;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
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
    
    public void addItem(BoxPanel box) {
        this.listView.addItem(box);
        this.listView.repaint();    
    }
    
    public void removeAllItems() {
        this.listView.removeAllItems();
    }
    
    public void removeItem(BoxPanel box) {
        this.listView.removeItem(box);
        this.listView.repaint();
    }
    
    public List<BoxPanel> getAll() {
        return this.listView.getItems();
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
