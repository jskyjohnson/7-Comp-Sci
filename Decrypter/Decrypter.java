import java.io.*;
import java.util.*;
public class Decrypter
{
    public static void main(String args[]) throws IOException
    {
        FileInputStream in = null;
        FileOutputStream out = null;
        ArrayList<Integer> a = new ArrayList<Integer>();
        try {
            in = new FileInputStream("encrypted.txt");
            out = new FileOutputStream("output.txt");

            for(int i = 0; i < 200; i ++){
                a.add(0);
            }
            int c;
            while ((c = in.read()) != -1) {
                int k = a.get(c);
                a.set(c, k+1);
                for(int f = 0; f < 26; f++){
                    for(int i = 0; i < f; i++){ 
                        if(c!=32){
                            c++;   
                        }
                        if(c== 123){
                            c = 97;
                        }
                        
                    }
                    out.write(c);
                }

            }
        }finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.write(124);
                //System.out.println(a);
                out.close();
            }
        }
    }
}
/*
 * import java.io.*;

public class CopyFile {
public static void main(String args[]) throws IOException
{
FileInputStream in = null;
FileOutputStream out = null;

try {
in = new FileInputStream("input.txt");
out = new FileOutputStream("output.txt");

int c;
while ((c = in.read()) != -1) {
out.write(c);
}
}finally {
if (in != null) {
in.close();
}
if (out != null) {
out.close();
}
}
}
}
 */