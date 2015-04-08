/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

    /**
     * The main method in this class checks the Deck operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
        //         String[] ranks = {"jack", "queen", "king"};
        //         String[] suits = {"blue", "red"};
        //         int[] pointValues = {11, 12, 13};
        //         Deck d = new Deck(ranks, suits, pointValues);
        // 
        //         System.out.println("**** Original Deck Methods ****");
        //         System.out.println("  toString:\n" + d.toString());
        //         System.out.println("  isEmpty: " + d.isEmpty());
        //         System.out.println("  size: " + d.size());
        //         System.out.println();
        //         System.out.println();
        // 
        //         System.out.println("**** Deal a Card ****");
        //         System.out.println("  deal: " + d.deal());
        //         System.out.println();
        //         System.out.println();
        // 
        //         System.out.println("**** Deck Methods After 1 Card Dealt ****");
        //         System.out.println("  toString:\n" + d.toString());
        //         System.out.println("  isEmpty: " + d.isEmpty());
        //         System.out.println("  size: " + d.size());
        //         System.out.println();
        //         System.out.println();
        // 
        //         System.out.println("**** Deal Remaining 5 Cards ****");
        //         for (int i = 0; i < 5; i++) {
        //             System.out.println("  deal: " + d.deal());
        //         }
        //         System.out.println();
        //         System.out.println();
        // 
        //         System.out.println("**** Deck Methods After All Cards Dealt ****");
        //         System.out.println("  toString:\n" + d.toString());
        //         System.out.println("  isEmpty: " + d.isEmpty());
        //         System.out.println("  size: " + d.size());
        //         System.out.println();
        //         System.out.println();
        // 
        //         System.out.println("**** Deal a Card From Empty Deck ****");
        //         System.out.println("  deal: " + d.deal());
        //         System.out.println();
        //         System.out.println();

        /* *** TO BE COMPLETED IN ACTIVITY 4 *** */

        String[] ranks1 = new String[13];
        for(int i = 0; i < 13; i++){
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
        String[] suits2 = {"Spades", "Clubs", "Hearts", "Diamonds"};
        int[] values1 = new int[13];
        for(int i = 0; i < 13; i++){
            int temp = 0;
            if(i < 13){
                temp = i+1;
            }if(i == 0){
                temp = 14;
            }
            values1[i] = temp;
            //System.out.println(temp);
        }
        for(int i = 0; i < ranks1.length; i++){
            //System.out.println(ranks1[i]+" "+ suits1[i]+" "+values1[i]);
        }

        Deck Twenty1 = new Deck(ranks1, suits2, values1);
        System.out.println(Twenty1);
    }
}
