package com.maxicorrea.jlogo.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.maxicorrea.jlogo.controllers.GameController;
import com.maxicorrea.jlogo.views.dialogs.MessageDialog;
import com.maxicorrea.jlogo.views.extras.DeckerFont;

public class CommandView extends JPanel {
  
  private static final long serialVersionUID = 1L;
  private static final Font FONT = DeckerFont.INSTANCE.getFont();

  private JTextField commandField;
  private JLabel executeLabel;
  private JFrame owner;
  
  public CommandView(JFrame owner) {
    this.owner = owner;
    setBackground(Color.WHITE);
    setLayout(new FlowLayout(FlowLayout.RIGHT,0,5));
    commandField = new JTextField();
    commandField.setPreferredSize( new Dimension(512,30));
    Font font = new Font("Monospace", Font.PLAIN, 17);
    commandField.setFont(font);
    add(commandField);
    JLabel space = new JLabel();
    space.setPreferredSize( new Dimension(29, 10));
    add(space);
    executeLabel = new JLabel("Ejecutar",0);
    executeLabel.setPreferredSize( new Dimension(140,30));
    executeLabel.setFont(FONT.deriveFont(Font.BOLD,18));
    executeLabel.setForeground(Color.WHITE);
    executeLabel.setBackground(Color.RED);
    executeLabel.setOpaque(true);
    add(executeLabel);
  }

  public void setController(GameController controller) {
    commandField.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        processCommand(controller);
      }
    });
    executeLabel.addMouseListener( new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        processCommand(controller);
      }
    });
  }
  
  private void processCommand(GameController controller) {
    if(!controller.processCommand(commandField.getText())) {
      MessageDialog dialog = new MessageDialog(owner);
      dialog.message(controller.getErrorMessage());
      dialog.setVisible(true);
    }
    commandField.setText("");
    getParent().repaint();
  }
  
}
