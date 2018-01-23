package com.maxicorrea.jlogo.models;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PointTest {

  private Point point;
  
  @Before
  public void setUp() {
    point = new Point(0,0);
  }
  
  @Test
  public void testPointIntInt() {
    point = new Point(30,34);
    assertEquals(30, point.x());
    assertEquals(34, point.y());
  }
  
  @Test
  public void testPointPoint() {
    point = new Point( new Point(45,67));
    Point expected = new Point(45,67);
    assertEquals(expected , point);
  }
  
  @Test
  public void testNewDefaultPoint() {
   point = Point.newDefaultPoint();
   Point expected = new Point(256,256);
   assertEquals(expected , point);
  }

  @Test
  public void testRestart() {
    point = new Point(5,15);
    assertEquals(5,point.x());
    assertEquals(15,point.y());
    point.x(100);
    point.y(200);
    assertEquals(100,point.x());
    assertEquals(200,point.y());
    point.restart();
    assertEquals(5,point.x());
    assertEquals(15,point.y());
  }

  @Test
  public void testToString() {
    String expected = "0,0";
    String actual = point.toString();
    assertEquals(expected,actual);
    expected = "34,-67";
    point = new Point(34,-67);
    actual = point.toString();
    assertEquals(expected,actual);
  }

}
