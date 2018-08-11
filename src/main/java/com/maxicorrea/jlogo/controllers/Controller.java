package com.maxicorrea.jlogo.controllers;


public interface Controller {

  boolean isMyCommand(String cmd);
   
  boolean execute();
  
}
