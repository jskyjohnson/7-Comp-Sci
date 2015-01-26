import java.util.*;
import java.io.*;

public class party{
    public static ArrayList<String> a = new ArrayList<String>();
    private static int thisjacksonchen = 0;
    public static void main(String[] args)throws FileNotFoundException{
        File k = new File("lastnames-sorted.txt");
        Scanner ps = new Scanner(k);
        int i = 0;

        while(ps.hasNextLine()){
            a.add(ps.nextLine());
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Who would you like to look for? : ");
        String target = in.nextLine();
        target = target.toUpperCase();
        System.out.println("Looking For : "+target);

        int asd = search(target,0,a.size(),0);
        if(asd > 0){
            System.out.println(asd);
            System.out.println(a.get(asd));
        }else{
            System.out.println("Not Found");
        }
        System.out.println(thisjacksonchen);
        System.out.println(badsearch( target));
    }

    public static int search(String p , int first, int last,int limit){
        // System.out.println("Searching");
        //System.out.println(a.get(50));
        thisjacksonchen++;
        if(limit>20){
            return -1;
        }else{
            limit++;
        }
        int result = -1;
        int mid = (first+last)/2;
        System.out.println(a.get(mid)); 
        if(p.compareTo(a.get(mid)) == 0){
            result = mid;
        }else if(p.compareTo(a.get(mid)) < 0){
            result= search(p, first, mid -1,limit);
        }else if(p.compareTo(a.get(mid)) > 0){
            result = search(p, mid+1 , last,limit);
        }
        return result;
    }
    public static int badsearch(String p){
        for(int i = 0; i < a.size(); i++){
            if(p.equals(a.get(i)))
            {
                return i;
            }
        }
        return -1;
    }
}