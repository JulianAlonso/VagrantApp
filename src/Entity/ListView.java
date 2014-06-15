/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author julianalonso
 */
public class ListView <T> extends JPanel {
    
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
    
    private final List<T> list = new ArrayList();
    
    public ListView(int mode) {
        super();
        
        this.configComponents();
        
        if (mode == ListView.HORIZONTAL)
            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        else if (mode == ListView.VERTICAL) 
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    
    public void addItem(T t) {
        this.list.add(t);
        this.add((Component) t);
        this.repaint();
        this.refresh();
    }
    
    public synchronized void refresh() {
        this.validate();
        this.addAll();
        this.validate();
        this.repaint();
    }
    
    public synchronized void removeItem(T t) {
        for(T item: list) {
            if (item == t) {
                list.remove(t);
                this.remove((Component)t);
                this.repaint();
                this.refresh();
                return;
            }
        }
    }
    
    public synchronized void removeAllItems() {
        this.removeAll();
        this.list.clear();
    }
    
    public List<T> getItems() {
        return this.list;
    }
    
    private synchronized void addAll() {
        for(T t: list) {
            this.add((Component)t);
        }
    }
    
    private void configComponents() {
        this.setBackground(Color.WHITE);
    }
    
}
