package com.maxicorrea.jlogo.io.bmp;
import java.io.IOException;
import java.io.OutputStream;
import com.maxicorrea.jlogo.io.LittleEndianWriter;
import com.maxicorrea.jlogo.models.Pixel;

 abstract class Writer {

  protected Pixel[][] data;
  protected LittleEndianWriter endian;
  
  Writer(Pixel[][] data , OutputStream stream) {
    this.data = data;
    endian = new LittleEndianWriter();
    endian.stream(stream);
  }
  
  abstract void write() throws IOException;
  
}