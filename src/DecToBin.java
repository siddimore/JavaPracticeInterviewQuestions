import java.util.Stack;

/**
 * Created by MoreFamily on 4/16/2016.
 */
public class DecToBin {

    private int num;
    private Stack<Integer> s;
    public DecToBin(int num){
        this.num = num;
        s = new Stack<>();
    }

    public Stack<Integer> convertToBin(){

        while(num != 0){
            int d = num%2;
            s.push(d);
            num = num/2;
        }
        return s;
    }

    public static void main(String[] args){
        DecToBin dToB = new DecToBin(5);
        Stack<Integer> iS = dToB.convertToBin();
        while(!iS.empty()){
            System.out.print(iS.pop());
        }
    }
}
