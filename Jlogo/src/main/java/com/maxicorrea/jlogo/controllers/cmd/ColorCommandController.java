package com.maxicorrea.jlogo.controllers.cmd;

import com.maxicorrea.jlogo.controllers.utils.Parser;
import com.maxicorrea.jlogo.models.Pixel;
import com.maxicorrea.jlogo.models.cmd.ColorCommand;

public class ColorCommandController extends CommandController<Pixel> {

  public ColorCommandController() {
   super(new ColorCommand());
 }
 
 @Override
  public boolean validParameters() {
   String args = command.strArguments();
   Parser val = new Parser(args);
   if (val.anInteger(0,255).and(",").
             anInteger(0,255).and(",").
             anInteger(0,255).endOfLine().ok()) {
     int r = val.nextInt();
     int g = val.nextInt();
     int b = val.nextInt();
     command.parameter(new Pixel(r, g, b));
     return true;
   }
   return false;
 }

}