/**
 * Created by MoreFamily on 5/7/2016.
 */
public class replacespace {

    private String s;
    private char[] cArray;
    private char[] newcArray;
    private int spaceCount = 0;
    public replacespace(String s){
        this.s = s;
        cArray = s.toCharArray();
    }

    private String process(){

        for(char c: cArray){
            if(c == ' '){
                ++spaceCount;
            }
        }
        //Create new Array replacing space with %20
        newcArray = new char[cArray.length + spaceCount*2];

        int j = newcArray.length -1;
        for(int i= cArray.length-1; i>=0; i-- ){
            if(cArray[i] != ' '){
                newcArray[j] = cArray[i];
            }
            else{
                newcArray[j] = '0';
                newcArray[j-1] = '2';
                newcArray[j-2] = '%';
                j = j-2;
            }
            --j;
        }

        return new String(newcArray);
    }

    public String ModifyString(){
        return process();
    }

    public static void main(String[] args){

        replacespace rS = new replacespace("Hello There How Are You?");
        System.out.println("String before Modification: " + rS.s);
        System.out.println("Modified String: " + rS.ModifyString());

    }
}
