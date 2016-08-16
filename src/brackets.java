import java.util.Stack;

/**
 * Created by siddimore on 7/23/16.
 */
public class brackets {

    public static boolean bracket(String str){

        Stack<Character> charStack = new Stack<>();
        Stack<Character> revStack = new Stack<>();

        String a = new String(str);

        char[] cArray = str.toCharArray();

        for (Character ch: cArray){
            charStack.push(ch);
        }

        for(int i= cArray.length-1; i >= 0; i--){
            revStack.push(cArray[i]);
        }

        if (revStack.size() != charStack.size())
            return false;
        else{

            for(int i=0; i< charStack.size(); i++){

                char ch = charStack.pop();
                char revCh = revStack.pop();

                if(ch == '{'){
                    if(revCh != '}')
                        return false;

                }

                if(ch == '['){
                    if(revCh != ']')
                        return false;
                }

                if(ch == '('){
                    if(revCh != ')')
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){

        System.out.println("Balanced brackets: " + bracket("({[]})"));
    }
}
