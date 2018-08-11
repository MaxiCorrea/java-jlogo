package com.maxicorrea.jlogo.views.extras;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.maxicorrea.jlogo.views.utils.Icons;

public class NorthMotionLabel extends JLabel {
  
  private static final long serialVersionUID = 1L;

  private static final Font FONT = DeckerFont.INSTANCE.getFont();
  
  private JFrame owner;
  private JLabel mini;
  private JLabel close;
  private Point p1, p2;
  
  public NorthMotionLabel(JFrame owner) {
    super("JLogo", JLabel.CENTER);
    this.owner = owner;
    setForeground(Color.RED);
    setFont(FONT.deriveFont(Font.PLAIN, 27));
    setBackground(Color.WHITE);
    setLayout(new FlowLayout(FlowLayout.RIGHT));
    add(getLabelMini());
    add(getLabelClose());
    setPreferredSize(new Dimension(850, 40));
    addMouseListener();
    addMouseMotionListener();
  }

  private void addMouseListener() {
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        p1 = new Point(e.getX(), e.getY());
      }
    });
  }

  private void addMouseMotionListener() {
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        p2 = MouseInfo.getPointerInfo().getLocation();
        owner.setLocation(p2.x - p1.x, p2.y - p1.y);
      }
    });
  }

  private JLabel getLabelClose() {
    close = new JLabel();
    close.setIcon(Icons.load("/close.png"));
    close.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        owner.setVisible(false);
        owner.dispose();
        System.exit(0);
      }
    });
    return close;
  }

  private JLabel getLabelMini() {
    mini = new JLabel();
    mini.setIcon(Icons.load("/mini.png"));
    mini.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        owner.setState(JFrame.ICONIFIED);
      }
    });
    return mini;
  }
}