package com.maxicorrea.jlogo.controllers.cmd;

import com.maxicorrea.jlogo.controllers.utils.Parser;
import com.maxicorrea.jlogo.models.cmd.BrushUpCommand;

public class BrushUpCommandController extends CommandController<String> {

  public BrushUpCommandController() {
    super(new BrushUpCommand());
  }

  @Override
  public boolean validParameters() {
    String args = command.strArguments();
    Parser parser = new Parser(args);
    return parser.endOfLine().ok();
  }
  
}