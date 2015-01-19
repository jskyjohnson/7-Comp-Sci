
/**
 * Write a description of class SimpleCoinTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleCoinTest extends JPanel
{
  private SimpleCoin coin;

  public SimpleCoinTest ()
  {
    Image heads = (new ImageIcon("heads.gif")).getImage();
    coin = new SimpleCoin(heads);
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    int x = getWidth() / 2;
    int y = getHeight() / 2;
    int a = getWidth() / 6;
    int b = getHeight() / 6;
    coin.draw(g, x, y);
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Coin");
    w.setSize(300, 300);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    SimpleCoinTest panel = new SimpleCoinTest();
    panel.setBackground(Color.WHITE);
    w.getContentPane().add(panel);

    w.setVisible(true);
  }
}

