package com.maxicorrea.jlogo.io.bmp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import com.maxicorrea.jlogo.models.Pixel;

public final class BMPReader {

  public Pixel[][] read(File file) {
    try (FileInputStream stream = new FileInputStream(file);
        BufferedInputStream buffer = new BufferedInputStream(stream)) {
      HeaderReader head = new HeaderReader(buffer);
      if (!head.read()) {
        return null;
      }
      InfoReader info = new InfoReader(buffer);
      if(!info.read()) {
        return null;
      }
      PixelReader pixels = new PixelReader(buffer);
      pixels.height(info.height());
      pixels.width(info.width());
      if (pixels.read()) {
        return pixels.data();
      }
    } catch (IOException ex) {}
    return null;
  }

}
