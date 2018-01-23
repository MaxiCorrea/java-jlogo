package com.maxicorrea.jlogo.controllers.cmd;

import com.maxicorrea.jlogo.models.cmd.BackwardCommand;

public class BackwardCommandController extends ForwardCommandController {

  public BackwardCommandController() {
    command = new BackwardCommand();
  }

  @Override
  public boolean validParameters() {
   return super.validParameters();
  }
  
}