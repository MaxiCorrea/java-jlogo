package com.maxicorrea.jlogo.models.cmd;

public class EraseCommand extends ForwardCommand {

  @Override
  public String name() {
    return "borrar";
  }

  @Override
  public boolean execute() {
    model.eraseEnabled();
    boolean result = super.execute();
    model.eraseDisabled();
    return result;
  }

  @Override
  public String toString() {
    return name() + " "+parameter();
  }
  
}