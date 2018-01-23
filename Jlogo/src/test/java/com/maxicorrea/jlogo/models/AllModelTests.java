package com.maxicorrea.jlogo.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
                          BrushTest.class, 
                          CommandTest.class,
                          HistoryTest.class,
                          //ImageTest.class,
                          PixelTest.class,
                          PointTest.class, 
                          /*TurtleTest.class*/})
public class AllModelTests {

}
