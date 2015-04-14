Activity 2

1. Deck is a holder for many cards, like an array is a holder for many ints

2. only 2, and one null 

3. String[] ranks1 = new String[52];
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
        
        
4. Yes it does, because if they become out of order everything gets weird


Activity 3

1. public static String flip(){
        Random r = new Random();
        int test1 = r.nextInt(3);
        if(test1==0){
            return "tails";
        }
        return "heads";
    }
    
2.  public static boolean arePermutations(int[] a, int[] b){
        for(int i = 0; i < a.length; i++){
            boolean test1 = true;
            for(int k = 0; k < b.length; k++){
                if(a[i] == b[k]){
                    test1 = false;
                }
            }
            if(test1){
                return false;
            }

        }
        return true;
    }
3. 1, 2,2,2

Activity 6

1. (5,6) (5,6)

2. yes because in all other instances you're taking 2 out at a time. The only way to have an odd number in the deck is by removing an add number of JQK

3. If one keeps track of the cards already played, they'ed want to stick away from cards that have already been used. That way there's more chance of the other cards that don't require the specific other pair.

Activity 7

1. A deck of cards

2. Deal the cards out, then scan the delt cards for matchs, then pick any matches, then replace the matches, continue on until game is either won or lost

3. Yes, if it was completed

4. a. When a new game is made the cards are delt out.

   b. the Is Legal Method and when checking if another pair is possible
   
   c. 0, 1, 3, 6, 7, null, null, null, nullmage
   
   d.
   
public static printCards(ElevensBoard board) {
List<Integer> cIndexes = board.cardIndexes();
    for(Card card : cIndexes){
       System.out.println(cIndexes.toString());
    }
}
    
    e. AnotherPlayIsPossible(), since in is legal, the move is already provided with the indexes
    
    
 Activity 8
 
 1. All of them have similar characteristics, e.g. Cards that are delt out in the same manner, matching up too a value, and also matching faces~

2. Inheriting is the Mechanism. When someone creates and ElevensBoard, since it inherits from the Board abstract, the board abstract is generally run too (the constructor that is)

3. Yes, the open methods are the only ones that need to be changed from either game modes

Activity 9

1. Board size is an instance variable, but the size function doesn't exist in the board class, instead it only deals with Decks, which are always the same for all types of games, so there's no reason to make it abstract

2. Similar to question 1, it's because the actual cards are a different object, the deck object, which is univeral for all types of games.

3. Yes, it would still work polymorphically. The new design would also work but it might be a bit more technical telling the difference between the types of games.


 
 




