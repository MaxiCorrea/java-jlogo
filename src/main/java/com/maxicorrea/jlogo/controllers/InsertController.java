package com.maxicorrea.jlogo.controllers;

import com.maxicorrea.jlogo.views.GameView;

public class InsertController extends OpenController {

  InsertController(GameView view, GameController ctrl) {
    super(view, ctrl);
  }

  @Override
  public boolean isMyCommand(String cmd) {
    if(cmd.startsWith("insertar")) {
      cmd = cmd.replaceFirst("insertar","");
      return ctrl.processCommand("ubicar "+cmd);
    }
    return false;
  }
    
}
