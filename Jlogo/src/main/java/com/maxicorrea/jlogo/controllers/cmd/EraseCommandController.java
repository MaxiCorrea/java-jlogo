package com.maxicorrea.jlogo.controllers.cmd;

import com.maxicorrea.jlogo.models.cmd.EraseCommand;

public class EraseCommandController extends ForwardCommandController{

  public EraseCommandController() {
    command = new EraseCommand();
  }

  @Override
  public boolean validParameters() {
   return super.validParameters();
  }

}