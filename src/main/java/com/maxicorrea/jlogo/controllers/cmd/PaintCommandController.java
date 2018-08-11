package com.maxicorrea.jlogo.controllers.cmd;

import com.maxicorrea.jlogo.controllers.utils.Parser;
import com.maxicorrea.jlogo.models.cmd.PaintCommand;

public class PaintCommandController extends CommandController<String> {

  public PaintCommandController() {
    super(new PaintCommand());
  }

  @Override
  public boolean validParameters() {
    String args = command.strArguments();
    Parser parser = new Parser(args);
    return parser.endOfLine().ok();
  }
}