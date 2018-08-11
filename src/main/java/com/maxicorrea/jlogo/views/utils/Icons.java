package com.maxicorrea.jlogo.views.utils;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public final class Icons {

  private Icons() {
    throw new AssertionError();
  }
  
  public static Icon load(String path) {
    return new ImageIcon(Icons.class.getClass().getResource("/images"+path));
  }
  
}
