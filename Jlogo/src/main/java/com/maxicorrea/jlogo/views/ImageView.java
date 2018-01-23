package com.maxicorrea.jlogo.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.maxicorrea.jlogo.models.Logo;

public class ImageView extends JPanel {

  private static final long serialVersionUID = 1L;
  private static final int WIDTH = 512;
  private static final int HEIGHT = 512;

  private JLabel drawLabel;

  public ImageView(TurtleView turtleView) {
    setBackground(Color.WHITE);
    setLayout(new FlowLayout(FlowLayout.CENTER,5,1));
    drawLabel = new JLabel();
    drawLabel.setLayout(null);
    drawLabel.setBorder(BorderFactory.createLineBorder(Color.red));
    drawLabel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    drawLabel.add(turtleView);
    add(drawLabel);
  }

  public void update(Logo logo) {
    drawLabel.setIcon(new ImageIcon(transform(logo)));
    getParent().repaint();
  }
  
  private BufferedImage transform(Logo logo) {
    final int WIDTH = logo.imageWidth();
    final int HEIGHT = logo.imageHeight();
    BufferedImage img = new BufferedImage(WIDTH, HEIGHT, 2);
    for (int row = 0; row < HEIGHT; row++) {
      for (int col = 0; col < WIDTH; col++) {
        img.setRGB(col, HEIGHT- row - 1, logo.getRGB(row,col));
      }
    }
    return img;
  }

}

