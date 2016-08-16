/**
 * Created by MoreFamily on 4/9/2016.
 */
public class StrReverse {
    private String str;

    public StrReverse(String str){
        this.str = str;
    }

    public String reverseRecurse(String input){
        if(input == null || input.length() == 1)
                return input;
        return reverseRecurse(input.substring(1)) + input.charAt(0);
    }

    public static void main(String[] args){
        String str = "Hello";
        StrReverse rev = new StrReverse(str);
        String revString = rev.reverseRecurse(str);
        System.out.println("Reveresed String is: " + revString);

    }

    //Test for String reverse
    //a. null String
    //b. Empty String
    //b1. one character String
    //b2. String 'aa' which will be same
    //c. Valid String
    //d. HelloolleH
    //e. '123Hello'
    //f. 123$
    //g. $%#@
    //h. Very Large String
    //i. Localized String
    //j. Ascii Characters
    //k. Extended Ascii Characters
    //L. Not a null terminated String
}
