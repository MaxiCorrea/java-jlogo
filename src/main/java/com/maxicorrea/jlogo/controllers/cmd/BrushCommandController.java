package com.maxicorrea.jlogo.controllers.cmd;

import com.maxicorrea.jlogo.controllers.utils.Parser;
import com.maxicorrea.jlogo.models.cmd.BrushCommand;

public class BrushCommandController extends CommandController<Integer>{

  public BrushCommandController() {
    super( new BrushCommand());
  }

  @Override
  public boolean validParameters() {
    Parser val = new Parser(command.strArguments());
    if(val.anInteger(1,10).endOfLine().ok()) {
      int size = val.nextInt();
      command.parameter(size);
      return true;
    }
    return false;
  }

}
