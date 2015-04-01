public class CaesarTester
{
    public static void main(String[] args)
    {
        System.out.println("Test 1 - simple encrypt:");
        System.out.println("Expected: ifmmp");
        System.out.println("Actual: " + CaesarCipher.encrypt("hello", 1));
        System.out.println();
        
        System.out.println("Test 2 - simple decrypt:");
        System.out.println("Expected: hello");
        System.out.println("Actual: " + CaesarCipher.decrypt("ifmmp", 1));
        System.out.println();
        
        System.out.println("Test 3 - simple encrypt w/ casing:");
        System.out.println("Expected: kSSHfcI");
        System.out.println("Actual: " + CaesarCipher.encrypt("gOODbyE", 4));
        System.out.println();
        
        System.out.println("Test 4 - simple decrypt w/ casing:");
        System.out.println("Expected: gOODbyE");
        System.out.println("Actual: " + CaesarCipher.decrypt("kSSHfcI", 4));
        System.out.println();
        
        System.out.println("Test 5 - simple encrypt w/ casing and symbols:");
        System.out.println("Expected: Mdyd lv Juhdw! Grq'w brx djuhh? :)");
        System.out.println("Actual: " + CaesarCipher.encrypt("Java is Great! Don't you agree? :)", 3));
        System.out.println();
        
        System.out.println("Test 6 - simple decrypt w/ casing and symbols:");
        System.out.println("Expected: Java is Great! Don't you agree? :)");
        System.out.println("Actual: " + CaesarCipher.decrypt("Mdyd lv Juhdw! Grq'w brx djuhh? :)", 3));
        System.out.println();
        
        System.out.println("Test 7 - complex encrypt:");
        System.out.println("Expected: Sio ain cn! Hi $$$ vlcvym hywymmuls, lcabn?");
        System.out.println("Actual: " + CaesarCipher.encrypt("You got it! No $$$ bribes necessary, right?", 20));
        System.out.println();
        
        System.out.println("Test 8 - complex decrypt:");
        System.out.println("Expected: You got it! No $$$ bribes necessary, right?");
        System.out.println("Actual: " + CaesarCipher.decrypt("Sio ain cn! Hi $$$ vlcvym hywymmuls, lcabn?", 20));
        System.out.println();
    }
}