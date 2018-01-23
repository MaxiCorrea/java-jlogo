package com.maxicorrea.jlogo.models.cmd;

import com.maxicorrea.jlogo.models.Point;

public class ForwardCommand extends AbstractCommand<Integer> {

  public ForwardCommand() {
    super("avanzar");
  }

  @Override
  public boolean execute() {
    int x = model.turtleInX();
    int y = model.turtleInY();
    Point target = calculateTarget(x, y, parameter());
    if(target != null) {
      forward(x, y, target.x(), target.y());
      model.locateTurtleIn(target);
      return true;
    }
    return false;
  }

  protected final Point calculateTarget(int x, int y, int steps) {
    double angle = model.turtleAngle();
    int s = model.brushSize() / 2;
    int x2 = (int) (x + steps * Math.cos(Math.toRadians(angle)));
    int y2 = (int) (y + steps * Math.sin(Math.toRadians(angle)));
    if(x2 < 0 + s || x2 >= model.imageWidth() - s ||
        y2 < 0 + s || y2 >= model.imageHeight() - s) {
      return null;
    }
    return new Point(x2, y2);
  }

  private void forward(int x0, int y0, int x1, int y1) {
    int deltaX = x1 - x0;
    int deltaY = y1 - y0;
    int steps = Math.max(Math.abs(deltaX), Math.abs(deltaY));
    double c = 1.0 / Math.max(1, steps);
    for (int i = 0; i <= steps; ++i) {
      int x = (int) (x0 + (i * deltaX * c) + 0.5);
      int y = (int) (y0 + (i * deltaY * c) + 0.5);
      model.plot(y, x);
    }
  }

}
