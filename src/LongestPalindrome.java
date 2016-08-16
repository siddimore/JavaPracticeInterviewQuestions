import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by siddimore on 6/14/16.
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }



    public static String longestPalind(String x){
        if(x.isEmpty())
            return null;

        if(x.length() ==1)
            return x;

        String longest = x.substring(0,1);

        for(int i=0; i<x.length(); i++){
            String tmp = helper(x,i,i);

            if(tmp.length() > longest.length())
                longest = tmp;
        }

        return longest;
    }
    // Given a center, either one letter or two letter,
// Find longest palindrome
    public static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("AABCddddddEBAZ"));
        System.out.println(longestPalind("AABCddddddEBAZ"));
    }




}
