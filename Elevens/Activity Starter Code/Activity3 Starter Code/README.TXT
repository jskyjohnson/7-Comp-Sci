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