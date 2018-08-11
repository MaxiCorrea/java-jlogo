package com.maxicorrea.jlogo.models;

import java.util.List;

public interface Logo {

  int imageWidth();

  int imageHeight();

  int getRGB(int x, int y);

  int turtleInX();

  int turtleInY();

  double turtleAngle();

  List<String> history();

  boolean isVisibleTurtle();

}
