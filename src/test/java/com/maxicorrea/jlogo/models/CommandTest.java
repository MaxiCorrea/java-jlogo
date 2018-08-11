package com.maxicorrea.jlogo.models;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CommandTest {

  private Command<String> command;
  
  @Before
  public void setUp() {
    command = new Command<>("");
  }
  
  @Test
  public void testName() {
    String expected = "";
    String actual = command.name();
    assertEquals(expected , actual);
    expected = "avanzar";
    command = new Command<>("avanzar");
    actual = command.name();
    assertEquals(expected , actual);
  }

  @Test
  public void testParameterP() {
    String expected = "12";
    command.parameter("12");
    assertEquals(expected,command.parameter());
  }
  
  @Test
  public void testToString() {
    assertEquals("",command.toString());
    command = new Command<>("avanzar");
    assertEquals("avanzar",command.toString());
    command.parameter("123");
    assertEquals("avanzar 123",command.toString());
  }

}
