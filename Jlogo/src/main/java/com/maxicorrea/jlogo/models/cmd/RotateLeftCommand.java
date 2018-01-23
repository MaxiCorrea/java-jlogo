package com.maxicorrea.jlogo.models.cmd;

public class RotateLeftCommand extends AbstractCommand<Integer>{

  public RotateLeftCommand() {
    super("girarizq");
  }

  @Override
  public boolean execute() {
    model.turtleAngle(parameter());
    return true;
  }

}