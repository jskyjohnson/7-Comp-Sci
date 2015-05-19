import ddf.minim.*;
import ddf.minim.analysis.*;
import javax.swing.JFileChooser;
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
 
AudioPlayer song;
BeatDetect beat;
BeatListener bl;
Minim minim;
 
float kickSize, snareSize, hatSize;
 
void setup()
{
size(512, 200);
smooth();
minim = new Minim(this);


JFileChooser chooser = new JFileChooser();
  int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File file = chooser.getSelectedFile();
          song = minim.loadFile(file.getAbsolutePath(), 1024);
      }

song.play();
// a beat detection object that is FREQ_ENERGY mode that
// expects buffers the length of song's buffer size
// and samples captured at songs's sample rate
beat = new BeatDetect(song.bufferSize(), song.sampleRate());
beat.setSensitivity(300);
beat.detectMode(BeatDetect.FREQ_ENERGY);
// make a new beat listener, so that we won't miss any buffers for the analysis
bl = new BeatListener(beat, song);
}
 
void draw()
{
  System.out.println(beat.dectectSize());
  for(int i = 0; i < width ; i++){
      rect((width/beat.dectectSize())*i, height - beat.getDetectCenterFrequency(i), 5, beat.getDetectCenterFrequency(i)); 
  }
}
 
void stop()
{
// always close Minim audio classes when you are finished with them
song.close();
// always stop Minim before exiting
minim.stop();
 
// this closes the sketch
super.stop();
}
