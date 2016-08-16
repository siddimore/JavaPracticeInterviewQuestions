import java.util.ArrayList;
import java.util.List;

/**
 * Created by MoreFamily on 4/23/2016.
 */
public class MaxSubarray {

    public static List<Integer> al = null;
    public static int kadane(int[] arr){

        int max_end = 0;
        int max_sofar = 0;
        al = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 0;

        for(int i=0; i< arr.length; i++){
            max_end += arr[i];
            //al.add(arr[i]);
            if(max_end < 0){
                startIndex = i+1;
                max_end = 0;
                //al.clear();
            }
//            else{
//                al.add(arr[i]);
//            }

            if(max_sofar < max_end){
                max_sofar = max_end;
            }

        }
        return max_sofar;
    }

    public static void main(String[] args){
        System.out.println("Max SubArray: " +kadane(new int[]{-2, 1,-3,4,-1,2,1,-5,4}));
        for(int i: al){
            System.out.print(i + " ");
        }
    }
}
