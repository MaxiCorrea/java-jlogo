package com.maxicorrea.jlogo.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class LittleEndianReader {

  private InputStream stream;

  public void stream(InputStream stream) {
    this.stream = stream;
  }
  
  public int read() throws IOException {
    return stream.read();
  }
  
  public int read(byte[] b) throws IOException {
    return stream.read(b);
  }
  
  public int readShort() throws IOException {
    byte[] bytes = new byte[2];
    stream.read(bytes);
    return (short)((short)(bytes[1] & 0xFF00)) |
                        ((short)(bytes[0] & 0xFF));
  }

  public int readInt() throws IOException {
    byte[] bytes = new byte[4];
    stream.read(bytes);
    return (bytes[3] & 0xFF) << 24 |
              (bytes[2] & 0xFF) << 16 |
              (bytes[1] & 0xFF) << 8 |
              (bytes[0] & 0xFF);
  }

  public void skip(int n) throws IOException {
    while (n > 0) {
      long temp = stream.skip(n);
      if (temp == 0) throw new EOFException();
      n -= temp;
    }
  }
  
}