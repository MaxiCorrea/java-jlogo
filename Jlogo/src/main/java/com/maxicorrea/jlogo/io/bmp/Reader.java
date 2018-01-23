package com.maxicorrea.jlogo.io.bmp;

import java.io.IOException;
import java.io.InputStream;
import com.maxicorrea.jlogo.io.LittleEndianReader;

abstract class Reader {

  protected LittleEndianReader endian;
  
  Reader(InputStream stream) {
    endian = new LittleEndianReader();
    endian.stream(stream);
  }
  
  abstract boolean read() throws IOException;
  
}
