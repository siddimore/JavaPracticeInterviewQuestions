import java.util.HashMap;
import java.util.Map;

/**
 * Created by MoreFamily on 4/24/2016.
 */
public class minimumPalinDrome {

    static Map<String, Integer> stMap = new HashMap<>();
    public static int splitRecurssion(String x){

        if(x == "" || isPalindrome(x))
        {
            return 0;
        }

        {
            int cuts = Integer.MAX_VALUE;
            for(int i=1;i<x.length();i++){
                cuts =  1+ Math.min(splitRecurssion(x.substring(0,i)),splitRecurssion(x.substring(i,x.length())));
            }
            return cuts;
        }
    }

    public static int splitDP(String x){

        if(x == "" || isPalindrome(x)){
            return 0;
        }
        else{

            int cuts = Integer.MAX_VALUE;

            for(int i=1; i< x.length(); i++){
                int leftSoln = 0;
                int rightSoln = 0;

                String leftPart = (x.substring(0,i));
                String rightPart = x.substring(i,x.length());

                if(!stMap.containsKey(leftPart)){
                    leftSoln = splitDP(leftPart);
                    stMap.put(leftPart,leftSoln);
                }
                else{
                    leftSoln = stMap.get(leftPart);
                }

                if(!stMap.containsKey(rightPart)){
                    rightSoln = splitDP(rightPart);
                    stMap.put(rightPart,leftSoln);
                }
                else{
                    leftSoln = stMap.get(rightPart);
                }

                cuts = Math.min(1+leftSoln+rightSoln, cuts);


            }

            return cuts;
        }






    }

    public static boolean isPalindrome(String x){

        int n = x.length();

        for(int i=0 ;i <n/2; i++){
            if(x.charAt(i) != x.charAt(n-1-i)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){

        long elapsedTimeRec;
        long elapsedTimeDP;
        long startTimeRec = System.currentTimeMillis();
        System.out.println("Minimum number of cuts: " +minimumPalinDrome.splitRecurssion("xaabb"));
        long stopTimeRec = System.currentTimeMillis();
        System.out.println("Time for Recursion: " + (stopTimeRec - startTimeRec));
        long startTimeDP = System.currentTimeMillis();
        System.out.println("Minimum number of cuts: " +minimumPalinDrome.splitDP("xaabb"));
        long stopTimeDP = System.currentTimeMillis();
        System.out.println("Time for DP: " + (stopTimeDP - startTimeDP));
    }
}
