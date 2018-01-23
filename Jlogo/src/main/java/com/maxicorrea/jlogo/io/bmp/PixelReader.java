package com.maxicorrea.jlogo.io.bmp;


import java.io.IOException;
import java.io.InputStream;
import com.maxicorrea.jlogo.models.Pixel;

class PixelReader extends Reader {

  private Pixel[][] pixels;
  private int width;
  private int height;
  
  PixelReader(InputStream stream) {
    super(stream);
  }

  void width( int width) {
    this.width = width;
  }
  
  void height( int height) {
    this.height = height;
  }
  
  Pixel[][] data() {
    return pixels;
  }
  
  @Override
  boolean read() throws IOException {
    pixels = new Pixel[height][width];
    final int PADDING = width % 4;
    byte[] bytes = new byte[3];
    for (int row = 0; row < height; ++row) {
      for (int col = 0; col < width; ++col) {
        endian.read(bytes);
        int r = bytes[2] & 0xFF;
        int g = bytes[1] & 0xFF;
        int b = bytes[0] & 0xFF;
        pixels[row][col] = new Pixel(r, g, b);
      }
      for (int x = 0; x < PADDING; ++x) {
        endian.read();
      }
    }
    return true;
  }
  
}
