import java.util.Stack;

/**
 * Created by siddimore on 6/4/16.
 */
public class MinStackO_1 {

    Stack<Integer> s;
    Integer minEle;

    //Constructor
    MinStackO_1()
    {
        s = new Stack<>();
    }

    void getMin(){
        if(s.isEmpty()){
            System.out.println("Stack is Empty");
        }
        else{
            System.out.println("Min element in Stack is:" + minEle);
        }
    }

    void peek(){
        if(s.isEmpty()){
            System.out.println("Stack is empty");
            return;
        }

        Integer t = s.peek();
        System.out.println("Top most Element is: ");

        if(t < minEle){
            System.out.println(minEle);
        }
        else System.out.println(t);
    }

    void pop(){
        if(s.isEmpty()){
            System.out.println("Stack is empty");
            return;
        }

        Integer t = s.peek();
        System.out.println("Top most Element is: ");

        if(t < minEle){
            System.out.println(minEle);
           // minEle = 2
        }
        else System.out.println(t);
    }


}
