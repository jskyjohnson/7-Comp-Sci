public class fIB{
    public static void main(String[] args){
        for(int i = 0; i < 7; i++){
            System.out.println(fIBS(i));
        }
    }
    public static int fIBS(int i){
        if(i<2){
            return 1;
        }
        return fIBS(i-1)+(fIBS(i-2));
        
    }
}