package com.maxicorrea.jlogo.models.cmd;

public class BackwardCommand extends ForwardCommand {
  
  @Override
  public String name() {
    return "retroceder";
  }

  @Override
  public Integer parameter() {
    return  - super.parameter();
  }
  
  @Override
  public boolean execute() {
    return super.execute();
  }

  @Override
  public String toString() {
    return name() + " " + super.parameter();
  }
  
}
