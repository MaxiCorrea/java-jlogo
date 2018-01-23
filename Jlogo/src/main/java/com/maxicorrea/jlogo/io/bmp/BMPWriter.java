package com.maxicorrea.jlogo.io.bmp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.maxicorrea.jlogo.models.Pixel;

public final class BMPWriter {

  private Pixel[][] pixels;

  public BMPWriter(Pixel[][] pixels) {
    this.pixels = pixels;
  }

  public boolean write(File file) {
    try (FileOutputStream stream = new FileOutputStream(addExtension(file));
        BufferedOutputStream buffer = new BufferedOutputStream(stream)) {
      new HeaderWriter(pixels, buffer).write();
      new InfoWriter(pixels, buffer).write();
      new PixelWriter(pixels, buffer).write();
      return true;
    } catch (IOException ex) {
      ex.printStackTrace();
      return false;
    }
  }

  private File addExtension(File file) {
    if (!file.getAbsolutePath().endsWith(".bmp")) {
      return new File(file.getAbsolutePath().concat(".bmp"));
    }
    return file;
  }

}