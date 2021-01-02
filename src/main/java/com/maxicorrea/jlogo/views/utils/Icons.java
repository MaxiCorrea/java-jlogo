package com.maxicorrea.jlogo.views.utils;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public final class Icons {

  public static final Icons INSTANCE = new Icons();

  private Icons() {
    super();
  }

  public Icon load(String path) {
    return new ImageIcon(this.getClass().getResource("/images" + path));
  }

}
