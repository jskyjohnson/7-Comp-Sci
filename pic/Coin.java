import java.awt.Image;
import java.awt.Graphics;

public class Coin
{
  private Image heads, tails;
  private int side;

  public Coin(Image pic1, Image pic2)
  {
    heads = pic1;
    tails = pic2;
    side = 1;
  }

  public void flip()
  {
    side = -side;
  }

  public void draw(Graphics g, int x, int y)
  {
    if (side == 1)
    {
      int w = heads.getWidth(null);
      int h = heads.getHeight(null);
      g.drawImage(heads, x - w /2, y - h/2, null);
    }
    else
    {
      int w = tails.getWidth(null);
      int h = tails.getHeight(null);
      g.drawImage(tails, x - w /2, y - h/2, null);
    }
  }
}
