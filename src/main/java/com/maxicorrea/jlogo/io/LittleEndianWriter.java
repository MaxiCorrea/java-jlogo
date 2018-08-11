package com.maxicorrea.jlogo.io;

import java.io.IOException;
import java.io.OutputStream;

public class LittleEndianWriter {

  private OutputStream stream;

  public void stream(OutputStream stream) {
    this.stream = stream;
  }

  public void writeByte(byte x) throws IOException {
    stream.write(x);
  }

  public void writeBytes(byte[] b) throws IOException {
    stream.write(b);
  }

  public void writeShort(int x) throws IOException {
    byte[] bytes = new byte[2];
    bytes[0] = ((byte)(x & 0xFF));
    bytes[1] = ((byte)(x >> 8 & 0xFF));
    stream.write(bytes);
  }

  public void writeInt(int x) throws IOException {
    byte[] bytes = new byte[4];
    bytes[0] = ((byte) (x &  0xFF));
    bytes[1] = ((byte) (x >> 8 & 0xFF));
    bytes[2] = ((byte) (x >> 16 & 0xFF));
    bytes[3] = ((byte) (x >> 24 & 0xFF));
    stream.write(bytes);
  }

  public void flush() throws IOException {
    stream.flush();
  }

}
