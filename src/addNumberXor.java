/**
 * Created by siddimore on 6/18/16.
 */
public class addNumberXor {

    public static int addNumber(int x , int y){

        int carry = 0;

        while(y!=0){
            carry = x & y;
            x = x^y;
            y = carry<<1;
        }

        return x;
    }

    public static void main(String[] args){

        System.out.println("Add 2 numbers: " + addNumber(32,15));

    }


}
