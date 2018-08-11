package com.maxicorrea.jlogo.controllers.cmd;

import com.maxicorrea.jlogo.models.cmd.RotateRightCommand;

public class RotateRightCommandController extends RotateLeftCommandController {

  public RotateRightCommandController() {
    command = new RotateRightCommand();
  }

  @Override
  public boolean validParameters() {
    return super.validParameters();
  }
  
}
