/**
 * Created by siddimore on 6/15/16.
 */
public class LongestPalindromSubstringDP {

    public static String LPS(String s){

        int n = s.length();
        int palindromeBeginsAt = 0;
        int max_len =1;

        boolean palindrome[][] = new boolean[n][n];

        //Single letter palindromes
        for(int i=0; i< n; i++)
            palindrome[i][i] = true;

        //Two character palindromes
        for(int i=0; i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                palindrome[i][i+1] = true;
                palindromeBeginsAt = i;
                max_len = 2;
            }
        }

        //Finding palindromes of length 3 to n and saving longest palindrome
        for(int curr_len = 3; curr_len <= n; curr_len++){
            for(int i=0; i<n-curr_len+1;i++){
                int j = i+curr_len-1;

                if(s.charAt(i) == s.charAt(j)  //1. The first and last characters should match
                        && palindrome[i+1][j-1]) //2. Rest of the substring should be a palindrome
                {
                    palindrome[i][j] = true;
                    palindromeBeginsAt = i;
                    max_len = curr_len;
                }
            }
        }

        return s.substring(palindromeBeginsAt, max_len + palindromeBeginsAt);
    }

    public static void main(String args[])
    {
        System.out.println(LPS("bananas"));
    }



}
