package com.maxicorrea.jlogo.views.extras;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

public enum DeckerFont {

  INSTANCE;
  
  private Font font;
  
  private DeckerFont() {
    try {
      font = Font.createFont(Font.TRUETYPE_FONT, 
        getClass().getResource("/fonts/Decker.ttf").openStream());
      GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
      genv.registerFont(font);
      font = font.deriveFont(12f);
    } catch (FontFormatException | IOException e) {
      e.printStackTrace();;
     font = new Font(Font.MONOSPACED, Font.PLAIN, 17);
    }   
  }
  
  public Font getFont() {
    return font;
  }
  
}