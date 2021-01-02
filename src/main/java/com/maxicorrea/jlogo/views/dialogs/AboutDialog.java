package com.maxicorrea.jlogo.views.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.maxicorrea.jlogo.views.utils.Icons;

public class AboutDialog extends Dialog {
  private static final long serialVersionUID = 1L;

  public AboutDialog(JFrame owner) {
    super(owner);
    contentPane.setPreferredSize(new Dimension(300, 320));
    infoLabel.setText("");
    infoLabel.setIcon(Icons.INSTANCE.load("/logo_about.png"));
    addInfoLabels();
    okButton.setText("Cerrar");
    okButton.setBounds(75, 250, 150, 40);
    pack();
    setLocationRelativeTo(owner);
  }

  private void addInfoLabels() {
    centerPane.add(createLabel("Desarrollado por : Maximiliano Correa"));
    centerPane.add(createLabel("Email : jmaxicorrea@gmail.com"));
    centerPane.add(createLabel("Version Alpha"));
    centerPane.add(createLabel("2017"));
  }

  private JLabel createLabel(String text) {
    JLabel label = new JLabel(text, JLabel.CENTER);
    label.setFont(infoLabel.getFont().deriveFont(15f));
    label.setPreferredSize(new Dimension(290, 20));
    label.setForeground(Color.BLACK);
    return label;
  }

}
