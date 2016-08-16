import java.util.ArrayList;

/**
 * Created by MoreFamily on 4/3/2016.
 */
public class PermutationString {

    private static ArrayList<String> aL = new ArrayList<>();

    public static ArrayList<String> permutation(String input)
    {
        premute("",input);

        return aL;
    }

    private static ArrayList<String> premute(String perm, String word)
    {
        if(word.isEmpty())
        {
            aL.add(perm + word);
            System.err.println(perm + word); }
        else {
            for (int i = 0; i < word.length(); i++){
                premute(perm + word.charAt(i), word.substring(0,i) + word.substring(i + 1, word.length()));
            }
        }
        return aL;
    }

    public static int MaxSum (int[] A)
    {
        int sum = 0;
        int maxSum = 0;

        for(int i= 0; i < A.length; i++)
        {
            sum += A[i];
            maxSum = Math.max(maxSum, sum);

            if(sum < 0)
                sum = 0;
        }

        return maxSum;
    }

    public static void main(String[] args)
    {
        PermutationString.permutation("abcd");

        //String[] B = new
        int[]A = {-2, 1,-3,4,-1,2,1,-5,4};
        //A = {−2,1,−3,4,−1,2,1,−5,4};//{-2 , 1, 4, -7 ,5, -9};
        System.out.println("MaxSum+ " + Integer.toString(PermutationString.MaxSum(A)));

    }



}
