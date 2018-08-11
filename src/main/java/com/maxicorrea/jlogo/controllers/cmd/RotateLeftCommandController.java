package com.maxicorrea.jlogo.controllers.cmd;

import com.maxicorrea.jlogo.controllers.utils.Parser;
import com.maxicorrea.jlogo.models.cmd.RotateLeftCommand;

public class RotateLeftCommandController extends CommandController<Integer> {

  public RotateLeftCommandController() {
    super(new RotateLeftCommand());
  }

  @Override
  public boolean validParameters() {
    String args = command.strArguments();
    Parser val = new Parser(args);
    if (val.anInteger(0,360).endOfLine().ok()) {
      int angle = val.nextInt();
      command.parameter(angle);
      return true;
    }
    return false;
  }

}