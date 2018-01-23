package com.maxicorrea.jlogo.io.bmp;

import java.io.IOException;
import java.io.InputStream;

class HeaderReader extends Reader {

  private final static byte B = 66;
  private final static byte M = 77; 
  
  HeaderReader(InputStream stream) {
    super(stream);
  }

  @Override
  boolean read() throws IOException {
    if (B == endian.read() && M == endian.read()) {
      endian.skip(8);
       return 54 == endian.readInt();
    }
    return false;
  }

}
