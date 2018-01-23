package com.maxicorrea.jlogo.models.cmd;

public class RotateRightCommand extends RotateLeftCommand {

  @Override
  public String name() {
    return "girarder";
  }
  
  @Override
  public Integer parameter() {
    return - super.parameter();
  }
  
  @Override
  public String toString() {
    return name() + " " + super.parameter();
  }
  
}