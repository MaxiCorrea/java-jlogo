package com.maxicorrea.jlogo.models.cmd;

public class BrushCommand extends AbstractCommand<Integer> {

  public BrushCommand() {
    super("pincel");
  }

  @Override
  public boolean execute() {
    model.brushSize(parameter());
    return true;
  }

}
