package com.maxicorrea.jlogo.models;

public final class Point {

  private final int INITIAL_X;
  private final int INITIAL_Y;

  static Point newDefaultPoint() {
    return new Point(256, 256);
  }

  private int x;
  private int y;

  public Point(int x, int y) {
    INITIAL_X = this.x = x;
    INITIAL_Y = this.y = y;
  }

  public Point(Point other) {
    INITIAL_X = this.x = other.x;
    INITIAL_Y = this.y = other.y;
  }

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  public void x(int x) {
    this.x = x;
  }

  public void y(int y) {
    this.y = y;
  }

  public void restart() {
    this.x = INITIAL_X;
    this.y = INITIAL_Y;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + INITIAL_X;
    result = prime * result + INITIAL_Y;
    result = prime * result + x;
    result = prime * result + y;
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
    Point other = (Point) obj;
    if (INITIAL_X != other.INITIAL_X)
      return false;
    if (INITIAL_Y != other.INITIAL_Y)
      return false;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    return true;
  }

  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();
    return out.append(x).append(',').append(y).toString();
  }

}
