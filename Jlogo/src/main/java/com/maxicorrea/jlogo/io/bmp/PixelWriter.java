package com.maxicorrea.jlogo.io.bmp;

import java.io.IOException;
import java.io.OutputStream;
import com.maxicorrea.jlogo.models.Pixel;

class PixelWriter extends Writer {

  PixelWriter(Pixel[][] pixels, OutputStream stream) {
    super(pixels, stream);
  }

  @Override
  void write() throws IOException {
    final int WIDTH = data[0].length;
    final int HEIGHT = data.length;
    final int PADDING = WIDTH % 4;
    for (int row = 0; row < HEIGHT; ++row) {
      for (int col = 0; col < WIDTH; ++col) {
        byte r = (byte) data[row][col].red();
        byte g = (byte) data[row][col].green();
        byte b = (byte) data[row][col].blue();
        endian.writeBytes(new byte[] {b, g, r});
      }
      for (int x = 0; x < PADDING; ++x) {
        endian.writeInt(Pixel.MAX_VALUE);
      }
    }
  }

}