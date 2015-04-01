Skip to content
 This repository
Explore
Gist
Blog
Help
@nullmage nullmage
 
 Watch 4
  Star 2
 Fork 0broseidon91/SoundVisualizer
 branch: master  SoundVisualizer/Sound_FFTDemo
@broseidon91broseidon91 on Nov 21, 2013 Create Sound_FFTDemo
1 contributor
RawBlameHistory     343 lines (272 sloc)  7.262 kb

import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.effects.*;
import java.io.File;
import java.io.FilenameFilter;

//Objects
FFT fft;
Minim minim;
AudioPlayer player;
AudioPlayer playerTwo;
IIRFilter filter;
Ball ball;
FileReader reader;
Camera camera = new Camera();
CollisionBC bC;
CollisionBC b2C;
Blob b;
Blob b2;
CollisionBC mouseC;
Engine engine = new Engine();
ArrayList<Blob> blobs = new ArrayList<Blob>();
ArrayList<CollisionBC> blobsC = new ArrayList<CollisionBC>();
PShader shader;
PVector offset = new PVector(0,0);
float thresh = 0;

//Misc
color waveColor;
String[] fileNames;
String filePath = "music/";
//Ints
int waveIncr = 0;
int counter = 0;
int songCounter = 0;
int fadeLevel = 10;



//Bools
boolean counterGoUp = false;
boolean hueShift = true;
boolean isPlaying = true;

void setup()
{
  size(1024, 768, P2D);
  //Read the filename
  reader = new FileReader(new File(dataPath(filePath)));

  fileNames = reader.getFiles();
  for (int i = 0; i < fileNames.length; i++)
  {
    fileNames[i] = filePath + fileNames[i];
  }


  //SHADERS:
  shader = loadShader("circleBlur.glsl");
  shader.set("resolution", new PVector(width,height));
  

  println(fileNames);

  minim = new Minim(this);
  player = minim.loadFile(fileNames[songCounter], 2048);
  //09 Atlas.mp3
  //Overdose.mp3
  //playerTwo = minim.loadFile("Overdose.mp3", 2048);
  if (player != null) filter = new LowPassSP(1024, player.sampleRate());

  player.addEffect(filter);
  //playerTwo.addEffect(filter);

  fft = new FFT(player.bufferSize(), player.sampleRate());

  ball = new Ball(player, 100, 400);
  ball.drawLines = false;
  noStroke();
  smooth();
  b = new Blob(player, 100, 200);
  b2 = new Blob(player, 100, 150);
  bC = new CollisionBC(new PVector(b.X, b.Y), b.radius);
  b2C = new CollisionBC(new PVector(b2.X, b2.Y), b2.radius);
  mouseC = new CollisionBC(new PVector(mouseX, mouseY), 50);
  engine.Add(bC);
  engine.Add(b2C);
  engine.Add(mouseC);
  for (int i = 0; i < 50; i++)
  {
    CollisionBC b = new CollisionBC(new PVector(random(width), random(height)), random(50));
    Blob bl = new Blob(player, b.position.x, b.position.y);
    bl.colorInt = random(360);
    bl.radiusIntensity = random(5, 20);
    blobs.add(bl);
    blobsC.add(b);
    engine.Add(b);
  }

  
}

