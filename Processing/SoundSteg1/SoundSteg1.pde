/**
  * This sketch demonstrates how to use an AudioRecorder to record audio to disk
  * and then immediately play it back by creating a new FilePlayer using the AudioRecordingStream
  * returned by the save method.
  * <p> 
  * To use this sketch you need to have something plugged into the line-in on your computer.<br/>
  * Press 'r' to toggle recording on and off and the press 's' to save to disk.<br/>
  * The recorded file will be placed in the main folder of the sketch.
  * <p>
  * For more information about Minim and additional features, visit http://code.compartmental.net/minim/
  */

import ddf.minim.*;
import ddf.minim.ugens.*;

Minim minim;

// for recording
AudioInput in;
AudioRecorder recorder;

// for playing back
AudioOutput out;
FilePlayer player;

void setup()
{
  size(512, 200, P3D);

  minim = new Minim(this);
  
  // get a stereo line-in: sample buffer length of 2048
  // default sample rate is 44100, default bit depth is 16
  in = minim.getLineIn(Minim.STEREO, 2048);
  
  // create an AudioRecorder that will record from in to the filename specified.
  // the file will be located in the sketch's main folder.
  recorder = minim.createRecorder(in, "myrecording.wav");
  
  // get an output we can playback the recording on
  out = minim.getLineOut( Minim.STEREO );
  
  textFont(createFont("Arial", 12));
}

void draw()
{
  background(0); 
  stroke(255);
  // draw the waveforms
  // the values returned by left.get() and right.get() will be between -1 and 1,
  // so we need to scale them up to see the waveform
  for(int i = 0; i < in.left.size()-1; i++)
  {
    line(i, 50 + in.left.get(i)*50, i+1, 50 + in.left.get(i+1)*50);
    line(i, 150 + in.right.get(i)*50, i+1, 150 + in.right.get(i+1)*50);
  }
  
  if ( recorder.isRecording() )
  {
    text("Now recording...", 5, 15);
  }
  else
  {
    text("Not recording.", 5, 15);
  }
}

void keyReleased()
{
  if ( key == 'r' ) 
  {
    if ( recorder.isRecording() ) 
    {
      recorder.endRecord();
    }
    else 
    {
      recorder.beginRecord();
    }
  }
  if ( key == 's' )
  {
    if ( player != null )
    {
        player.unpatch( out );
        player.close();
    }
    player = new FilePlayer( recorder.save() );
    player.patch( out );
    player.play();
  }
}
