package com.maxicorrea.jlogo.controllers.cmd;

import com.maxicorrea.jlogo.controllers.utils.Parser;
import com.maxicorrea.jlogo.models.Game;
import com.maxicorrea.jlogo.models.Point;
import com.maxicorrea.jlogo.models.cmd.LocateCommand;

public class LocateCommandController extends CommandController<Point> {

  public LocateCommandController() {
    super(new LocateCommand());
  }

  @Override
  public boolean validParameters() {
    String args = command.strArguments();
    Parser val = new Parser(args);
    if (val.anInteger().and(",").
              anInteger().endOfLine().ok()) {
      int x = val.nextInt();
      int y = val.nextInt();
      if(checkLocation(x, y)) {
        command.parameter(new Point(x, y));
        return true;
      }
    }
    return false;
  }

  private boolean checkLocation(int x , int y ) {
    Game model = Game.INSTANCE;
    return x >= 0 && x < model.imageWidth() &&
              y >= 0 && y < model.imageHeight();
  }
  
}