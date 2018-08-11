package com.maxicorrea.jlogo.models;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HistoryTest {

  private History history;
  
  @Before
  public void setUp() {
    history = new History();
  }
  
  @Test
  public void testNewEmptyHistory() {
    history = History.newEmptyHistory();
    assertTrue(history.commands().isEmpty());
  }

  @Test
  public void testHistory() {
    assertTrue(history.commands().isEmpty());
  }

  @Test
  public void testAdd() {
    history.add("avanzar 100");
    String expected = "avanzar 100";
    String actual = history.commands().get(0); 
    assertEquals(expected,actual);
  }

  @Test
  public void testRestart() {
    history.add("retroceder 100");
    String expected = "retroceder 100";
    String actual = history.commands().get(0); 
    assertEquals(expected,actual);
    history.restart();
    assertTrue(history.commands().isEmpty());
  }

  @Test
  public void testCommands() {
    history.add("retroceder 100");
    history.add("retroceder 10");
    history.add("retroceder 200");
    history.add("retroceder 5");
    assertEquals(4,history.commands().size());
    assertEquals("retroceder 100",history.commands().get(0));
    assertEquals("retroceder 10",history.commands().get(1));
    assertEquals("retroceder 200",history.commands().get(2));
    assertEquals("retroceder 5",history.commands().get(3));
  }

}
