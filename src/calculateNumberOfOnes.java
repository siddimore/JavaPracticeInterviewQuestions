/**
 * Created by siddimore on 8/1/16.
 */
public class calculateNumberOfOnes {

    private static int CalculateOnes(int number){

        int count = 0;
        while(number > 0){
            count += number & 1;
            number = number >> 1;
        }

        return count;
    }

    public static void main(String[] args){
        System.out.print("No of ones: " + CalculateOnes(10));
    }

}
