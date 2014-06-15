/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Graphics.VagrantApp;

import Controllers.MainController;
import Factory.ButtonFactory;
import Factory.PanelFactory;
import Graphics.VagrantApp.Components.ButtonsPanel;
import Graphics.VagrantApp.Components.FilePanel;
import Graphics.VagrantApp.Components.ListPanel;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author julianalonso
 */
public class MainFrame extends JFrame {
    
    private ButtonsPanel buttonsPanel;
    private ListPanel listPanel;
    private JScrollPane list;
    private FilePanel filePanel;
    private MainController mainController;
    
    public MainFrame() {
        super("Vagrant App");
        
        this.initComponents();
        this.initControllers();
        this.configComponents();
        this.loadButtons();
        
        this.setLayout(new BorderLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 5;
        c.gridheight = 1;
        c.ipadx = 1;
        c.ipady = 1;
        this.add(this.buttonsPanel, BorderLayout.NORTH);
        
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 5;
        c.gridheight = 10;
        c.ipadx = 1;
        c.ipady = 1;
        this.add(this.list, BorderLayout.WEST);
        
        c.gridx = 1;
        c.gridy = 6;
        c.gridwidth = 7;
        c.gridheight = 10;
        c.ipadx = 0;
        c.ipady = 0;
        this.add(this.filePanel, BorderLayout.CENTER);
    }
    
    public ListPanel getListPanel() {
        return this.listPanel;
    }
    
    private void initComponents() {
        this.buttonsPanel = new ButtonsPanel();
        this.listPanel = new ListPanel();
        this.list = new JScrollPane(listPanel);
        this.filePanel = new FilePanel();
    }
    
    private void initControllers() {
        mainController = new MainController(this.buttonsPanel, this.listPanel, this.filePanel);
        ButtonFactory.setButtonsController(mainController.getButtonsController());
        PanelFactory.setBoxPanelController(mainController.getBoxPanelController());
        this.filePanel.setFileController(mainController.getFileController());
    }
    
    private void loadButtons() {
        this.buttonsPanel.addButton(ButtonFactory.getButton(ButtonFactory.PLAY));
        this.buttonsPanel.addButton(ButtonFactory.getButton(ButtonFactory.PAUSE));
        this.buttonsPanel.addButton(ButtonFactory.getButton(ButtonFactory.STOP));
        this.buttonsPanel.addButton(ButtonFactory.getButton(ButtonFactory.RELOAD));
        this.buttonsPanel.addButton(ButtonFactory.getButton(ButtonFactory.PACKAGE));
        this.buttonsPanel.addButton(ButtonFactory.getButton(ButtonFactory.BOX_ADD));
        this.buttonsPanel.addButton(ButtonFactory.getButton(ButtonFactory.NEW_MACHINE));
        this.buttonsPanel.addButton(ButtonFactory.getButton(ButtonFactory.DELETE_MACHINE));
        
    }
    
    private void configComponents() {
        this.listPanel.addMouseListener(click());
    }
    
    private MouseListener click() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                mainController.unselectActualPanel();
            }
        };
    }
}
