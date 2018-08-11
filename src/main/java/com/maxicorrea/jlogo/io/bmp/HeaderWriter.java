package com.maxicorrea.jlogo.io.bmp;

import java.io.IOException;
import java.io.OutputStream;
import com.maxicorrea.jlogo.models.Pixel;

class HeaderWriter extends Writer {

  private final static byte[] BM = new byte[] {66, 77};
  
  HeaderWriter(Pixel[][] pixels, OutputStream stream) {
    super(pixels , stream);
  }

  @Override
   void write() throws IOException {
    endian.writeBytes(BM);
    final int WIDTH = data[0].length;
    final int HEIGHT = data.length;
    endian.writeInt(WIDTH * HEIGHT * 3 + HEIGHT * (WIDTH % 4) + 54);
    endian.writeShort(0);
    endian.writeShort(0);
    endian.writeInt(54);
  }

}
