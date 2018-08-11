package com.maxicorrea.jlogo.views.dialogs;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InfoDialog extends Dialog {

  private static final long serialVersionUID = 1L;

  public InfoDialog(JFrame owner) {
    super(owner);
    setSize( new Dimension(430, 180));
    infoLabel.setText("¿Que es Logo?");
    okButton.setBounds(129, 340, 150, 40);
    okButton.setText("Cerrar");
    centerPane.add(getInfoLabel());
    setLocationRelativeTo(owner);
  }

  private JLabel getInfoLabel() {
    JLabel info = new JLabel("",JLabel.CENTER);
    info.setFont(infoLabel.getFont().deriveFont(13f));
    info.setText("<html>Es un lenguaje de programación; es un lenguaje de computadora <br/> "
        + "completo derivado de LISP ( el lenguaje más prominente para el<br/>  "
        + "tratamiento de temas de inteligencia artificial ). Sin embargo, y más<br/> importante, "
        + "Logo es un lenguaje para aprender.</html> ");
    return info;
  }

}