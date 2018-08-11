package com.maxicorrea.jlogo.models.cmd;

public class CircleCommand extends AbstractCommand<Integer> {

  public CircleCommand() {
    super("circulo");
  }

  @Override
  public boolean execute() {
    int x = model.turtleInX();
    int y = model.turtleInY();
    circle(y, x, parameter());
    return true;
  }

  private void circle(int xm, int ym, int radius) {
    int x = -radius, y = 0, err = 2 - 2 * radius;
    do {
      model.plot(xm - x, ym + y);
      model.plot(xm - y, ym - x);
      model.plot(xm + x, ym - y);
      model.plot(xm + y, ym + x);
      radius = err;
      if (radius > x) err += ++x * 2 + 1;
      if (radius <= y) err += ++y * 2 + 1;
    } while (x < 0);
  }

}