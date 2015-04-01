/**
 * This is a class that tests the Deck class.
 */
import java.util.Random;

public class DeckTester {

    /**
     * The main method in this class checks the Deck operations for consistency.
     *  @param args is not used.
     */
    public static void main(String[] args) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        
        String[] ranks = {"a","b","c","d","e"};
        String[] suits = {"z","x","i","v","n"};
        int[] values = {1,3,5,6,7,43};
        
        Deck newDeck = new Deck(ranks, suits, values);
        
        System.out.println(newDeck);
        
        newDeck.deal();
        
        System.out.println(newDeck);
        
        String[] ranks1 = new String[52];
        for(int i = 0; i < 52; i++){
            String temp = "";
            if( i%13 == 0){
                temp = "Ace";
            }else if( i%13 > 9){
                if( (i %13)% 10 == 0){
                    temp = "Jack";
                }
                
                if( (i%13) % 11 == 0){
                    temp = "Queen";
                }
                
                if( (i%13)%12 == 0){
                    temp = "King";
                }
            }else{
                int k = (i+1)%13;
                temp = Integer.toString(k);
            }
            ranks1[i] = temp;
            
            //System.out.println(temp);
        }
        String[] suits1 = new String[52];
        for(int i = 0; i < 52; i++){
            String temp = "";
            if(i < 14){
                temp = "Spade";
            }else if(i<13+13){
                temp = "Club";
            }else if(i<13+13+13){
                temp = "Heart";
            }else if(i<13+13+13+13){
                temp = "Diamond";
            }
            suits1[i] = temp;
            //System.out.println(temp);
        }
        int[] values1 = new int[52];
        for(int i = 0; i < 52; i++){
            int temp = 0;
            if(i < 13){
                temp = i;
            }else if(i<13+13){
                temp = i-13;
            }else if(i<13+13+13){
                temp = i-13-13;
            }else if(i<13+13+13+13){
                temp = i-13-13-13;
            }
            values1[i] = temp;
            //System.out.println(temp);
        }
        for(int i = 0; i < ranks1.length; i++){
           //System.out.println(ranks1[i]+" "+ suits1[i]+" "+values1[i]);
        }
        
        Deck Twenty1 = new Deck(ranks1, suits1, values1);
        System.out.println(Twenty1);
    }
}
