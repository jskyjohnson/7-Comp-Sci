
/**
 * Write a description of class SimpleCoin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.Image;
import java.awt.Graphics;

public class SimpleCoin
{
  private Image heads;

  public SimpleCoin(Image pic1)
  {
    heads = pic1;
  }

  public void draw(Graphics g, int x, int y)
  {
      int w = heads.getWidth(null);
      int h = heads.getHeight(null);
      g.drawImage(heads, x - w /2, y - h/2, null);
  }
}

