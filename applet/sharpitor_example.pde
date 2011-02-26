
/* Example usage for Tellus and associated packages

   Nick@sharpitor.com. 2010-11

*/

import com.sharpitor.dashboard.*;
import com.sharpitor.tellus.*;
import com.sharpitor.tellus.lindemayer.*;
import com.sharpitor.tellus.tellurians.*;

// ---------------------------------------------------

Tellus theWorld;   
Dashboard theDashboard;

boolean playback=false;

public void setup() {
  size(400, 300);  
  frameRate(30);  
  
  theWorld = new Tellus(this,playback); 
  
  theWorld.createTerrain(20,180,color(200,160,140));
  //theWorld.createLakes(100,color(150,180,190),color(60,200,200));
  
    theWorld.createSky(color(230,250,255),600);
   theWorld.createForest(5,1);
 
  
  theDashboard = new Dashboard(this);
  theDashboard.addJoystick(330,240,0.8); 
  theDashboard.addCompass(250,240,0.8);
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

