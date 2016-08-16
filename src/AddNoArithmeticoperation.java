/**
 * Created by siddimore on 7/29/16.
 */
public class AddNoArithmeticoperation {

    private static int addNoArithmetic(int x, int y){

        while(y!=0){

            int carry = x&y;
            x = x^y;
            y = carry<<1;
        }

        return x;
    }

    private static int subtractNoArithmetic(int x, int y){
        while(y!=0){

            int borrow = (~x)&y;
            x = x^y;
            y = borrow<<1;

        }

        return x;
    }

    public static void main(String[] args){
        System.out.println("Add two numbers " + addNoArithmetic(10,10));
        System.out.println("Add two numbers " + subtractNoArithmetic(10,10));
    }


}
