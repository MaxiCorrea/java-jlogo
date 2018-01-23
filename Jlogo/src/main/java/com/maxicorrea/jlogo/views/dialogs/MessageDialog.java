package com.maxicorrea.jlogo.views.dialogs;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MessageDialog extends Dialog {
  private static final long serialVersionUID = 1L;

  private JLabel messageLabel;
  
  public MessageDialog(JFrame owner) {
    super(owner);
    setPreferredSize(new Dimension(400,180));
    infoLabel.setFont(infoLabel.getFont().deriveFont(18f));
    infoLabel.setText("Mensaje de JLogo");
    okButton.setBounds(95, 140, 150, 40);
    centerPane.add(getMessageLabel());
    pack();
    setLocationRelativeTo(owner);
  }

  private JLabel getMessageLabel() {
    messageLabel = new JLabel();
    messageLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
    messageLabel.setFont(infoLabel.getFont().deriveFont(13f));
    return messageLabel;
  }
  
  public void message(String message) {
    messageLabel.setText(message);
  }

}
