package com.maxicorrea.jlogo.controllers;

import com.maxicorrea.jlogo.models.Game;

public class HideController implements Controller {

  public HideController() {}

  @Override
  public boolean isMyCommand(String cmd) {
    return cmd.equals("ocultar");
  }

  @Override
  public boolean execute() {
    Game.INSTANCE.hideTurtle();
    return true;
  }

}
