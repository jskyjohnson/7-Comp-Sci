

import ddf.minim.*;
import ddf.minim.analysis.*;

Minim minim;
AudioPlayer song;
BeatDetect beat;
BeatListener bl;
ArrayList<Float> values;

float kickSize, snareSize, hatSize;

class BeatListener implements AudioListener
{
  private BeatDetect beat;
  private AudioPlayer source;
  
  BeatListener(BeatDetect beat, AudioPlayer source)
  {
    this.source = source;
    this.source.addListener(this);
    this.beat = beat;
  }
  
  void samples(float[] samps)
  {
    beat.detect(source.mix);
  }
  
  void samples(float[] sampsL, float[] sampsR)
  {
    beat.detect(source.mix);
  }
}

void setup()
{
  size(512, 200, P3D);
  
  minim = new Minim(this);
  
  song = minim.loadFile("song.mp3", 1024);
  song.play();
  
  beat = new BeatDetect(song.bufferSize(), song.sampleRate());
  
  beat.setSensitivity(1000);  
  
  bl = new BeatListener(beat, song);  
  System.out.println(beat.dectectSize());
  values = new ArrayList<Float>(beat.dectectSize());
  for(int i = 0; i < beat.dectectSize(); i++){
   values.add(1f); 
  }
  System.out.println(values.size());
  textFont(createFont("Helvetica", 16));
  textAlign(CENTER);
}

void draw()
{
  background(0);
  fill(255);
  //System.out.println(values);
  for(int i = 0; i < beat.dectectSize()-1; i++){
    
    if(beat.isRange(i, i+1, 1)){
      values.set(i, 1f);
    }
     values.set(i, values.get(i)*.9); 
    rect(width/values.size() *i, height, width/values.size(), -50*values.get(i));
 }
 System.out.println(values);
}
