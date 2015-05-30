import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class JayDeeGooey
{
  private HashMap<Character, Character> map;
  
  public JayDeeGooey()
  {
    Scanner scanner = new Scanner(System.in);
    System.out.println("");
    String s = scanner.next();
    for (int i = 0; i < s.length(); i++) {
      if (('a' > s.charAt(i)) || (s.charAt(i) > 'z'))
      {
        System.out.println("Invalid string.");
        return;
      }
    }
    this.map = new HashMap();
    for (int i = 97; i <= 122; i += 2)
    {
      this.map.put(Character.valueOf((char)i), Character.valueOf((char)(i + 1)));
      this.map.put(Character.valueOf((char)(i + 1)), Character.valueOf((char)i));
    }
    String k = "";
    for(int i = 97; i < 123; i++){
        k+=(map.get(i));
    }
    System.out.println(k);
    String sub = substeetooshun(s);
    System.out.println(sub);
    if (sub.equals("ichvjnvtsaftpgfkoevk")) {
      System.out.println("Yay you entered the flag :D");
    } else {
      System.out.println("Try again next HSCTF!");
    }
  }
  
  private String substeetooshun(String msg)
  {
    String s = "";
    for (int i = 0; i < msg.length(); i++)
    {
      char c = msg.charAt(i);
      s = s + this.map.get(Character.valueOf(c));
    }
    return s;
  }
  
  public static void main(String[] args)
  {
    new JayDeeGooey();
  }
}
