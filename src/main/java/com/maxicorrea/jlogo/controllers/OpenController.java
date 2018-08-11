package com.maxicorrea.jlogo.controllers;

import java.io.File;
import java.util.List;
import com.maxicorrea.jlogo.io.xml.XMLReader;
import com.maxicorrea.jlogo.views.GameView;

public class OpenController implements Controller {

  protected GameView view;
  protected GameController ctrl;

  OpenController(GameView view, GameController ctrl) {
    this.view = view;
    this.ctrl = ctrl;
  }

  @Override
  public boolean isMyCommand(String cmd) {
    return cmd.equals("abrir");
  }

  @Override
  public boolean execute() {
    XMLReader reader = new XMLReader();
    File file = view.getOpenPathLogo();
    ctrl.updateDisabled();
    if(file != null) {
      List<String> history = reader.read(file);
      if (history != null) {
        for (String cmd : history) {
          ctrl.processCommand(cmd);
        }
      }
    }
    ctrl.updateEnabled();
    return true;
  }

}
