package com.maxicorrea.jlogo.views.extras;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import com.maxicorrea.jlogo.views.utils.Icons;
import AppPackage.AnimationClass;

public class SelectTurtlePane extends JPanel {
  
  private static final long serialVersionUID = 1L;
  private static final int BUTTONS_LENGTH = 5;
  private static final Font FONT = DeckerFont.INSTANCE.getFont();
  
  private JButton[] buttons;
  
  public SelectTurtlePane() {
    setBackground(Color.WHITE);
    setLayout(new GridLayout(5, 1));
    setBounds(0, 490, 150, 300);
    buttons = new JButton[BUTTONS_LENGTH];
    for(int i = 0 ; i < buttons.length ; ++i) {
      buttons[i] = new JButton(Icons.load("/turtle"+(i+1)+".png"));
      buttons[i].setBorderPainted(false);
      buttons[i].setFocusable(false);
      buttons[i].setBackground(Color.WHITE);
      add(buttons[i]);
    }
  }
  
  public JButton getButton( int num ) {
    return buttons[num];
  }
  
  public JScrollPane getJScrollPaneAnimation() {
    JScrollPane pane = new JScrollPane(this);
    pane.setBackground(Color.WHITE);
    pane.setBorder(BorderFactory.createTitledBorder(null, "Tortugas", TitledBorder.TOP,
        TitledBorder.CENTER, FONT.deriveFont(Font.PLAIN, 18), Color.RED));
    pane.setBounds(0, 490, 150, 300);
    pane.getVerticalScrollBar().setForeground(Color.white);
    pane.getVerticalScrollBar().setBackground(Color.white);
     pane.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        new AnimationClass().jTextAreaYUp(490, 220, 10, 5, pane);
        new AnimationClass().jTextAreaYDown(220, 490, 10, 5, pane);
      }
    });
    return pane;
  }

  public void addButtonsListener(ActionListener listener) {
   for(JButton button : buttons) {
     button.addActionListener(listener);
   }
  }

}