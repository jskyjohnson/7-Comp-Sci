public class TestXSS{
    private static long count = 0;
    public static void main(String[] args){
        try{
            curseme(1);
        }catch(StackOverflowError e){
            System.out.println(e.getStackTrace().length);
        }
    }

    public static void curseme(long a){
        System.out.println(count++);
        curseme(a);
    }
}