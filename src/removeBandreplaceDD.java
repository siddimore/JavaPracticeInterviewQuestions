/**
 * Created by siddimore on 6/15/16.
 */
public class removeBandreplaceDD {

    public static String process(String s){

        char[] cArray = s.toCharArray();
        int j= 0;
        int aCount =0;
        for(char c:cArray){
            if(c != 'b'){
                cArray[j] = c;
                ++j;
            }

            if(c == 'a')
                ++aCount;
        }

        char[] newArray = new char[cArray.length + aCount*2];


        return null;
    }



}
