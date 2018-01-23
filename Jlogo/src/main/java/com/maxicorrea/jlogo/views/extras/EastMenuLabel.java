package com.maxicorrea.jlogo.views.extras;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.maxicorrea.jlogo.views.dialogs.CommandsDialog;
import com.maxicorrea.jlogo.views.dialogs.MessageDialog;
import com.maxicorrea.jlogo.views.utils.Icons;
import AppPackage.AnimationClass;

public class EastMenuLabel extends JLabel {
  private static final long serialVersionUID = 1L;

  private JLabel menLabel;
  private JLabel cmdLabel;
  private JLabel calLabel;
  private JFrame owner;

  public EastMenuLabel(JFrame owner) {
    this.owner = owner;
    setLayout(null);
    setBounds(100, 0, 50, 128);
    menLabel = new JLabel(Icons.load("/menu2.png"));
    menLabel.setBounds(8, 0, 32, 32);
    add(menLabel);
    cmdLabel = new JLabel(Icons.load("/command.png"));
    cmdLabel.setBounds(190, 52, 32, 32);
    add(cmdLabel);
    calLabel = new JLabel(Icons.load("/calculator.png"));
    calLabel.setBounds(190, 94, 32, 32);
    add(calLabel);
    addListener();
  }

  private void addListener() {
    menLabel.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        new AnimationClass().jLabelXLeft(190, 10, 5, 5, cmdLabel);
        new AnimationClass().jLabelXRight(10, 190, 5, 5, cmdLabel);
        new AnimationClass().jLabelXLeft(190, 10, 5, 5, calLabel);
        new AnimationClass().jLabelXRight(10, 190, 5, 5, calLabel);
      }
    });
    calLabel.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        try {
          Runtime.getRuntime().exec("calc");
        } catch(Exception ex) {
          MessageDialog dialog = new MessageDialog(owner);
          String os = System.getProperty("os.name").toUpperCase();
          dialog.message("<html><br/><br/>No puedo localizar "
              + "la calculadora de "+os+"</html>");
          dialog.setVisible(true);
        }
      }
    });
    cmdLabel.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        CommandsDialog dialog = new CommandsDialog(owner);
        dialog.setVisible(true);
      }
    });
  }

}
