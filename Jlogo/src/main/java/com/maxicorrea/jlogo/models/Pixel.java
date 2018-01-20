package com.maxicorrea.jlogo.models;

public final class Pixel {

  public final static int MAX_VALUE = 255;
  public final static int MIN_VALUE = 0;

  static Pixel newBlack() {
    int r = MIN_VALUE;
    int g = MIN_VALUE;
    int b = MIN_VALUE;
    return new Pixel(r, g, b);
  }

  static Pixel newWhite() {
    int r = MAX_VALUE;
    int g = MAX_VALUE;
    int b = MAX_VALUE;
    return new Pixel(r, g, b);
  }

  private int red;
  private int green;
  private int blue;

  public Pixel(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  Pixel(Pixel other) {
    this.red = other.red;
    this.green = other.green;
    this.blue = other.blue;
  }

  int rgb() {
    int alpha = MAX_VALUE;
    return ((alpha & 0xFF) << 24) | ((red & 0xFF) << 16) | ((green & 0xFF) << 8)
        | ((blue & 0xFF) << 0);
  }

  public int red() {
    return red;
  }

  public void red(int red) {
    this.red = red;
  }

  public int green() {
    return green;
  }

  public void green(int green) {
    this.green = green;
  }

  public int blue() {
    return blue;
  }

  public void blue(int blue) {
    this.blue = blue;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + blue;
    result = prime * result + green;
    result = prime * result + red;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pixel other = (Pixel) obj;
    if (blue != other.blue)
      return false;
    if (green != other.green)
      return false;
    if (red != other.red)
      return false;
    return true;
  }

  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();
    return out.append(red).append(',').append(green).append(',').append(blue).toString();
  }

}
