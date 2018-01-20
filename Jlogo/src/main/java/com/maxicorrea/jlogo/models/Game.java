package com.maxicorrea.jlogo.models;

import java.util.List;

public enum Game implements Logo {

  INSTANCE;

  private History history;
  private Image image;
  private Turtle turtle;

  private Game() {
    history = History.newEmptyHistory();
    turtle = Turtle.newDefaultTurtle();
    image = Image.newWhite512x512();
    image.turtle(turtle);
  }

  @Override
  public int imageWidth() {
    return image.width();
  }

  @Override
  public int imageHeight() {
    return image.height();
  }

  @Override
  public int getRGB(int x, int y) {
    return image.getRGB(x, y);
  }

  @Override
  public boolean isVisibleTurtle() {
    return turtle.isVisible();
  }

  @Override
  public double turtleAngle() {
    return turtle.angle();
  }

  @Override
  public List<String> history() {
    return history.commands();
  }

  @Override
  public int turtleInX() {
    return turtle.location().x();
  }

  @Override
  public int turtleInY() {
    return turtle.location().y();
  }

  public void turtleAngle(double angle) {
    turtle.angle(angle);
  }

  public void hideTurtle() {
    turtle.hide();
  }

  public void showTurtle() {
    turtle.show();
  }

  public void brushColor(Pixel color) {
    turtle.brushColor(color);
  }

  public Pixel brushColor() {
    return turtle.brushColor();
  }

  public void imageIn(Point point, Pixel color) {
    image.set(point, color);
  }

  public Pixel imageIn(int x, int y) {
    return image.get(new Point(x, y));
  }

  public Pixel imageIn(Point point) {
    return image.get(point);
  }

  public void brushSize(int size) {
    turtle.brushSize(size);
  }

  public void locateTurtleIn(Point point) {
    turtle.location(point);
  }

  public void addToHistory(String command) {
    history.add(command);
  }

  public void restart() {
    history.restart();
    turtle.restart();
    image.restart();
  }

  public void plot(int x, int y) {
    image.plot(new Point(x, y));
  }

  public Pixel[][] imagePixels() {
    return image.pixels();
  }

  public void loadImage(Pixel[][] pixels) {
    image.pixels(pixels);
  }

  public void eraseEnabled() {
    turtle.eraseEnabled();
  }

  public void eraseDisabled() {
    turtle.eraseDisabled();
  }

  public int brushSize() {
    return turtle.brushSize();
  }

  public void brushDown() {
    turtle.brushDown();
  }
  
  public boolean isBrushDown() {
    return turtle.isBrushDown();
  }
  
  public void brushUp() {
    turtle.brushUp();
  }

}