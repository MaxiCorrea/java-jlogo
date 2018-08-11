package com.maxicorrea.jlogo.models;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BrushTest {

  private Brush brush;

  @Before
  public void setUp() {
    brush = new Brush();
  }

  @Test
  public void testNewBlackBrush() {
    brush = Brush.newBlackBrush();
    assertEquals(0,brush.color().red());
    assertEquals(0,brush.color().green());
    assertEquals(0,brush.color().blue());
  }
  
  @Test
  public void testColorPixel() {
    brush.color(Pixel.newWhite());
    assertEquals(255,brush.color().red());
    assertEquals(255,brush.color().green());
    assertEquals(255,brush.color().blue());
    brush.color( new Pixel(5,6,7));
    assertEquals(5,brush.color().red());
    assertEquals(6,brush.color().green());
    assertEquals(7,brush.color().blue());
  }

  @Test
  public void testUp() {
    assertTrue(brush.isDown());
    brush.up();
    assertFalse(brush.isDown());
    brush.down();
    assertTrue(brush.isDown());
    brush.up();
    assertFalse(brush.isDown());
  }

  @Test
  public void testSizeInt() {
    assertEquals(1,brush.size());
    brush.size(10);
    assertEquals(10,brush.size());
    brush.size(20);
    assertEquals(20,brush.size());
  }

  @Test
  public void testRestart() {
    brush = new Brush();
    brush.size(34);
    brush.color(Pixel.newWhite());
    brush.up();
    assertEquals(34,brush.size());
    assertEquals(new Pixel(255,255,255), brush.color());
    assertFalse(brush.isDown());
    brush.restart();
    assertEquals(1,brush.size());
    assertEquals(new Pixel(0,0,0), brush.color());
    assertTrue(brush.isDown());
  }

}
