package com.maxicorrea.jlogo.controllers;

import java.io.File;
import java.util.List;
import com.maxicorrea.jlogo.io.xml.XMLWriter;
import com.maxicorrea.jlogo.models.Game;
import com.maxicorrea.jlogo.views.GameView;

public class SaveController implements Controller {

  private GameView view;

  public SaveController(GameView view) {
    this.view = view;
  }

  @Override
  public boolean isMyCommand(String cmd) {
    return cmd.equals("guardar");
  }
  
  @Override
  public boolean execute() {
    File file = view.getSavePathLogo();
    if(file != null) {
      List<String> history = Game.INSTANCE.history();
      return new XMLWriter().write(history,file );
    }
   return true;
  }

}
