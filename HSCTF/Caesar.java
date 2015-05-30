import java.io.PrintStream;
import java.util.Scanner;

public class Caesar
{
  public Caesar()
  {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    String plaintxt = scanner.next();
    for (int i = 0; i < plaintxt.length(); i++) {
      if (('a' > plaintxt.charAt(i)) || (plaintxt.charAt(i) > 'z'))
      {
        System.out.println("Invalid string.");
        return;
      }
    }
    String ciphertxt = caesar(plaintxt, 5);
    System.out.println(ciphertxt);
    if (ciphertxt.equals("nijxtkrfwhmjyyzgwzyj")) {
      System.out.println("Yay, the plaintxt is the flag.");
    } else {
      System.out.println(":(");
    }
  }
  
  private String caesar(String message, int delta)
  {
    String s = "";
    for (int i = 0; i < message.length(); i++)
    {
      char c = (char)(message.charAt(i) + delta);
      if (c > 'z') {
        s = s + (char)(message.charAt(i) - (26 - delta));
      } else {
        s = s + (char)(message.charAt(i) + delta);
      }
    }
    return s;
  }
  
  public static void main(String[] args)
  {
    new Caesar();
  }
}
