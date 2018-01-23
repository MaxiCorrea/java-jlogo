package com.maxicorrea.jlogo.controllers.utils;

import java.util.ArrayList;
import java.util.List;

public final class Parser {

  private String source;
  private List<Integer> values;
  private boolean ok;

  public Parser() {
    values = new ArrayList<>();
    ok = true;
  }

  public Parser(String source) {
    this.source = source.trim();
    values = new ArrayList<>();
    ok = true;
  }

  public void source(String source) {
    this.source = source;
  }

  public Parser anInteger() {
    try {
      String strInt = possibleInt();
      values.add(Integer.parseInt(strInt));
      removeFromSrc(strInt);
    } catch (NumberFormatException e) {
      ok = false;
    }
    return this;
  }

  public Parser anInteger( int min , int max ) {
    try {
      String strInt = possibleInt();
      int value = Integer.parseInt(strInt);
      values.add(value);
      removeFromSrc(strInt);
      if (value < min || value > max) {
        ok = false;
      }
    } catch (NumberFormatException e) {
      ok = false;
    }
    return this;
  }
  
  public Parser and(String separator) {
    if (source.startsWith(separator)) {
      removeFromSrc(separator);
    } else {
      ok = false;
    }
    return this;
  }

 public Parser endOfLine() {
    if (!source.isEmpty()) {
      ok = false;
    }
    return this;
  }

 public boolean ok() {
    return ok;
  }

  public int nextInt() {
    return values.remove(0);
  }

  private void removeFromSrc(String s) {
    source = source.replaceFirst(s, "");
  }

  private String possibleInt() {
    StringBuilder digits = new StringBuilder();
    for (char c : source.toCharArray()) {
      if (Character.isDigit(c)) {
        digits.append(c);
      } else {
        return digits.toString();
      }
    }
    return digits.toString();
  }
  
}
