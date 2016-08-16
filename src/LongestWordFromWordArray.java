import java.util.*;
import java.util.stream.Collector;

/**
 * Created by siddimore on 6/15/16.
 */
//        given 2 arrays wrds[] , chars[] as an input to a function such that
//        wrds[] = [ "abc" , "baa" , "caan" , "an" , "banc" ]
//        chars[] = [ "a" , "a" , "n" , "c" , "b"]
//        Function should return the longest word from words[] which can be constructed from the chars in chars[] array.
//        for above example - "caan" , "banc" should be returned
//
//        Note: Once a character in chars[] array is used, it cant be used again.
//        eg: words[] = [ "aat" ]
//        characters[] = [ "a" , "t" ]
//        then word "aat" can't be constructed, since we've only 1 "a" in chars[].



public class LongestWordFromWordArray {

    List<String> sL = new ArrayList<>();
    static Map<Character,Integer> charMap = null;
    static int longestWord = 0;

    //process word array to find longestWord from character array
    public static int process(String[] words){
        Map<Character, Integer> m = new HashMap<>();

        for(String s:words){
            for(int i=0; i<s.length();i++){
            if(!m.containsKey(s.charAt(i))){
                m.put(s.charAt(i),1);
            }
            else{
                int count = m.get(s.charAt(i));
                ++count;
                m.put(s.charAt(i),count);
            }
        }
            int l = checkValid(m,charMap);

            if(l > longestWord){
                longestWord = l;
            }
            m.clear();
        }

        return longestWord;

    }

    //check wordMap against CharacterMap
    public static int checkValid(Map<Character,Integer> mWord, Map<Character,Integer> mChar){

        Iterator it = mWord.entrySet().iterator();
        int longest = 0;

        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            int countWord = (int)pair.getValue();
            if(!mChar.containsKey(pair.getKey())){
                return 0;
            }
            else{
                if(countWord>mChar.get(pair.getKey() )){
                    return 0;
                }else longest = longest+countWord;
            }
        }
        return longest;
    }

    //build CharacterMap from character array
    public static Map<Character, Integer> buildMap(char[] input){

        Map<Character, Integer> m = new HashMap<>();

        for(char c: input){

            if(!m.containsKey(c)){
                m.put(c,1);
            }
            else{
                int count = m.get(c);
                ++count;
                m.put(c,count);
            }
        }

        return m;

    }

    public static void main(String[] args){

        String[] words = {"abc" , "baa" , "caan" , "an" , "banc"};
        charMap = buildMap(new char[]{'a','a','n','c','b'});
        System.out.println(process(words));

    }

}
