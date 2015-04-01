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