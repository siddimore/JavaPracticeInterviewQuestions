import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by siddimore on 6/18/16.
 */
public class isomorphicStrings {

    public static int getCount(Map<Character, Integer> m, char c){
        return m.get(c);
    }

    public static boolean processIsomorphic(String s1, String s2){

        if(s1.length() != s2.length() || s1 == null || s2 == null)
            return false;

        Map<Character, Character> m = new HashMap<>();

        for(int i= 0; i< s1.length(); i++){

            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if(m.containsKey(c1)){
                if(m.get(c1) != c2)
                    return false;
            }
            else {

                if(m.containsValue(c2))
                    return false;

                m.put(c1,c2);
            }

        }
        return true;
    }


    public static void main(String[] args){

        System.out.println("Is Ismorphic: " + processIsomorphic("egg", "add"));
        System.out.println("Is Ismorphic: " + processIsomorphic("egg", "xyz"));
        System.out.println("Is Ismorphic: " + processIsomorphic("dda", "egg"));

    }
}
