// Sky Johnson Meteor Sandbox Game v1
/*

  THIS IS INCOMPLETE, As i only had time to really figure out how camera's work and even that panning isn't finished
  This game attempts to display colliding 3d objects onto a sphere
  suppose to be a physics like simulation, Original idea off of games like Universe Sandbox
  
  Help in development is lead from other online sources
  For 3d help http://www.openprocessing.org/sketch/48786 is what i based it off of.
  and the https://processing.org/tutorials/p3d/ for other help
*/
ArrayList<Sphereoid> objects;
float eyeX;
float eyeY;
float eyeZ;
float centerX;
float centerY;
float centerZ;
float upX;
float upY;
float upZ;

float mouseVelX;
float mouseVelY;
float mouseRecX;
float mouseRecY;
float camRadius;
float s;
float t;


void setup(){
  size(400, 400, P3D);
  objects = new ArrayList<Sphereoid>();
  Sphereoid newSphere = new Sphereoid();
  objects.add(newSphere);
  
  //Camera Stuff
  //Camera Sphere stuff;
  camRadius = 200;
  s = 0;
  t = 0;
  eyeX = width/2.0;
  eyeY = height/2.0;
  eyeZ = (height/2.0) / tan(PI/6);
  centerX = width/2.0;
  centerY = height/2.0;
  centerZ = 0;
  upX =0;
  upY =1;
  upZ = 0;
  mouseVelX = 0;
  mouseVelY = 0;
  mouseRecX = 0;
  mouseRecY = 0;
  
}
void mouseDragged(){
  mouseVelX = (mouseX - mouseRecX)/100.0;
  mouseVelY = (mouseY - mouseRecY)/100.0;
  //s -= .01;
//  t -= mouseVelY;
  //centerX += mouseVelX;
  //centerY += mouseVelY;
  mouseRecX = mouseX;
  mouseRecY = mouseY;
}
void mouseMoved(){
  mouseRecX = mouseX;
  mouseRecY = mouseY;
}
void mouseWheel(MouseEvent event){
  float e = event.getCount()*10;
  camRadius+=e;
}
void cameraTick(){
  t+=.01;
  eyeX = camRadius;
  eyeY = 0;
  eyeZ = 0;
}
void tick(){
  cameraTick();
 for(Sphereoid obj: objects){
   obj.tick(); 
  }
}
void draw(){
  background(0);
  tick();
  
  camera(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
  
  spotLight(255, 0, 0, width/2, height/2, 400, 0, 0, -1, PI/4, 2);
  for(Sphereoid obj: objects){
   obj.display(); 
  }
  
  //test Cube
  pushMatrix();
  stroke(255);
  fill(255);
  translate(width/2.0, height/2.0, 0);
  box(50);
  popMatrix();
}
/*Sphereoid Objects are located somewhere in 3 space;
 they have a gravity or attraction value;
 and they also have a radius for how big they are to be displayed
 they have a color (textures to be added later)
 
 They also have a vector for their speed in a direction
 this will be updated constantly because the gravity of different objects will influence it's velocity

*/
class Sphereoid{
 float x;
 float y;
 float z;
 float gravity;
 float radius;
 float red;
 float green;
 float blue;
 
 float xRotation;
 float yRotation;
 float zRotation;
 float xSpin;
 float ySpin;
 float zSpin;

 float speed;
 float xnorm;
 float ynorm;
 float znorm;
 Sphereoid(){
   x = width/2;
   y = height/2;
   z = 0;
   radius = 200;
   red = 125;
   green = 125;
   blue = 125;
   xnorm = 0;
   ynorm = 0;
   znorm = 0;
   speed = 0;
   xRotation = 0;
   yRotation = 0;
   zRotation = 0;
   
   xSpin =(float) Math.random()*.001;
   ySpin = (float)Math.random()*.001;
   zSpin = (float)Math.random()*.001;
 }
 void display(){
   pushMatrix();
    translate(x,y,z);
    noFill();
    rotateX(xRotation);
    rotateY(yRotation);
    rotateZ(zRotation);
    stroke(red, green, blue);
    sphere(radius);
   popMatrix();
 }
 void tick(){
   x+=xnorm*speed;
   y+=ynorm*speed;
   z+=znorm*speed;
   xRotation +=xSpin;
   yRotation += ySpin;
   zRotation += zSpin;
 }
 void calcAttraction(){
   
 }
}


