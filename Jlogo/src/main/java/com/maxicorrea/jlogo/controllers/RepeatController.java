package com.maxicorrea.jlogo.controllers;

import com.maxicorrea.jlogo.controllers.utils.Parser;

public class RepeatController implements Controller {

  private GameController ctrl;
  private int repeates;
  private String data;
  
  public RepeatController(GameController ctrl) {
    this.ctrl = ctrl;
  }
  
  @Override
  public boolean isMyCommand(String cmd) {
    if(cmd.startsWith("repetir")) {
      cmd = cmd.replaceFirst("repetir","").trim();
      Parser val = new Parser(cmd);
      if(val.anInteger().ok()) {
        repeates = val.nextInt();
        data = cmd.replaceFirst(""+repeates,"");
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean execute() {
    ctrl.updateDisabled();
    for( int i = 0 ; i < repeates ; ++i) {
      for(String cmd : data.trim().split("[,]")) {
        if(!ctrl.processCommand(cmd.trim())) {
          ctrl.updateEnabled();
          return false;
        }
      }
    }
    ctrl.updateEnabled();
    return true;
  }

}
