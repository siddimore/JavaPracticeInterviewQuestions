import java.util.Arrays;

/**
 * Created by siddimore on 6/15/16.
 */
public class fibonacciDP {

    static Integer[]lookup = null;

    public static void init(){
        lookup = new Integer[100];
        Arrays.fill(lookup,null);
    }

    public static Integer process(Integer n){

        if(lookup[n] == null){

            if(n <= 1)
                lookup[n] = n;
            else
                lookup[n] = (process(n-1) + process(n-2));
        }

        return lookup[n];
    }

    public static void main(String[] args){
        init();
        System.out.println("Fibonacci number is " + process(3));
    }
}
