/**
 * Created by MoreFamily on 5/28/2016.
 */
public class StairCaseProblem {

//    A child is climb­ing up a stair­case with n steps, and can hop
//    either 1 step, 2 steps, or 3 steps at a time.
//    Imple­ment a method to count how many pos­si­ble ways the child
//    can jump up the stairs.

//    Approach:
//
//    Say child has to take n steps.
//    At every step the child has 3 options, to take 1 step, 2 step or 3 steps.
//            So if child take 1 step then find the num­ber of ways to com­plete n-1 steps +1.
//    Sim­i­larly if child take 2 steps then find the num­ber of ways to com­plete n-2 steps +1.
//    If child take 3 step then find the num­ber of ways to com­plete n-3 steps +1.
//    So total num­ber of ways to com­plete n steps = No of ways to com­plete (n-1)steps + No of ways to com­plete (n-1)steps + No of ways to com­plete (n-1)steps +1.
//
    public static int possibleWays(int n){

        if(n < 1)
            return 0;

        return 1+possibleWays(n-1)+possibleWays(n-2)+possibleWays(n-3);
    }

    public static void main(String[] args){
        System.out.println("Possible Ways: " + possibleWays(3));
    }
}
