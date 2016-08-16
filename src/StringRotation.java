import java.util.HashMap;
import java.util.Map;

/**
 * Created by MoreFamily on 5/29/2016.
 */
public class StringRotation {

    private String s1;
    private String s2;
    private Map<Character,Integer> charMap;

    public StringRotation(String s1, String s2){
        this.s1 = s1;
        this.s2 = s2;
        charMap = new HashMap<>();
        //s1s1 = s1+s1;

        int count = 0;
        for(Character c: s1.toCharArray()){
            charMap.put(c, count);
            ++count;
        }
    }

    public boolean checkSubString(){

        for(char c: s2.toCharArray()){
            if(!charMap.containsKey(c)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        StringRotation sR = new StringRotation("waterbottle","erbottlewat");
        System.out.println("IsSubString: " + sR.checkSubString());
    }


}

