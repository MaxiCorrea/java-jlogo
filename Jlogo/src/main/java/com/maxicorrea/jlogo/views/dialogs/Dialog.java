package com.maxicorrea.jlogo.views.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import com.maxicorrea.jlogo.views.extras.DeckerFont;

public class Dialog extends JDialog {

  public static final int ACCEPTED = 0;
  
  private static final long serialVersionUID = 1L;
  private static final Font FONT = DeckerFont.INSTANCE.getFont();
  private static final int WIDTH = 340;
  private static final int HEIGHT = 200;
  
  protected JPanel contentPane;
  protected JPanel centerPane;
  protected JPanel northPane;
  protected JPanel eastPane;
  protected JPanel westPane;
  protected JPanel southPane;
  
  protected JLabel infoLabel;
  protected JButton okButton;
  protected int input;

  public Dialog(JFrame owner) {
    super(owner);
    setModal(true);
    setUndecorated(true);
    setDefaultCloseOperation(2);
    setLocationRelativeTo(owner);
    setContentPane(createContentPane());
    UIManager.put("ToolTip.background",new ColorUIResource(Color.WHITE)); 
  }

  private JPanel createContentPane() {
    contentPane = new JPanel(new BorderLayout());
    contentPane.setBackground(Color.LIGHT_GRAY);
    contentPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    contentPane.setBorder( new EmptyBorder(3, 3, 3, 3));
    contentPane.add(createNorthPane() , "North");
    contentPane.add(createCenterPane() , "Center");
    contentPane.add( createWestPane(), "West");
    contentPane.add(createEastPane(), "East");
    contentPane.add(createSouthPane(), "South");
    return contentPane;
  }
  
  private JPanel createNorthPane() {
    northPane = new JPanel();
    northPane.setBackground(Color.WHITE);
    northPane.add(getInfoLabel());
    return northPane;
  }
  
  private JPanel createCenterPane() {
    centerPane = new JPanel();
    centerPane.setBackground(Color.WHITE);
    return centerPane;
  }
  
  private JPanel createWestPane() {
    westPane = new JPanel();
    westPane.setBackground(Color.WHITE);
    return westPane;
  }
  
  private JPanel createEastPane() {
    eastPane = new JPanel();
    eastPane.setBackground(Color.WHITE);
    return eastPane;
  }
  
  private JPanel createSouthPane() {
    southPane = new JPanel();
    southPane.setBackground(Color.WHITE);
    southPane.add(getOkButton());
    return southPane;
  }
  
  private JButton getOkButton() {
    okButton = new JButton("Aceptar");
    okButton.setFont(FONT.deriveFont(20f));
    okButton.setBackground(Color.RED);
    okButton.setForeground(Color.WHITE);
    okButton.setBorderPainted(false);
    okButton.setFocusable(false);
    addOkListener();
    return okButton;
  }
  
  private JLabel getInfoLabel() {
    infoLabel = new JLabel("asdasd",JLabel.CENTER);
    infoLabel.setForeground(Color.RED);
    infoLabel.setFont(FONT.deriveFont(20f));
    return infoLabel;
  }
  
  private void addOkListener() {
    okButton.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        input = ACCEPTED;
        dispose();
      }
    });
  }
  
}
