import java.util.ArrayList;
import java.util.List;

/**
 * Created by MoreFamily on 4/23/2016.
 */
public class LongestCommonSequence {

    static List<Character> al = new ArrayList<>();

    public static int returnCommonSequenceSum(String a, String b){

        if(a.length() == 0 || b.length() == 0)
            return 0;

        int lenA = a.length();
        int lenB = b.length();

        if(a.charAt(lenA -1) == b.charAt(lenB-1)){
            return 1 + returnCommonSequenceSum(a.substring(0, lenA-1),
                    b.substring(0, lenB -1));
        }else{
            return Math.max(returnCommonSequenceSum(a.substring(0, lenA-1),
                    b.substring(0, lenB)),returnCommonSequenceSum(a.substring(0, lenA),
                    b.substring(0, lenB-1)));
        }

        //return 0;
    }

    public static void main(String[] args){

       System.out.println("Sum of LCS: " + returnCommonSequenceSum("acbaed", "abcadf"));
        for(char a: al){
            System.out.println(a);
        }
    }
}
