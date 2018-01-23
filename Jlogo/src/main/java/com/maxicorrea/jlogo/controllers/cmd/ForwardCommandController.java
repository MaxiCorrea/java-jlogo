package com.maxicorrea.jlogo.controllers.cmd;

import com.maxicorrea.jlogo.controllers.utils.Parser;
import com.maxicorrea.jlogo.models.cmd.ForwardCommand;

public class ForwardCommandController extends CommandController<Integer> {

  public ForwardCommandController() {
   super(new ForwardCommand());
  }

  @Override
  public boolean validParameters() {
    String args = command.strArguments();
    Parser val = new Parser(args);
    if (val.anInteger().endOfLine().ok()) {
      int steps = val.nextInt();
      command.parameter(steps);
      return true;
    }
    return false;
  }

}