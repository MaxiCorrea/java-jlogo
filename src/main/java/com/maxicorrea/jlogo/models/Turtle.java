package com.maxicorrea.jlogo.models;

public final class Turtle {

  final static Turtle newDefaultTurtle() {
    return new Turtle();
  }

  private Brush brush;
  private Point location;
  private double angle;
  private boolean visible;
  private boolean erasing;

  Turtle() {
    brush = Brush.newBlackBrush();
    location = Point.newDefaultPoint();
    angle = 0.0;
    visible = true;
    erasing = false;
  }

  void brushColor(Pixel color) {
    brush.color(color);
  }

  Pixel brushColor() {
    return brush.color();
  }

  boolean isBrushDown() {
    return brush.isDown();
  }
  
  void location(Point location) {
    this.location.x(location.x());
    this.location.y(location.y());
  }

  Point location() {
    return new Point(location);
  }

  void angle(double newAngle) {
    angle += newAngle;
    if (angle >= 360) {
      angle -= 360;
    }
    if (angle < 0) {
      angle += 360;
    }
  }

  double angle() {
    return angle;
  }

  int brushSize() {
    return brush.size();
  }

  void brushSize(int size) {
    brush.size(size);
  }

  void show() {
    visible = true;
  }

  void hide() {
    visible = false;
  }

  boolean isVisible() {
    return visible;
  }

  boolean isErasing() {
    return erasing;
  }

  void eraseDisabled() {
    erasing = false;
  }

  void eraseEnabled() {
    erasing = true;
  }

  void brushDown() {
    brush.down();
  }

  void brushUp() {
    brush.up();
  }

  void restart() {
    brush.restart();
    location.restart();
    angle = 0.0;
    visible = true;
    erasing = false;
  }

}