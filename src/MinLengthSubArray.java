/**
 * Created by siddimore on 6/15/16.
 */
public class MinLengthSubArray {

    public static int process(int[] array, int k){

        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;

        int sum = 0;

        for(int i=0; i<array.length;i++){
            for(int j = i; j<array.length; j++){
                sum += array[j];
                if(sum == k){
                    start = i;
                    end = j;
                    int length = end - start + 1;
                    if(length < minLength){
                        minLength = length;
                    }
                    break;
                }
            }
            sum = 0;
        }
        return minLength;
    }

public static void main(String[] args){

    int[]a = {2,3,1,1,-1,3,4};
    System.out.println(MinLengthSubArray.process(a, 2));

}

}
