package com.maxicorrea.jlogo.views.extras;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.maxicorrea.jlogo.views.animation.Animation;
import com.maxicorrea.jlogo.views.dialogs.AboutDialog;
import com.maxicorrea.jlogo.views.dialogs.InfoDialog;
import com.maxicorrea.jlogo.views.utils.Icons;

public class WestMenuLabel extends JLabel {
  private static final long serialVersionUID = 1L;

  private JLabel menLabel;
  private JLabel devLabel;
  private JLabel infLabel;
  private JFrame owner;

  public WestMenuLabel(JFrame owner) {
    this.owner = owner;
    setLayout(null);
    setBounds(0, 0, 50, 128);
    menLabel = new JLabel(Icons.INSTANCE.load("/menu1.png"));
    menLabel.setBounds(10, 0, 32, 32);
    add(menLabel);
    devLabel = new JLabel(Icons.INSTANCE.load("/dev.png"));
    devLabel.setBounds(-40, 52, 32, 32);
    add(devLabel);
    infLabel = new JLabel(Icons.INSTANCE.load("/question.png"));
    infLabel.setBounds(-40, 94, 32, 32);
    add(infLabel);
    addListener();
  }

  private void addListener() {
    menLabel.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        Animation.INSTANCE.jLabelXRight(-40, 10, 10, 5, devLabel);
        Animation.INSTANCE.jLabelXLeft(10, -40, 10, 5, devLabel);
        Animation.INSTANCE.jLabelXRight(-40, 10, 10, 5, infLabel);
        Animation.INSTANCE.jLabelXLeft(10, -40, 10, 5, infLabel);
      }
    });
    devLabel.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        AboutDialog dialog = new AboutDialog(owner);
        dialog.setVisible(true);
      }
    });
    infLabel.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        InfoDialog dialog = new InfoDialog(owner);
        dialog.setVisible(true);
      }
    });
  }

}
