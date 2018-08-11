package com.maxicorrea.jlogo.models.cmd;

import com.maxicorrea.jlogo.models.Pixel;

public class ColorCommand extends AbstractCommand<Pixel> {

  public ColorCommand() {
    super("color");
  }

  @Override
  public boolean execute() {
    model.brushColor(parameter());
    return true;
  }

}
