package com.maxicorrea.jlogo.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

public class PixelTest {

  private Pixel pixel;

  @Before
  public void setUp() {
    pixel = Pixel.newWhite();
  }

  @Test
  public void testNewBlack() {
    pixel = Pixel.newBlack();
    assertEquals(0, pixel.red());
    assertEquals(0, pixel.green());
    assertEquals(0, pixel.blue());
  }

  @Test
  public void testNewWhite() {
    pixel = Pixel.newWhite();
    assertEquals(255, pixel.red());
    assertEquals(255, pixel.green());
    assertEquals(255, pixel.blue());
  }

  @Test
  public void testPixelIntIntInt() {
    pixel = new Pixel(100, 34, 45);
    assertEquals(100, pixel.red());
    assertEquals(34, pixel.green());
    assertEquals(45, pixel.blue());
  }

  @Test
  public void testPixelPixel() {
    pixel = new Pixel(new Pixel(1, 1, 1));
    assertEquals(new Pixel(1, 1, 1), pixel);
    pixel = new Pixel(new Pixel(2, 2, 2));
    assertNotEquals(new Pixel(1, 1, 1), pixel);
  }

  @Test
  public void testRgb() {
    pixel = new Pixel(10, 10, 10);
    int expected =
        ((255 & 0xFF) << 24) | ((10 & 0xFF) << 16) | ((10 & 0xFF) << 8) | ((10 & 0xFF) << 0);
    int actual = pixel.rgb();
    assertEquals(expected, actual);
  }

  @Test
  public void testRed() {
    pixel = new Pixel(12, 13, 14);
    int expected = 12;
    int actual = pixel.red();
    assertEquals(expected, actual);
  }

  @Test
  public void testRedInt() {
    pixel = new Pixel(12, 13, 14);
    int expected = 12;
    int actual = pixel.red();
    assertEquals(expected, actual);
    expected = 100;
    pixel.red(100);
    actual = pixel.red();
    assertEquals(expected, actual);
  }

  @Test
  public void testGreen() {
    pixel = new Pixel(12, 13, 14);
    int expected = 13;
    int actual = pixel.green();
    assertEquals(expected, actual);
  }

  @Test
  public void testGreenInt() {
    pixel = new Pixel(12, 13, 14);
    int expected = 13;
    int actual = pixel.green();
    assertEquals(expected, actual);
    expected = 66;
    pixel.green(66);
    actual = pixel.green();
    assertEquals(expected, actual);
  }

  @Test
  public void testBlue() {
    pixel = new Pixel(12, 13, 14);
    int expected = 14;
    int actual = pixel.blue();
    assertEquals(expected, actual);
  }

  @Test
  public void testBlueInt() {
    pixel = new Pixel(12, 13, 14);
    int expected = 14;
    int actual = pixel.blue();
    assertEquals(expected, actual);
    expected = 45;
    pixel.blue(45);
    actual = pixel.blue();
    assertEquals(expected, actual);
  }

  @Test
  public void testEqualsObject() {
    Pixel expected = new Pixel(8, 9, 56);
    pixel = new Pixel(8, 9, 56);
    assertEquals(expected, pixel);
    pixel = new Pixel(56, 8, 7);
    assertNotEquals(expected, pixel);
  }

  @Test
  public void testToString() {
    String expected = "45,6,7";
    pixel = new Pixel(45, 6, 7);
    String actual = pixel.toString();
    assertEquals(expected, actual);
  }

}
