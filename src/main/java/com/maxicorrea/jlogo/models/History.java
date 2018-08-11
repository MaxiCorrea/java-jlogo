package com.maxicorrea.jlogo.models;

import java.util.ArrayList;
import java.util.List;

public final class History {

  final static History newEmptyHistory() {
    return new History();
  }

  private List<String> commands;

  History() {
    commands = new ArrayList<>();
  }

  void add(String command) {
    commands.add(command);
  }

  void restart() {
    commands.clear();
  }

  public List<String> commands() {
    return commands;
  }
  
}