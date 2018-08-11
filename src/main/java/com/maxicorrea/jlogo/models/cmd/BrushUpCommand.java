package com.maxicorrea.jlogo.models.cmd;

public class BrushUpCommand extends AbstractCommand<String>{

  public BrushUpCommand() {
    super("pincelarriba");
  }

  @Override
  public boolean execute() {
    model.brushUp();
    return true;
  }

}