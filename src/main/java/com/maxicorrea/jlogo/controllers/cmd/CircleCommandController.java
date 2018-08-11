package com.maxicorrea.jlogo.controllers.cmd;

import com.maxicorrea.jlogo.controllers.utils.Parser;
import com.maxicorrea.jlogo.models.Game;
import com.maxicorrea.jlogo.models.cmd.CircleCommand;

public class CircleCommandController extends CommandController<Integer> {

  public CircleCommandController() {
    super(new CircleCommand());
  }

  @Override
  public boolean validParameters() {
    String args = command.strArguments();
    Parser val = new Parser(args);
    if (val.anInteger(1 , 512).endOfLine().ok()) {
      int radius = val.nextInt();
      if(validBounds(radius)) {
        command.parameter(radius);
        return true;
      }
    }
    return false;
  }

  private boolean validBounds( int radius) {
    Game model = Game.INSTANCE;
    int x = model.turtleInX();
    int y = model.turtleInY();
    int s = model.brushSize()/2;
    return x + radius < model.imageWidth() + s &&
              y + radius < model.imageHeight() + s &&
              x - radius >= s && y - radius >= s;
  }
  
}
