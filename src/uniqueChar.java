import java.util.Arrays;

/**
 * Created by MoreFamily on 4/25/2016.
 */
public class uniqueChar {
    private boolean[] bChar;
    private String s;
    public uniqueChar(String input){
        this.s = input;
        bChar = new boolean[256];
        Arrays.fill(bChar, false);
    }

    public boolean process(){

        for(char readChar: s.toCharArray()){

            if(bChar[readChar] == false){
                bChar[readChar] = true;
            }
            else
                return false;
        }

        return true;
    }

    public static void main(String[] args){
        uniqueChar uC = new uniqueChar("This sing");
        if(uC.process()){
            System.out.println("String content is unique");
        }
        else{
            System.out.println("String content is not unique");
        }
    }


}
