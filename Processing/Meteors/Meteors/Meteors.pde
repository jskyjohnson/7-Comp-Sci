//By Sky Johnson Meteors-minimal v1
/*
This takes in a file, that's to be choosen by a JFileChooser
Once the program loads the file, it scans the file and reads off
3 coloums of floats, the first one is how bright the meteor is
the second one is its latitudual value,
it's third is its longitudal value
It represents how bright an object is based on a log of the brightness value.
Everytime the mouse is clicked, it moves all the meteors slightly to right right
to represent a turning of the earth at night.
*/

import javax.swing.JFileChooser;
ArrayList<Met> mets;
String[] k;

void setup(){
  size(500, 500);
  mets = new ArrayList<Met>(0);
  JFileChooser chooser = new JFileChooser();
  int returnValue = chooser.showOpenDialog(null);
  if(returnValue == JFileChooser.APPROVE_OPTION){
   File file = chooser.getSelectedFile(); 
   k = loadStrings(file);
  }
 // System.out.println(k.length);
  for(int i = 0; i < k.length; i++){
    String thisone = k[i];
    String[] thislists = split(thisone, " ");
    Met temp = new Met(Float.parseFloat(thislists[0]), Float.parseFloat(thislists[1]), Float.parseFloat(thislists[2]));
    mets.add(temp);
  }
 // System.out.println(mets.size());
  
}
void mousePressed(){
  //System.out.println("Test");
 for(Met m : mets){
  m.tick();
 } 
}
void draw(){
  background(0);
  
  for(Met m : mets){
   m.display(); 
  }
}

class Met{
 float brightness;
 float lat;
 float lon;
 float speed;
 Met(float a, float b, float c){
   brightness = a;
   lat = b;
   lon = c;
   speed = 10;
 }
 void display(){
   ellipse(lat, lon, (float) Math.log(brightness), (float) Math.log(brightness));
 }
 void tick(){
   lat+= speed;
 }
}
