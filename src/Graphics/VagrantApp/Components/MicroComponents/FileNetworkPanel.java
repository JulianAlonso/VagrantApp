/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Graphics.VagrantApp.Components.MicroComponents;

import Dto.NetworkDto;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author julianalonso
 */
public class FileNetworkPanel extends JPanel {
    
    private String[] networks = {"private_network", "forwarded_port"};
    private String[] types = {"dhcp", "ip"};
    
    private JComboBox networksCombo;
    private JComboBox typesCombo;
    
    //FORWARED PORT
    private JLabel guest, host;
    private JTextField guestField, hostField;
    
    //PRIVATE NETWORK
    //IF TYPE == DHCP
    private JLabel type;
    //IF TYPE == IP
    private JLabel ip;
    private JTextField ipField;
    
    public FileNetworkPanel() {
        super(new FlowLayout());
        
        this.initComponents();
        this.configComponents();
        
        this.add(this.networksCombo);
        this.add(this.typesCombo);
        this.add(this.type);
    }
    
    
    public NetworkDto getNetworkDto() {
        NetworkDto network = new NetworkDto();
        
        network.setNetwork((String)networksCombo.getSelectedItem());
        
        if (network.getNetwork().equals("private_network")) {
            network.setType((String)this.typesCombo.getSelectedItem());
            if (network.getType().equals("ip")) {
                network.setIp(this.ipField.getText());
            }
        } else {
            network.setGuestPort(this.guestField.getText());
            network.setHostPort(this.hostField.getText());
        }
        
        return network;
    }
    
    
    private void initComponents() {
        this.networksCombo = new JComboBox(networks);
        this.typesCombo = new JComboBox(types);
        
        this.guest = new JLabel("Guest port: ");
        this.host = new JLabel("Host port: ");
        this.guestField = new JTextField();
        this.hostField = new JTextField();
        
        this.type = new JLabel("dhcp");
        
        this.ip = new JLabel("IP: ");
        this.ipField = new JTextField();
        
        
    }
    
    private void configComponents() {
        this.guestField.setPreferredSize(new Dimension(80, 25));
        this.hostField.setPreferredSize(new Dimension(80, 25));
        this.ipField.setPreferredSize(new Dimension(110, 25));
        
        this.networksCombo.addActionListener(this.getNetworksListener());
        this.typesCombo.addActionListener(this.getTypeListener());
    }
    
    private ActionListener getNetworksListener() {
        return (ActionEvent e) -> {
            JComboBox c = (JComboBox)e.getSource();
            String selected = (String)c.getSelectedItem();
            
            if (selected.equals("private_network")) {
                this.removeFromPrivate();
                this.addFromPrivate();
            } else {
                this.removeFromForwardedPort();
                this.addFromForwardedPort();
            }
            this.revalidate();
            this.repaint();
        };
    }
    
    private ActionListener getTypeListener() {
        return (ActionEvent e) -> {
            JComboBox c = (JComboBox)e.getSource();
            String selected = (String)c.getSelectedItem();
            
            if (selected.equals("ip")) {
                this.removeFromIp();
                this.addFromIp();
            } else {
                this.removeFromDHCP();
                this.addFromDHCP();
            }
            this.revalidate();
            this.repaint();
        };
    }
    
    private void addFromIp() {
        this.add(this.ip);
        this.add(this.ipField);
    }
    
    private void removeFromIp() {
        this.remove(this.type);
    }
    
    private void addFromDHCP() {
        this.add(this.type);
    }
    
    private void removeFromDHCP() {
        this.remove(this.ip);
        this.remove(this.ipField);
    }
    
    private void addFromPrivate() {
        this.add(this.typesCombo);
    }
    
    private void removeFromPrivate() {
        this.remove(this.guest);
        this.remove(this.guestField);
        this.remove(this.host);
        this.remove(this.hostField);
    }
    
    private void addFromForwardedPort() {
        this.add(this.guest);
        this.add(this.guestField);
        this.add(this.host);
        this.add(this.hostField);
    }
    
    private void removeFromForwardedPort() {
        this.remove(this.type);
        this.remove(this.typesCombo);
        this.remove(this.ipField);
        this.remove(this.ip);
    }
}
