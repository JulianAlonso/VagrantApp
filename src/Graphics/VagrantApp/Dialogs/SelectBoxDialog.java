/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Graphics.VagrantApp.Dialogs;

import Entity.Destiny;
import Utils.SelectUtils;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author julianalonso
 */
public class SelectBoxDialog extends JDialog {

    private Container cp;
    private JTextField path;
    private JButton fileChooser;
    private JButton okButton;
    private File workbench;
    private JLabel folderLabel;
    private JLabel nameLabel;
    private JTextField name;
    private Destiny destiny;

    public SelectBoxDialog() {
        super((JFrame) null, "Destino", false);

        //INITS AND CONFIGS
        this.initComponents();
        this.configComponents();
        this.configDialog();

        cp = getContentPane();
        cp.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JPanel top = new JPanel(new FlowLayout());
        top.add(this.nameLabel);
        top.add(this.name);
        top.add(new JLabel());

        JPanel center = new JPanel(new FlowLayout());
        center.add(this.folderLabel);
        center.add(this.path);
        center.add(this.fileChooser);

        this.add(top);
        this.add(center);
        this.add(this.okButton);
    }

    public Destiny getDestiny() {
        return this.destiny;
    }

    private ActionListener getSelectAction() {
        return (ActionEvent e) -> {
            this.workbench = SelectUtils.selectFile();
            if (workbench != null) {
                this.path.setText(workbench.getAbsolutePath());
            }
        };
    }

    private ActionListener getcloseAction() {
        return (ActionEvent e) -> {

            if (workbench == null || name.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Selecciona una box.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                destiny.setName(name.getText());
                destiny.setPath(workbench);
                this.dispose();
            }
        };
    }

    private void initComponents() {
        this.path = new JTextField();
        this.fileChooser = new JButton("Buscar");
        this.okButton = new JButton("Continuar");
        this.folderLabel = new JLabel("Box: ");

        this.nameLabel = new JLabel("Nombre: ");
        this.name = new JTextField();
        
        this.destiny = new Destiny();
    }

    private void configComponents() {
        //PATH TEXT CONFIG
        this.path.setPreferredSize(new Dimension(250, 25));
        this.name.setPreferredSize(new Dimension(250, 25));

        //FILE CHOOSER CONFIG
        this.fileChooser.addActionListener(this.getSelectAction());

        //OK BUTTON
        this.okButton.addActionListener(this.getcloseAction());
    }

    private void configDialog() {
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        setTitle("Selecciona la box");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 130);
    }
}