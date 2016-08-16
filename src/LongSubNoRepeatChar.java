import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by siddimore on 6/18/16.
 */
public class LongSubNoRepeatChar {

    private static String extractMap(Map<Character, Integer> map){

        StringBuffer sB = new StringBuffer();
        Iterator it = map.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<Character,Integer> entry = (Map.Entry<Character,Integer>) it.next();
            sB.append(entry.getKey());
        }

        return sB.toString();
    }

//    private static String processMap(String input){
//
//        Map<Character,Integer> repeatMap = new LinkedHashMap<>();
//        int i = 0;
//
//        String longestStringSoFar = "";
//        do{
//
//            if(!repeatMap.containsKey(input.charAt(i))){
//                repeatMap.put(input.charAt(i),i);
//            }
//            else{
//
//                //get the index of repeated character
//                int val = repeatMap.get(input.charAt(i));
//                i = val;
//                //Get String and compare with LongestString so far
//                String retString = extractMap(repeatMap);
//                repeatMap.clear();
//                if(longestStringSoFar.length() < retString.length()){
//                    longestStringSoFar = retString;
//                }
//            }
//            i++;
//
//        }while(i < input.length());
//
//        return longestStringSoFar;
//    }


    private static String repeat2characters(String input){

        Map<Character, Integer> m = new HashMap<>();
        int uniqChar = 0;
        StringBuffer sb = new StringBuffer();
        String longestSoFar = "";
        int lastIndex = 0;
        int i= 0;
        for(i=0; i<input.length(); i++)
        {

            char c = input.charAt(i);

            if(!m.containsKey(c)){
                m.put(c, i);
                lastIndex = i;
            }

            if(m.size()<=2){
                sb.append(c);
            }
            else{

                //decrement once
                //ex: abcbbccbb here we start with a add a, b, c to map because they are uniqure and our lastindex =2
                //now since map size is greater than 2 now we get longestString since we only want to have
                // string with 2 unique character, our next search should now start from 'b' which is index 1
                //so we decrement lastIndex by 1.
                i = lastIndex-1;
                //Second decrement is because of forLoop after we exit below loop
                //for loop will increment i to accomodate for that fact decrement by other 1
                //which equates to i = lastIndex-1-1;
                --i;
                String retString = sb.toString();
                sb = new StringBuffer();
                if(retString.length() > longestSoFar.length()){
                    longestSoFar = retString;
                }
                m.clear();
            }
        }

        return  longestSoFar;

    }

    public static void main(String[] args){
        System.out.println("Longest: " + repeat2characters("abcbbbbcccbdddadacb"));
    }


}
