/**
 * Created by siddimore on 6/19/16.
 */
public class PrimeNumber {

    public static boolean process(int num){

        for(int i= 2; i<= num/2; i++){
            if(num% i == 0)
                return false;
        }
        return true;
    }

    public static int fibonacci(int num){

        int sum;

        if(num == 0)
        return 0;
        else if (num == 1){
            return 1;
        }
        else {
            sum = fibonacci(num-1) + fibonacci(num-2);
            return sum;
        }

    }



    public static void main(String[] args){

        System.out.println("Fibonacci: " + fibonacci(4));
        System.out.println("Prime Number: " + process(49));

    }




}
