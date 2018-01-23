package com.maxicorrea.jlogo.controllers;

import java.util.ArrayList;
import java.util.List;
import com.maxicorrea.jlogo.controllers.cmd.BackwardCommandController;
import com.maxicorrea.jlogo.controllers.cmd.BrushCommandController;
import com.maxicorrea.jlogo.controllers.cmd.BrushDownCommandController;
import com.maxicorrea.jlogo.controllers.cmd.BrushUpCommandController;
import com.maxicorrea.jlogo.controllers.cmd.CircleCommandController;
import com.maxicorrea.jlogo.controllers.cmd.ColorCommandController;
import com.maxicorrea.jlogo.controllers.cmd.EraseCommandController;
import com.maxicorrea.jlogo.controllers.cmd.ForwardCommandController;
import com.maxicorrea.jlogo.controllers.cmd.LocateCommandController;
import com.maxicorrea.jlogo.controllers.cmd.PaintCommandController;
import com.maxicorrea.jlogo.controllers.cmd.RotateLeftCommandController;
import com.maxicorrea.jlogo.controllers.cmd.RotateRightCommandController;
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
    controllers.add(new ShowController());
    controllers.add(new RotateLeftCommandController());
    controllers.add(new RotateRightCommandController());
    controllers.add(new HideController());
    controllers.add(new LocateCommandController());
    controllers.add(new NewController());
    controllers.add(new PaintCommandController());
    controllers.add(new ColorCommandController());
    controllers.add(new CircleCommandController());
    controllers.add(new ForwardCommandController());
    controllers.add(new DrawController(view));
    controllers.add(new BackgroundController(view));
    controllers.add(new SaveController(view));
    controllers.add(new OpenController(view, this));
    controllers.add(new RepeatController(this));
    controllers.add(new BrushCommandController());
    controllers.add(new BackwardCommandController());
    controllers.add(new InsertController(view, this));
    controllers.add(new EraseCommandController());
    controllers.add(new BrushDownCommandController());
    controllers.add(new BrushUpCommandController());
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