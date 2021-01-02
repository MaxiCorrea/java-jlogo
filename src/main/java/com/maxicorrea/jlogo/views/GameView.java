package com.maxicorrea.jlogo.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.maxicorrea.jlogo.controllers.GameController;
import com.maxicorrea.jlogo.models.Logo;
import com.maxicorrea.jlogo.views.extras.EastMenuLabel;
import com.maxicorrea.jlogo.views.extras.NorthMotionLabel;
import com.maxicorrea.jlogo.views.extras.SelectTurtlePane;
import com.maxicorrea.jlogo.views.extras.WestMenuLabel;

public class GameView {

  private final static int WIDTH = 850;
  private final static int HEIGHT = 650;

  private JFrame mainFrame;
  private JPanel contentPane;
  private JPanel westPane;
  private JPanel centerPane;
  private JPanel northPane;
  private JPanel eastPane;
  private JPanel southPane;

  private ImageView imageView;
  private TurtleView turtleView;
  private HistoryView historyView;
  private CommandView commandView;
  
  public GameView() {
    UIManager.put("ScrollBar.thumbShadow", Color.WHITE);
    UIManager.put("ScrollBar.background", Color.WHITE);
    UIManager.put("ScrollBar.foreground", Color.WHITE);
    UIManager.put("ScrollBar.width", Integer.valueOf(15));
    createMainFrame();
  }
  
  private void createMainFrame() {
    mainFrame = new JFrame("JLogo");
    mainFrame.setUndecorated(true);
    mainFrame
        .setIconImage(Toolkit.getDefaultToolkit().getImage(
          getClass().getResource("/images/logo.png")));
    mainFrame.setSize(WIDTH, HEIGHT);
    mainFrame.setDefaultCloseOperation(3);
    mainFrame.setContentPane(getContentPane());
    mainFrame.setLocationRelativeTo(null);
    mainFrame.setResizable(false);
    mainFrame.pack();
  }

  private JPanel getContentPane() {
    contentPane = new JPanel(new BorderLayout(0, 0));
    contentPane.setBackground(Color.LIGHT_GRAY);
    contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
    contentPane.add(getCenterPane(), "Center");
    contentPane.add(getNorthPane(), "North");
    contentPane.add(getWestPane(), "West");
    contentPane.add(getSouthPane(), "South");
    contentPane.add(getEastPane(), "East");
    return contentPane;
  }

  private JPanel getCenterPane() {
    centerPane = new JPanel(new BorderLayout());
    centerPane.setBackground(Color.WHITE);
    turtleView = new TurtleView();
    imageView = new ImageView(turtleView);
    centerPane.add(imageView);
    return centerPane;
  }

  private JPanel getNorthPane() {
    northPane = new JPanel();
    northPane.setBackground(Color.WHITE);
    NorthMotionLabel label = new NorthMotionLabel(mainFrame);
    northPane.add(label);
    return northPane;
  }

  private JPanel getWestPane() {
    westPane = new JPanel(null);
    westPane.setPreferredSize(new Dimension(150, 512));
    westPane.setBackground(Color.WHITE);
    westPane.add( new WestMenuLabel(mainFrame));
    historyView = new HistoryView();
    westPane.add(historyView.getJScrollPaneAnimation());
    return westPane;
  }

  private JPanel getEastPane() {
    eastPane = new JPanel(null);
    eastPane.setPreferredSize(new Dimension(150, 512));
    eastPane.setBackground(Color.WHITE);
    eastPane.add( new EastMenuLabel(mainFrame));
    SelectTurtlePane selectTurtles = turtleView.getSelectTurtlePane();
    eastPane.add(selectTurtles.getJScrollPaneAnimation());
    return eastPane;
  }

  private JPanel getSouthPane() {
    southPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    southPane.setBackground(Color.WHITE);
    commandView = new CommandView(mainFrame);
    southPane.add(commandView);
    return southPane;
  }

  public void setController(GameController controller) {
    commandView.setController(controller);
  }
  
  public void show() {
    mainFrame.setVisible(true);
  }

  public void update(Logo logo) {
    turtleView.update(logo);
    imageView.update(logo);
    historyView.update(logo);
  }

  public File getSavePathImage() {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileFilter(new FileNameExtensionFilter("imagen BMP", "bmp"));
    if(chooser.showSaveDialog(mainFrame) == 0) {
      return chooser.getSelectedFile();
    }
    return null;
  }

  public File getOpenPathLogo() {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileFilter(new FileNameExtensionFilter("Archivo Logo", "logo"));
    if(chooser.showOpenDialog(mainFrame) == 0) {
      return chooser.getSelectedFile();
    }
    return null;
  }
  
  public File getSavePathLogo() {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileFilter(new FileNameExtensionFilter("Archivo Logo", "logo"));
    if(chooser.showSaveDialog(mainFrame) == 0) {
      return chooser.getSelectedFile();
    }
    return null;
  }
  
  public File getOpenPathImage() {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileFilter(new FileNameExtensionFilter("imagen BMP", "bmp"));
    if(chooser.showOpenDialog(mainFrame) == 0) {
      return chooser.getSelectedFile();
    }
    return null;
  }

}
