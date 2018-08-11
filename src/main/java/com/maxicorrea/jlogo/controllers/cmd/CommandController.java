package com.maxicorrea.jlogo.controllers.cmd;

import com.maxicorrea.jlogo.controllers.Controller;
import com.maxicorrea.jlogo.models.cmd.AbstractCommand;

public abstract class CommandController<P> implements Controller {

  protected AbstractCommand<P> command;

  public CommandController(AbstractCommand<P> command) {
    this.command = command;
  }

  @Override
  public boolean isMyCommand(String cmd) {
    return command.amIThisCommand(cmd);
  }

  @Override
  public boolean execute() {
    if (validParameters() && command.execute()) {
        command.addToHistory();
      return true;
    }
    return false;
  }

  public abstract boolean validParameters();
  
}