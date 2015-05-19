import javax.swing.JFileChooser;

PImage pic1;
PImage ill;

final int hueMask = 0xFCFCFCFC;
final int hueMask2 = 0xC0C0C0C0;
final boolean alpha = true;
boolean decrypted = false;


void setup() {
  JFileChooser chooser1 = new JFileChooser();
  int k1 = chooser1.showOpenDialog(null);
  if(k1 == JFileChooser.APPROVE_OPTION){
   File file = chooser1.getSelectedFile();
   pic1 = loadImage(file.getAbsolutePath()); 
  }
  JFileChooser chooser12 = new JFileChooser();
  int k2 = chooser12.showOpenDialog(null);
  if(k2 == JFileChooser.APPROVE_OPTION){
   File file2 = chooser12.getSelectedFile();
   ill = loadImage(file2.getAbsolutePath()); 
  }
  
  pic1.resize(pic1.width, pic1.height);
  if( (double)(ill.height)/ill.width < (double)(pic1.height)/pic1.width ) {  // pic1 portrait, ill landscape
    ill.resize(pic1.width, (int)( (double)(ill.height)/ill.width * pic1.height ) );
  }
  else {  // pic1 landscape, ill portrait
    ill.resize( (int)( (double)(ill.width)/ill.height * pic1.height ), pic1.height );
  }
  
  size(pic1.width, pic1.height);
  image(pic1, 0, 0);
  encrypt();
}

void mousePressed() {
  if (!decrypted) {
    decrypt();
  }
  
}

void draw() {}

void encrypt() {
  for (int pic1Seed = 0; pic1Seed < ill.height; pic1Seed++) {
     for (int pic1Stalk = 0;  pic1Stalk < ill.width; pic1Stalk++) {
       int pic1Hue = pic1.get(pic1Stalk, pic1Seed);
       int sickHue = ill.get(pic1Stalk, pic1Seed);
       pic1Hue = pic1Hue & hueMask;
       sickHue = sickHue & hueMask2;
       sickHue = sickHue >> 6;
       if( !alpha ) sickHue = sickHue & 0xFFFFFF;
       pic1Hue = pic1Hue + sickHue;
       pic1.set(pic1Stalk, pic1Seed, pic1Hue);
     }
  }
  image(pic1, 0, 0);
}

void decrypt() {
  for (int pic1Seed = 0; pic1Seed < ill.height; pic1Seed++) {
     for (int pic1Stalk = 0;  pic1Stalk < ill.width; pic1Stalk++) {
       int pic1Hue = pic1.get(pic1Stalk, pic1Seed);
       pic1Hue = pic1Hue << 6;
       pic1Hue = pic1Hue & hueMask2;
       pic1.set(pic1Stalk, pic1Seed, pic1Hue);
     }
  }
  background( 255 );
  image( pic1, 0, 0 );
  decrypted = true;
}
