package com.maxicorrea.jlogo.models.cmd;

import java.util.ArrayDeque;
import com.maxicorrea.jlogo.models.Pixel;
import com.maxicorrea.jlogo.models.Point;

public class PaintCommand extends AbstractCommand<String> {

  public PaintCommand() {
    super("pintar");
  }

  @Override
  public boolean execute() {
    int x = model.turtleInX();
    int y = model.turtleInY();
    Pixel oldColor = model.imageIn(new Point(y, x));
    Pixel newColor = model.brushColor();
    if (!oldColor.equals(newColor)) {
      if(model.isBrushDown()) {
        paint(new Point(y, x), newColor, oldColor);
      }
    }
    return true;
  }

  private final static int[] dx = {1, -1, 0, 0};
  private final static int[] dy = {0, 0, 1, -1};

  private void paint(Point point, Pixel newColor, Pixel oldColor) {
    ArrayDeque<Point> stack = new ArrayDeque<>();
    stack.push(point);
    while (!stack.isEmpty()) {
      Point currentPoint = stack.pop();
      model.imageIn(currentPoint, newColor);
      for (int index = 0; index < 4; ++index) {
        int nx = currentPoint.x() + dx[index];
        int ny = currentPoint.y() + dy[index];
        if (nx >= 0 && nx < 512 && ny >= 0 &&
            ny < 512 && model.imageIn(nx, ny).equals(oldColor)) {
          stack.push(new Point(nx, ny));
        }
      }
    }
  }
}

