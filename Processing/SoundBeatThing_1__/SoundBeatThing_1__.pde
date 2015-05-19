import ddf.minim.*;
import ddf.minim.analysis.*;
import javax.swing.JFileChooser;
Minim minim;
AudioPlayer song;
FFT fft;
 
void setup()
{
  size(512, 400);
 
  minim = new Minim(this);
 
  JFileChooser chooser = new JFileChooser();
  int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File file = chooser.getSelectedFile();
          song = minim.loadFile(file.getAbsolutePath(), 1024);
      }
 
 
  song.play();
 
 
  fft = new FFT(song.bufferSize(), song.sampleRate());
}
 
void draw()
{
  background(0);
  
  fft.forward(song.mix);

  for(int i = 0; i < fft.specSize(); i+=5)
  {
    int red= 0;
    int green = 0;
    int blue = 0;
    
    double freq = (Math.log((fft.getBand(i)+fft.getBand(i+1)+fft.getBand(i+2))/3+1))/2;
    
     red   =(int) (Math.sin(freq)* 127 + 128);
     green =(int) (Math.sin(freq+(Math.PI/3)) * 127 + 128);
     blue  =(int) (Math.sin(freq+((2*Math.PI)/3)) * 127 + 128);
    stroke(red, green, blue);
    fill(red, green, blue);
    rect(i+5, Math.abs(height- (( (fft.getBand(i)+fft.getBand(i+1)+fft.getBand(i+2)+fft.getBand(i+3)+fft.getBand(i+4) )/5 ) )), 5, ( (fft.getBand(i)+fft.getBand(i+1)+fft.getBand(i+2)+fft.getBand(i+3)+fft.getBand(i+4)) /5)*4 );
  }
 
 
  stroke(255);

  for(int i = 0; i < song.left.size() - 1; i++)
  {
    
    int red= 0;
    int green = 0;
    int blue = 0;
    
     double freq = (((2*Math.PI)*song.left.get(i))+1)/2;
     red   =(int) (Math.sin(freq)* 127 + 128);
     green =(int) (Math.sin(freq+(Math.PI/3)) * 127 + 128);
     blue  =(int) (Math.sin(freq+((2*Math.PI)/3)) * 127 + 128);
     stroke(red, green, blue);
    
    line(i, 50 + song.left.get(i)*50, i+1, 50 + song.left.get(i+1)*50);
    
    freq = ((2*Math.PI)*song.right.get(i)+1)/2;
     red   =(int) (Math.sin(freq)* 127 + 128);
     green =(int) (Math.sin(freq+(Math.PI/3)) * 127 + 128);
     blue  =(int) (Math.sin(freq+((2*Math.PI)/3)) * 127 + 128);
     stroke(red, green, blue);
    line(i, 150 + song.right.get(i)*50, i+1, 150 + song.right.get(i+1)*50);
  }
}



