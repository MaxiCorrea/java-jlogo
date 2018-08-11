package com.maxicorrea.jlogo.models;

public class Command<P> {

  private String name;
  private P param;

  public Command(String name) {
    this.name = name;
  }

  public String name() {
    return name;
  }

  public void parameter(P param) {
    this.param = param;
  }

  public P parameter() {
    return param;
  }

  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();
    out.append(name);
    if (param != null) {
      out.append(' ');
      out.append(param);
    }
    return out.toString();
  }

}
