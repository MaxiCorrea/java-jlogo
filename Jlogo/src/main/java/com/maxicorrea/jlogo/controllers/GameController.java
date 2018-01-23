package com.maxicorrea.jlogo.controllers;

import java.util.ArrayList;
import java.util.List;
import com.maxicorrea.jlogo.models.Game;
import com.maxicorrea.jlogo.views.GameView;

public class GameController {

  private GameView view;
  private List<Controller> controllers;
  private boolean autoUpdate;

  public GameController(GameView view) {
    this.view = view;
    this.view.setController(this);
    controllers = new ArrayList<>();
    installControllers();
    autoUpdate = true;
  }

  private void installControllers() {

  }

  public boolean processCommand(String cmd) {
    cmd = cmd.toLowerCase().trim();
    for (Controller ctrl : controllers) {
      if (ctrl.isMyCommand(cmd)) {
        if (ctrl.execute()) {
          if (autoUpdate) {
            updateView();
          }
          return true;
        }
      }
    }
    return false;
  }

  public String getErrorMessage() {
    return "<html>   Error de comando observa la sintaxis de los comandos en <br/>"
        + " el menu derecho de JLogo. Y tenga en cuenta que todo<br/>"
        + " comando que  intente superar los limites de la imagen sera<br/>"
        + " indicado como un error.</html>";
  }

  public void updateDisabled() {
    autoUpdate = false;
  }

  public void updateEnabled() {
    autoUpdate = true;
  }

  public void startApp() {
    updateView();
    view.show();
  }

  private void updateView() {
    view.update(Game.INSTANCE);
  }

}