import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by MoreFamily on 4/15/2016.
 */
public class AnagramSubString {

    private static ArrayList<String> aL ;
    private static String s = null;

    //
    private static String getSubString(int index, char[] cArray){
        int count = 0;
        StringBuffer sb = new StringBuffer();
        while(count != s.length() && index+count < cArray.length){
            sb.append(cArray[index+count]);
            ++count;
        }
        if(index+count >= cArray.length+1)
            sb = null;

        return sb.toString();
    }


    public static boolean anagramStringExist(String input)throws NullPointerException{
        if(input == null || input == ""){
            throw new NullPointerException("Input String cannot be null or Empty");
        }else {
            boolean bExist = false;
            String s = input.toLowerCase();
            char[] cArray = s.toCharArray();
            String returnString;
            try {
                for (int i = 0; i < cArray.length; i++) {
                    returnString = getSubString(i, cArray);
                    //System.out.println("String: " + getString4CharLong(i, cArray));
                    if (aL.contains(returnString)) {
                        System.out.println("index: " + i);
                        bExist = true;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                return bExist;
            }
        }
    }

    public static void permuteString(String input)throws NullPointerException{
        if(input == null || input == "") {
            throw new NullPointerException("Input String cannot be null or Empty");
        }
        else {
            s = input;
            aL = PermutationString.permutation(input);
        }
    }

    public static void main(String[] args){

        permuteString("aaba");
        if(anagramStringExist("AAABABAA")){
            System.out.println("Anagram Substring Exist");
        }
        else{
            System.out.println("Anagram Substring does not exist");
        }
    }

}
