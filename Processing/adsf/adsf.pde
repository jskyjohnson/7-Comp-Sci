import ddf.minim.*;
import ddf.minim.analysis.*;
import javax.swing.JFileChooser;
Minim minim;
AudioPlayer song;
FFT fft;
 
ArrayList<Integer> reds;
ArrayList<Integer> greens;
ArrayList<Integer> blues;
int clock;
void setup()
{
  
 
  minim = new Minim(this);
  
//  JFileChooser chooser = new JFileChooser();
//  int returnValue = chooser.showOpenDialog(null);
//        if (returnValue == JFileChooser.APPROVE_OPTION) {
//          File file = chooser.getSelectedFile();
//          song = minim.loadFile(file.getAbsolutePath(), 1024);
//      }
  reds = new ArrayList<Integer>();
  greens = new ArrayList<Integer>();
  blues = new ArrayList<Integer>();
  
  song = minim.loadFile("song.mp3", 1024);
  song.play();
  fft = new FFT(song.bufferSize(), song.sampleRate());
  for(int i = 0; i < fft.specSize()*height;i++){
   reds.add(0);
   greens.add(0);
   blues.add(0); 
  }
  clock = 0;
  size(512, fft.specSize());
}
void tick(){
  for(int i = reds.size() - fft.specSize(); i > 0; i--){
   reds.set(i+fft.specSize()-1, reds.get(i));
   greens.set(i+fft.specSize()-1, greens.get(i));
   blues.set(i+fft.specSize()-1, blues.get(i));
  }
  for(int i = 0; i < fft.specSize(); i++){
    int red = (int) (Math.sin((2*Math.PI)/i)*127+128);
    int green = (int) (Math.sin((2*Math.PI)/i)*127+128);
    int blue = (int) (Math.sin((2*Math.PI)/i)*127+128);  
    reds.set(i, red);
    greens.set(i, green);
    blues.set(i, blue); 
 }
  
  clock++;
}
 
void draw()
{
  tick();
  background(0);
  
  fft.forward(song.mix);

  for(int i = 0; i < height; i++){
   for(int k = 0; k < fft.specSize();k++){
    int thisone = k+fft.specSize()*i ;
    try{
    stroke(reds.get(thisone/2), greens.get(thisone/2), blues.get(thisone/2));
    }catch(Exception e){
      
    }
    point(k, i);
   } 
  }
//  for(int i = 0; i < fft.specSize(); i+=5)
//  {
//     int red= 0;
//     int green = 0;
//     int blue = 0;
//    
//     double freq = (Math.log((fft.getBand(i)+fft.getBand(i+1)+fft.getBand(i+2))/3+1))/2;
//    
//     red   =(int) (Math.sin(freq)* 127 + 128);
//     green =(int) (Math.sin(freq+(Math.PI/3)) * 127 + 128);
//     blue  =(int) (Math.sin(freq+((2*Math.PI)/3)) * 127 + 128);
//     stroke(red, green, blue);
//     fill(red, green, blue);
//     rect(i+5, Math.abs(height- (( (fft.getBand(i)+fft.getBand(i+1)+fft.getBand(i+2)+fft.getBand(i+3)+fft.getBand(i+4) )/5 ) )), 5, ( (fft.getBand(i)+fft.getBand(i+1)+fft.getBand(i+2)+fft.getBand(i+3)+fft.getBand(i+4)) /5)*4 );
//       
//}
// 
// 
//  stroke(255);
//
//  for(int i = 0; i < song.left.size() - 1; i++)
//  {
//    
//    int red= 0;
//    int green = 0;
//    int blue = 0;
//    
//     double freq = (((2*Math.PI)*song.left.get(i))+1)/2;
//     red   =(int) (Math.sin(freq)* 127 + 128);
//     green =(int) (Math.sin(freq+(Math.PI/3)) * 127 + 128);
//     blue  =(int) (Math.sin(freq+((2*Math.PI)/3)) * 127 + 128);
//     stroke(red, green, blue);
//    
//    line(i, 50 + song.left.get(i)*50, i+1, 50 + song.left.get(i+1)*50);
//    
//    freq = ((2*Math.PI)*song.right.get(i)+1)/2;
//     red   =(int) (Math.sin(freq)* 127 + 128);
//     green =(int) (Math.sin(freq+(Math.PI/3)) * 127 + 128);
//     blue  =(int) (Math.sin(freq+((2*Math.PI)/3)) * 127 + 128);
//     
//     stroke(red, green, blue);
//    line(i, 150 + song.right.get(i)*50, i+1, 150 + song.right.get(i+1)*50);
//  }
}



