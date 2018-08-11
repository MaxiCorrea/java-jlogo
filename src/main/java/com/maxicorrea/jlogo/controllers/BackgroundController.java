package com.maxicorrea.jlogo.controllers;

import java.io.File;
import com.maxicorrea.jlogo.io.bmp.BMPReader;
import com.maxicorrea.jlogo.models.Game;
import com.maxicorrea.jlogo.models.Pixel;
import com.maxicorrea.jlogo.views.GameView;

public class BackgroundController implements Controller {

  private GameView view;
  
  public BackgroundController( GameView view) {
    this.view = view;
  }

  @Override
  public boolean isMyCommand(String cmd) {
    return cmd.equals("fondo");
  }

  @Override
  public boolean execute() {
    File file = view.getOpenPathImage();
    if(file != null ) {
      if(file.exists()) {
        BMPReader reader = new BMPReader();
        Pixel[][] img = reader.read(file);
        if(img != null) {
          Game.INSTANCE.loadImage(img);
        }
      }
    }
    return true;
  }

}
