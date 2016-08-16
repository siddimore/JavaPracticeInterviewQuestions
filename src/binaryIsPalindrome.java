import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by siddimore on 8/4/16.
 */
public class binaryIsPalindrome {

    private int number;
    private boolean isPalindrome;
    private  Stack<Integer> binStack;
    private List<Integer> bitList;

    public binaryIsPalindrome(int number){
        this.number = number;
        this.isPalindrome = false;
        bitList = new ArrayList<>();
    }

    public boolean process(){

        binStack = new Stack<>();

        while(number > 0){
            int rem = number % 2;
            number = number / 2;
            binStack.push(rem);
        }

        if(binStack.size() > 0){
            while(binStack.size() != 0)
            bitList.add(binStack.pop());

            for( int i = 0; i < bitList.size()/2; i++ )
                if (bitList.get(i) != bitList.get(bitList.size()-i-1)) return false;
            }

        return true;
        }

    public static void main(String[] args){
        binaryIsPalindrome bPalin = new binaryIsPalindrome(15);
        System.out.print("IsPalindrome: " + bPalin.process());
    }

}


