package com.maxicorrea.jlogo.io.bmp;
import java.io.IOException;
import java.io.OutputStream;
import com.maxicorrea.jlogo.models.Pixel;

class InfoWriter extends Writer {

  InfoWriter(Pixel[][] pixels, OutputStream stream) {
    super(pixels, stream);
  }

  @Override
  void write() throws IOException {
    endian.writeInt(40);
    final int WIDTH = data[0].length;
    final int HEIGHT = data.length;
    endian.writeInt(WIDTH);
    endian.writeInt(HEIGHT);
    endian.writeShort(1);
    endian.writeShort(24);
    endian.writeInt(0);
    endian.writeInt(WIDTH * HEIGHT * 3 + HEIGHT * (WIDTH % 4));
    endian.writeInt(0);
    endian.writeInt(0);
    endian.writeInt(0);
    endian.writeInt(0);
  }

}
