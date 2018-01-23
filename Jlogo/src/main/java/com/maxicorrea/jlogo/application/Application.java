package com.maxicorrea.jlogo.application;

import javax.swing.SwingUtilities;
import com.maxicorrea.jlogo.controllers.GameController;
import com.maxicorrea.jlogo.views.GameView;

public class Application {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        GameView view = new GameView();
        GameController controller = new GameController(view);
        controller.startApp();
      }
    });
  }
}
