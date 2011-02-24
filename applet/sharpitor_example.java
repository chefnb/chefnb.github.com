import processing.core.*; 
import processing.xml.*; 

import com.sharpitor.dashboard.*; 
import com.sharpitor.tellus.*; 
import com.sharpitor.tellus.lindemayer.*; 
import com.sharpitor.tellus.tellurians.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class sharpitor_example extends PApplet {


/* Example usage for Tellus and associated packages

   Nick@sharpitor.com. 2010-11

*/






// ---------------------------------------------------

Tellus theWorld;   
Dashboard theDashboard;

boolean playback=false;

public void setup() {
  size(400, 300);  
  frameRate(30);  
  
  theWorld = new Tellus(this,playback); 
  
  theWorld.createTerrain(20,color(220,220,220),color(200,160,140));
  //theWorld.createLakes(100,color(150,180,190),color(60,200,200));
  theWorld.createSky(color(240,255,255),400);
  theWorld.createForest(5,"skinny-linden");
   
  theDashboard = new Dashboard(this);
  theDashboard.addJoystick(330,240,0.8f); 
  theDashboard.addCompass(250,240,0.8f);
  theWorld.interfaceWith(theDashboard);

}

public void draw() {

 theDashboard.update();
 theWorld.update();
 
 theWorld.draw();
 theDashboard.draw();
}

public void mousePressed(){
  theDashboard.mousePressed();
}

public void mouseReleased(){
 theDashboard.mouseReleased();  
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--stop-color=#cccccc", "sharpitor_example" });
  }
}
