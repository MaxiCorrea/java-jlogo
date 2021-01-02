package com.maxicorrea.jlogo.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import com.maxicorrea.jlogo.models.Logo;
import com.maxicorrea.jlogo.views.extras.SelectTurtlePane;
import com.maxicorrea.jlogo.views.utils.Icons;

public class TurtleView extends JLabel implements ActionListener {
  
  private static final long serialVersionUID = 1L;
  private static final int WIDTH = 40;
  private static final int HEIGHT = 53;

  private SelectTurtlePane pane;
  private double angle = 0.0D;

  public TurtleView() {
    setIcon(Icons.INSTANCE.load("/turtle2.png"));
    setBounds(0, 0, WIDTH, HEIGHT);
    setPreferredSize( new Dimension(WIDTH, HEIGHT));
    pane = new SelectTurtlePane();
    pane.addButtonsListener(this);
    UIManager.put("ToolTip.background",new ColorUIResource(Color.WHITE)); 
    addMouseListener();
  }

  public SelectTurtlePane getSelectTurtlePane() {
    return pane;
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
      RenderingHints.VALUE_ANTIALIAS_ON);
    AffineTransform aT = g2.getTransform();
    Shape oldshape = g2.getClip();
    double x = getWidth() / 2.0D;
    double y = getHeight() / 2.0D;
    aT.rotate(Math.toRadians(90.0D - angle), x, y);
    g2.setTransform(aT);
    g2.setClip(oldshape);
    super.paintComponent(g);
  }

  public void update(Logo logo) {
    int x = logo.turtleInX();
    int y = logo.turtleInY();
    angle = logo.turtleAngle();
    setLocation(x - WIDTH / 2, logo.imageHeight() - y - HEIGHT / 2);
    setToolTipText("Posición (" + x + "," + y + ") Angulo " + angle + " grados");
    setVisible(logo.isVisibleTurtle());
    repaint();
    getParent().repaint();
  }

  private void addMouseListener() {
    addMouseListener( new MouseAdapter() {
      public void mouseExited(MouseEvent e) {
        repaint();
      }
    });
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JButton buttonSelected = (JButton) e.getSource();
    setIcon(buttonSelected.getIcon());
  }
  
}
