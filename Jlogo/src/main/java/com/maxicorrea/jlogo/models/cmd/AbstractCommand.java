package com.maxicorrea.jlogo.models.cmd;

import com.maxicorrea.jlogo.models.Command;
import com.maxicorrea.jlogo.models.Game;

public abstract class AbstractCommand<P> extends Command<P> {

  protected Game model = Game.INSTANCE;
  private String strArguments;

  AbstractCommand(String name) {
    super(name);
  }

  public final boolean amIThisCommand(String cmd) {
    boolean result;
    if (result = cmd.startsWith(name())) {
      strArguments = cmd.replaceFirst(name(), "");
      strArguments = strArguments.trim();
    }
    return result;
  }

  public final void addToHistory() {
    model.addToHistory(this.toString());
  }
  
  public final String strArguments() {
    return strArguments;
  }
  
  public abstract boolean execute();

}

