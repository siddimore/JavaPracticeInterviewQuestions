import java.util.Stack;

/**
 * Created by MoreFamily on 4/21/2016.
 */
public class queuetwoStacks {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    final int MAX_SIZE = 50;

    public queuetwoStacks(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public boolean enQueue(int Val){

        if(s1.size() < MAX_SIZE){
        s1.push(Val);
        return true;}

        return false;
    }


    public int deQueue(){
        while(s1.size() != 1){
            s2.push(s1.pop());
        }
        int top = s1.pop();

        while(s2.size() != 0){
            s1.push(s2.pop());
        }

        return top;
    }

    public static void main(String[] args){
        queuetwoStacks q2Stack = new queuetwoStacks();
        q2Stack.enQueue(1);
        q2Stack.enQueue(2);
        q2Stack.enQueue(3);
        System.out.println(q2Stack.deQueue());
        System.out.println(q2Stack.deQueue());

    }
}
