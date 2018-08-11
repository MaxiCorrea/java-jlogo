package com.maxicorrea.jlogo.models.cmd;

public class BrushDownCommand extends AbstractCommand<String>{

  public BrushDownCommand() {
    super("pincelabajo");
  }

  @Override
  public boolean execute() {
    model.brushDown();
    return true;
  }

}