void draw()
{ 
  
  thresh = map(mouseX, 0, width, 0, 1);
  shader.set("thresh", thresh);
  //shader.set("offset", offset);
  fill(360, 255,255);
  ellipse(width/2, height/2, 50,50);
  noFill();
  //println(songCounter);
  mouseX = mouseX + (int)camera.x;
  mouseY = mouseY + (int)camera.y;
  engine.Update();
  b.X = bC.position.x;
  b.Y = bC.position.y;
  bC.radius = b.radius;
  b2.X = b2C.position.x;
  b2.Y = b2C.position.y;
  b2C.radius = b2.radius;
  mouseC.position.x = mouseX;
  mouseC.position.y = mouseY;

  
  //Wave bounce
  if (counterGoUp) counter--;
  else counter++;
  if (counter > height - 50) counterGoUp = true;
  if (counter < -50) counterGoUp = false;

  if (!isPlaying) player.pause();

  if (isPlaying) 
  {
    player.play();
  }


  camera.update();

  pushMatrix();
  applyMatrix(camera.matrix);
  //  fill(255, fadeLevel); // semi-transparent white
  //
  //  rect(camera.x, camera.y, width, height);



  //boxes.add(new Box(0,0,width,height));
  filter(shader);
  
  noFill();


  //DRAW FFT
  fft.forward(player.mix);
  colorMode(HSB, 255);



  float spread = map(450, 0, width, 1, 21.5);
  float x = 0;
  for (int i = 0; i < player.sampleRate() && x < width; i += spread)
  {
    x = i/spread;
    stroke(map(fft.getFreq(i), 0, 256, 0, 360) * 2, //Hue
    255, //Saturation
    255); //Brightness
    line(x, 512, x, 512 - fft.getFreq(i) * 4);
  }
  //map(value, minimum1, maximum1, minimum2, maximum2);

  x = 0;
  for (int i = 0; i < player.sampleRate() && x < width; i += spread)
  {
    x = i/spread;
    stroke(map(fft.getFreq(i), 0, 256, 0, 360) * 2, //Hue
    255, //Saturation
    255); //Brightness
    line(x, 512, x, 512 + fft.getFreq(i) * 4);
  }




  ball.draw();
  fill(50, 200, 200);
  b.draw();
  b2.draw();



  //DRAW WAVE
  float lineThickness = map(1, 0, height, 0, 50);
  for (int i = 0; i< player.bufferSize() - 1 && i < width; i++)
  {
    float y1 = 50 + player.mix.get(i) * 50;
    float y2 = 50 + player.mix.get(i+1) * 50;
    colorMode(HSB, 255);
    float hue = map(i, 0, width, 0, 360);
    if (hue + waveIncr > 360) waveColor = color(hue + (waveIncr - 360), 255, 255);
    else waveColor = color(hue + waveIncr, 255, 255);
    stroke(waveColor);
    line(i, y1+ counter, i +1, y2 + lineThickness + counter);
  }
  //END DRAW WAVE
  

  for (int i = 0; i < blobs.size(); i++)
  {
    blobs.get(i).X = blobsC.get(i).position.x;
    blobs.get(i).Y = blobsC.get(i).position.y;
    blobsC.get(i).radius = blobs.get(i).radius;

    blobs.get(i).draw();
  }  

  popMatrix();

  waveIncr += 1;
  if (waveIncr > 360) waveIncr = 0;



  textSize(12);
  fill(255);
  text(fileNames[songCounter], 10, height - 10);
  text("P = pause | Space = circle colormode |  N = next song | B = previous song", 10, 10);

  noStroke();
  noFill();


  println(fileNames);
} //end Draw

void keyReleased()
{
  //Key: P
  if (keyCode == 80)
  {

    isPlaying = !isPlaying;
  }
  if (keyCode == 32)
  {
    ball.drawLines = !ball.drawLines;
  }
  //Key: N
  if (keyCode == 78)
  {

    songCounter++;
    if (songCounter > fileNames.length - 1)
    {
      songCounter = 0;
    }

    player.pause();
    minim = new Minim(this);

    player = minim.loadFile(fileNames[songCounter], 2048);

    player.play();
    PVector p = new PVector(ball.X, ball.Y);
    ball = new Ball(player, p.x, p.y);
    b = new Blob(player, 100, 200);
    b2 = new Blob(player, 100, 150);
    for (int i = 0; i < blobs.size() -1; i++)
    {
      float tempX = blobs.get(i).X;
      float tempY = blobs.get(i).Y;
      blobs.remove(i);
      Blob b = new Blob(player, tempX, tempY);
      b.colorInt = random(360);
      blobs.add(b);
    }
  }
  //Key: B
  if (keyCode == 66)
  {

    songCounter--;
    if (songCounter < 0)
    {
      songCounter = fileNames.length - 1;
    }

    player.pause();
    minim = new Minim(this);
    if (minim.loadFile(fileNames[songCounter], 2048) != null) player = minim.loadFile(fileNames[songCounter], 2048);
    player.play();
    PVector p = new PVector(ball.X, ball.Y);
    ball = new Ball(player, p.x, p.y);
    b = new Blob(player, 100, 200);
    b2 = new Blob(player, 100, 150);
    for (int i = 0; i < blobs.size() - 1; i++)
    {
      float tempX = blobs.get(i).X;
      float tempY = blobs.get(i).Y;
      blobs.remove(i);
      Blob b = new Blob(player, tempX, tempY);
      b.colorInt = random(360);
      blobs.add(b);
    }
  }
}
void keyPressed()
{
  if (keyCode == UP) camera.speed.y = -10;
  if (keyCode == DOWN) camera.speed.y = 10;
  if (keyCode == LEFT) camera.speed.x = -10;
  if (keyCode == RIGHT) camera.speed.x = 10;
}


void mousePressed()
{
  mouseC.radius = 1;


  for (CollisionBC bc : blobsC)
  {
    float distX = mouseX - bc.position.x;
    float distY = mouseY - bc.position.y;
    float dist = sqrt((distX * distX) + (distY * distY));

    if (dist < 150)
    {
      bc.speed.x = distX * .1;
      bc.speed.y = distY * .1;
    }
  }
}

void mouseReleased()
{

  mouseC.radius = 50;
}
Status API Training Shop Blog About
© 2015 GitHub, Inc. Terms Privacy Security Contact
