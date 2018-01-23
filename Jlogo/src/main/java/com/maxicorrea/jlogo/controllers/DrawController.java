package com.maxicorrea.jlogo.controllers;

import java.io.File;
import com.maxicorrea.jlogo.io.bmp.BMPWriter;
import com.maxicorrea.jlogo.models.Game;
import com.maxicorrea.jlogo.models.Pixel;
import com.maxicorrea.jlogo.views.GameView;

public class DrawController implements Controller {

  private GameView view;

  DrawController(GameView view) {
    this.view = view;
  }

  @Override
  public boolean isMyCommand(String cmd) {
    return cmd.equals("dibujar");
  }

  @Override
  public boolean execute() {
    File file = view.getSavePathImage();
    if(file != null) {
      Pixel[][] img = Game.INSTANCE.imagePixels();
      BMPWriter writer = new BMPWriter(img);
      writer.write(file);
    }
    return true;
  }

}
