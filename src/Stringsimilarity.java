/**
 * Created by MoreFamily on 4/19/2016.
 */
public class Stringsimilarity {

    private String subString;
    private char[] cArray;
    private int sum = 0;
    private int count;

    //Constructor
    public Stringsimilarity(String input){
        this.subString = input;
        cArray = subString.toCharArray();
    }

    //return count of common characters
    private int getCountCommonChar(String input){
        count = 0;
        char[] inputArray = input.toCharArray();
        for(int i=0; i < inputArray.length; i++){
            if(cArray[i] != inputArray[i])
                return count;
            else
                ++count;
        }

        return count;
    }

    //return SubString for input String
    private String getSubString(String input){
        return input.substring(1);
    }

    //Total sum
    public int getSum(){
        do{
            sum += getCountCommonChar(subString);
            subString = getSubString(subString);
        }while(subString.length() > 0);
        return sum;
    }

    public static void main(String[] args){
        Stringsimilarity st = new Stringsimilarity("aa");
        System.out.println(st.getSum());
    }
}
