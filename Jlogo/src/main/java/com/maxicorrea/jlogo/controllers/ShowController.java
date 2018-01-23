package com.maxicorrea.jlogo.controllers;

import com.maxicorrea.jlogo.models.Game;

public class ShowController implements Controller {

  public ShowController() {}

  @Override
  public boolean isMyCommand(String cmd) {
    return cmd.startsWith("mostrar");
  }

  @Override
  public boolean execute() {
    Game.INSTANCE.showTurtle();
    return true;
  }

}
