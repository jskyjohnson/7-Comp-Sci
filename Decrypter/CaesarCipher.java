/**
 * CaesarCipher
 * 
 * Matthew Harwit
 * March 7 2015
 */
class CaesarCipher
{
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALPHABETUP = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String encrypt(String plainText,int shiftKey)
    {
        plainText = plainText.toLowerCase();

        String cipherText="";
        for(int i=0;i<plainText.length();i++)
        {
            int charPosition = ALPHABET.indexOf(plainText.charAt(i));
            int keyVal = (shiftKey+charPosition)%26;
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
    }

    public static String decrypt(String cipherText, int shiftKey)
    {
        int k = 26 - shiftKey; // We can decrypt something by just encrypting it the key amount in the reverse direction, or since encrpyt (currently) can't take a negitive in this case, cause i'm lazy, we can just subtract the difference of the Key by the length of the alphabet (26)
        String decrypted = encrypt(cipherText, k); //returns the message Unencrypted
        return decrypted;
    }
}

// By Sky Johnson
// 3/7/2015
// using only the methods suggested to consider in Cawelti's hints, https://www.fairviewhs.org/system/files/28988/original/assignment-14-caesar-cipher.pdf?1425316386
// import java.util.ArrayList;
// public class CaesarCipher
// {
// 
//     public static String encrypt(String message, int key)
//     {
//         String alphaLower = "abcdefghijklmnopqrstuvwxyz";// lower case alphabet
//         String alphaUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";//upper case alphabet
//         String enc = "";
//         for(int i = 0; i < message.length(); i++){
//             if( alphaLower.indexOf(message.substring(i, i+1)) == -1 && alphaUpper.indexOf(message.substring(i, i+1)) > -1 ){ // this is to check to make sure that this current value of message exists within the alphabets (lower and upper)
//                 int cur = alphaUpper.indexOf(message.substring(i, i+1)) + key; //We add the Key value here
//                 cur %= alphaUpper.indexOf("Z")+1; // +1 since strings store similar to arrays (index of z is 25, we want 26)
//                 enc+= alphaUpper.substring(cur, cur+1 );
//             }else if (alphaLower.indexOf(message.substring(i, i+1)) > -1){ //Same thing as for upper case, but instead uses alphaLower for compares, this check is to see if the symbol exists in the alphabet
//                 int cur = alphaLower.indexOf(message.substring(i, i+1)) + key; //We add the Key value here
//                 cur %= alphaLower.indexOf("z")+1; // +1 since strings store similar to arrays (index of z is 25, we want 26)
//                 enc+= alphaLower.substring(cur, cur+1 );
//             }else{ //just add the symbol to the encrpyt method if it exists outside the alphabet
//                 enc+=message.substring(i, i+1);
//             }
//         }
//         return enc;
//     }
// 
//     public static String decrypt(String message, int key)
//     {
//         int k = 26 - key; // We can decrypt something by just encrypting it the key amount in the reverse direction, or since encrpyt (currently) can't take a negitive in this case, cause i'm lazy, we can just subtract the difference of the Key by the length of the alphabet (26)
//         String decrypted = encrypt(message, k); //returns the message Unencrypted
//         return decrypted;
//     }
// }