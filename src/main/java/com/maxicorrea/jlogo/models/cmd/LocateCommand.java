package com.maxicorrea.jlogo.models.cmd;

import com.maxicorrea.jlogo.models.Point;

public class LocateCommand extends AbstractCommand<Point> {

  public LocateCommand() {
    super("ubicar");
  }

  @Override
  public boolean execute() {
    model.locateTurtleIn(parameter());
    return true;
  }

}
