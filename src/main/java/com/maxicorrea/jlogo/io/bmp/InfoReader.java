package com.maxicorrea.jlogo.io.bmp;

import java.io.IOException;
import java.io.InputStream;

class InfoReader extends Reader {

  private final static int HEAD_SIZE = 40;
  private final static int IMAGE_PLANS = 1;
  private final static int BITS_PER_PIXEL = 24;
  private final static int COMPRESSION = 0;
  private final static int IGNORED = 20;
  
  private int width;
  private int height;
  
  InfoReader(InputStream stream) {
    super(stream);
  }

  int width() {
    return width;
  }
  
  int height() {
    return height;
  }
  
  @Override
  boolean read() throws IOException {
    if (HEAD_SIZE != endian.readInt()) {
      return false;
    }
    width = endian.readInt();
    height = endian.readInt();
    if (IMAGE_PLANS != endian.readShort() ||
        BITS_PER_PIXEL != endian.readShort() || 
        COMPRESSION != endian.readInt()) {
      return false;
    }
    endian.skip(IGNORED);
    return true;
  }

}

