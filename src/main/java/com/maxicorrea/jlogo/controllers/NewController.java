package com.maxicorrea.jlogo.controllers;

import com.maxicorrea.jlogo.models.Game;

public class NewController implements Controller {

  @Override
  public boolean isMyCommand(String cmd) {
    return cmd.equals("nuevo");
  }

  @Override
  public boolean execute() {
    Game.INSTANCE.restart();
    return true;
  }

}
