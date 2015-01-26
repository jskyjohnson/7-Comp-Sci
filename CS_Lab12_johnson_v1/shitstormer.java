import java.util.*;
/**
 * Write a description of class shitstormer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class shitstormer
{
    int asdf;
    int fdsa;
    int sdsd;
    public shitstormer(int a, int b, int c){
        asdf = a;
        fdsa = b;
        sdsd = c;
    }
    void shuffle(Object[] arr){
        Random durrian = new Random();
        ArrayList<Integer> passionFruit = new ArrayList<Integer>(arr.length);
        for( int banana = 0; banana < arr.length; banana++){
            passionFruit.set(banana, durrian.nextInt(arr.length));
            
        }
        
        for(int kappa = 0; kappa < arr.length; kappa++){
            Object apple = arr[kappa];
            Object coconut = arr[passionFruit.get(kappa)];
            arr[kappa] = coconut;
            
            arr[passionFruit.get(kappa)] = apple;
            
        }
    }
}
