package com.maxicorrea.jlogo.models;

public final class Image {

  private final static int HEIGHT = 512;
  private final static int WIDTH = 512;

  final static Image newWhite512x512() {
    return new Image();
  }

  private Pixel[][] background;
  private Pixel[][] drawing;
  private Turtle turtle;

  Image() {
    restart();
  }

  void restart() {
    drawing = new Pixel[HEIGHT][WIDTH];
    background = new Pixel[HEIGHT][WIDTH];
    for (int row = 0; row < HEIGHT; ++row) {
      for (int col = 0; col < WIDTH; ++col) {
        background[row][col] = Pixel.newWhite();
      }
    }
  }

  void turtle(Turtle turtle) {
    this.turtle = turtle;
  }

  int getRGB(int x, int y) {
    if (drawing[x][y] == null) {
      return background[x][y].rgb();
    } else {
      return drawing[x][y].rgb();
    }
  }

  int width() {
    return WIDTH;
  }

  int height() {
    return HEIGHT;
  }

  void plot(Point point) {
    int x = point.x();
    int y = point.y();
    Pixel color = turtle.brushColor();
    int radius = turtle.brushSize() / 2;
    for (int y2 = -radius; y2 <= radius; y2++) {
      for (int x2 = -radius; x2 <= radius; x2++) {
        if (turtle.isBrushDown()) {
          if (x2 * x2 + y2 * y2 <= radius * radius) {
            set(x + x2, y + y2, color);
          }
        }
      }
    }
  }

  void set(Point point, Pixel pixel) {
    set(point.x(), point.y(), pixel);
  }

  void set(int x, int y, Pixel pixel) {
    if (turtle.isBrushDown()) {
      drawing[x][y] = turtle.isErasing() ? null : new Pixel(pixel);
    }
  }

  Pixel get(Point point) {
    final Pixel draw = drawing[point.x()][point.y()];
    final Pixel back = background[point.x()][point.y()];
    return new Pixel((draw != null) ? draw : back);
  }

  Pixel[][] pixels() {
    Pixel[][] data = new Pixel[HEIGHT][WIDTH];
    for (int row = 0; row < HEIGHT; ++row) {
      for (int col = 0; col < WIDTH; ++col) {
        Pixel draw = drawing[row][col];
        Pixel back = background[row][col];
        data[row][col] = draw != null ? draw : back;
      }
    }
    return data;
  }

  void pixels(Pixel[][] pixels) {
    for (int row = 0; row < HEIGHT; ++row) {
      for (int col = 0; col < WIDTH; ++col) {
        if (row < pixels.length && col < pixels[0].length) {
          background[row][col] = pixels[row][col];
        } else {
          background[row][col] = Pixel.newWhite();
        }
      }
    }
  }
}
