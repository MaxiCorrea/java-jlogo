package com.maxicorrea.jlogo.models;

public class Brush {

  private static final int DEFAULT_SIZE = 1;

  static Brush newBlackBrush() {
    return new Brush();
  }

  private Pixel color;
  private int size;
  private boolean down;

  Brush() {
    color = Pixel.newBlack();
    size = DEFAULT_SIZE;
    down = true;
  }

  void color(Pixel color) {
    this.color = new Pixel(color);
  }

  Pixel color() {
    return new Pixel(color);
  }

  void up() {
    down = false;
  }

  void down() {
    down = true;
  }

  boolean isDown() {
    return down;
  }

  int size() {
    return size;
  }

  void size(int size) {
    this.size = size;
  }

  void restart() {
    color = Pixel.newBlack();
    size = DEFAULT_SIZE;
    down = true;
  }

}

